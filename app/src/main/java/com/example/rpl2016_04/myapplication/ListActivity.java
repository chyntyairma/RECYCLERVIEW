package com.example.rpl2016_04.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Siswa> rvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initDataset();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter(rvData);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void initDataset(){


        Siswa siswa1 = new Siswa();
        siswa1.setNama("Ladeng");
        siswa1.setKelas("12");
        siswa1.setAlamat("Mijen");
        rvData.add(siswa1);

        Siswa siswa2 = new Siswa();
        siswa1.setNama("Mlenos");
        siswa1.setKelas("12");
        siswa1.setAlamat("Sendang");
        rvData.add(siswa2);

        Siswa siswa3 = new Siswa();
        siswa1.setNama("Melisa");
        siswa1.setKelas("12");
        siswa1.setAlamat("Kaliwungu");
        rvData.add(siswa3);
    }
    }
