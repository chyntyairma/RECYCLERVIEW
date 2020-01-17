package com.example.rpl2016_04.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText etuser;
    private EditText etPassword;
    private Button btntambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etuser = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);


        btntambah = findViewById(R.id.btntambah);
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent( MainActivity.this, Register.class);
                startActivity(myIntent);
            }
        });

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = etuser.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty()){
                    Toast.makeText( MainActivity.this, "ini tidak Boleh kosong", Toast.LENGTH_SHORT).show();
                }
                if (password.isEmpty()){
                    Toast.makeText( MainActivity.this, "ini tidak Boleh kosong", Toast.LENGTH_SHORT).show();
                    return;
            }

                AndroidNetworking.post(BaseURL.url+"/login.php")
                        .addBodyParameter("username", username)
                        .addBodyParameter("password", password)
                        .setPriority(Priority.LOW)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONObject hasil = response.getJSONObject("hasil");
                                    boolean sukses = hasil.getBoolean("sukses");
                                    System.out.println("ttttttttt " + sukses);
                                    if(sukses) {
                                        Intent myIntent = new Intent(MainActivity.this, MainMenu.class);
                                        startActivity(myIntent);
                                        Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    System.out.println("ttttttttt " + e.getMessage());
                                    Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                System.out.println("error " + anError);
                                System.out.println("error " + anError.getErrorBody());
                                System.out.println("error " + anError.getErrorDetail());
                                System.out.println("error " + anError.getResponse());
                                System.out.println("error " + anError.getErrorCode());

                                Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                            }
                        });
        };
    });
    }
}
