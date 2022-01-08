package com.example.rizkiadityaprasetyo_1918124;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sumur, Spangkat ,Ssatuan;
    private EditText Enama, Eumur, Epangkat, Esatuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updel);
        db = new MyDatabase(this);

        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sumur = i.getStringExtra("Iumur");
        Spangkat = i.getStringExtra("Ipangkat");
        Ssatuan = i.getStringExtra("Isatuan");

        Enama = (EditText) findViewById(R.id.updel_nama);
        Eumur = (EditText) findViewById(R.id.updel_umur);
        Epangkat = (EditText) findViewById(R.id.updel_pangkat);
        Esatuan = (EditText) findViewById(R.id.updel_satuan);

        Enama.setText(Snama);
        Eumur.setText(Sumur);
        Epangkat.setText(Spangkat);
        Esatuan.setText(Ssatuan);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sumur = String.valueOf(Eumur.getText());
                Spangkat = String.valueOf(Epangkat.getText());
                Ssatuan = String.valueOf(Esatuan.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Harap Isi Nama Anggota", Toast.LENGTH_SHORT).show();
                } else if (Sumur.equals("")){
                    Eumur.requestFocus();
                    Toast.makeText(MainUpdel.this, "Harap Isi Umur Anggota", Toast.LENGTH_SHORT).show();
                }else if (Spangkat.equals("")){
                    Epangkat.requestFocus();
                    Toast.makeText(MainUpdel.this, "Harap Isi Pangkat Anggota", Toast.LENGTH_SHORT).show();
                }else if (Ssatuan.equals("")){
                    Esatuan.requestFocus();
                    Toast.makeText(MainUpdel.this, "Harap Isi Satuan Anggota", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.Updatetni(new tni(Sid, Snama, Sumur, Spangkat , Ssatuan));
                    Toast.makeText(MainUpdel.this, "Data Anda Sudah diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.Deletetni(new tni(Sid, Snama, Sumur, Spangkat, Ssatuan));
                Toast.makeText(MainUpdel.this, "Data Anda Sudah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
