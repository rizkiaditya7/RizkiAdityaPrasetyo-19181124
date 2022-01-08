package com.example.rizkiadityaprasetyo_1918124;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private com.example.rizkiadityaprasetyo_1918124.MyDatabase db;
    private List<tni> Listtni = new ArrayList<tni>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new com.example.rizkiadityaprasetyo_1918124.MyDatabase(this);

        adapter_off = new CustomListAdapter(this, Listtni);
        mListView = (ListView) findViewById(R.id.list_tni);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        Listtni.clear();

        List<tni> tni = db.Readtni();
        for (tni x : tni) {
            tni daftar = new tni();
            daftar.set_id(x.get_id());
            daftar.set_nama(x.get_nama());
            daftar.set_umur(x.get_umur());
            daftar.set_pangkat(x.get_pangkat());
            daftar.set_satuan(x.get_satuan());
            Listtni.add(daftar);
            if ((Listtni.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada datanya", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        tni detailtni = (tni) o;

        String Sid = detailtni.get_id();
        String Snama = detailtni.get_nama();
        String Sumur = detailtni.get_umur();
        String Spangkat = detailtni.get_pangkat();
        String Ssatuan = detailtni.get_satuan();

        Intent goUpdel = new Intent(MainRead.this,
                com.example.rizkiadityaprasetyo_1918124.MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iumur", Sumur);
        goUpdel.putExtra("Ipangkat", Spangkat);
        goUpdel.putExtra("Isatuan", Ssatuan);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Listtni.clear();
        mListView.setAdapter(adapter_off);

        List<tni> tni = db.Readtni();
        for (tni x : tni) {
            tni daftar = new tni();
            daftar.set_id(x.get_id());
            daftar.set_nama(x.get_nama());
            daftar.set_umur(x.get_umur());
            daftar.set_pangkat(x.get_pangkat());
            daftar.set_satuan(x.get_satuan());
            Listtni.add(daftar);

            if ((Listtni.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada datanya", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}