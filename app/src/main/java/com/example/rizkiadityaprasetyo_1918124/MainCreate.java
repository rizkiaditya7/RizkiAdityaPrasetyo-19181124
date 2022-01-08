package com.example.rizkiadityaprasetyo_1918124;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Eumur, Epangkat, Esatuan;
    private String Snama, Sumur, Spangkat, Ssatuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);

        Enama = (EditText) findViewById(R.id.create_nama);
        Eumur = (EditText) findViewById(R.id.create_umur);
        Epangkat = (EditText) findViewById(R.id.create_pangkat);
        Esatuan = (EditText) findViewById(R.id.create_satuan);

        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snama = String.valueOf(Enama.getText());
                Sumur = String.valueOf(Eumur.getText());
                Spangkat = String.valueOf(Epangkat.getText());
                Ssatuan = String.valueOf(Esatuan.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Harap Isi Nama Anggota", Toast.LENGTH_SHORT).show();
                }
                else if (Sumur.equals("")) {
                    Eumur.requestFocus();
                    Toast.makeText(MainCreate.this, "Harap Isi Umur Anggota", Toast.LENGTH_SHORT).show();
                }
                else if (Spangkat.equals("")) {
                    Epangkat.requestFocus();
                    Toast.makeText(MainCreate.this, "Harap Isi Pangkat Anggota", Toast.LENGTH_SHORT).show();
                }
                else if (Ssatuan.equals("")) {
                    Esatuan.requestFocus();
                    Toast.makeText(MainCreate.this, "Harap Isi Satuan Anggota", Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Eumur.setText("");
                    Epangkat.setText("");
                    Esatuan.setText("");
                    Toast.makeText(MainCreate.this, "Data Sudah ditambahkan", Toast.LENGTH_SHORT).show();
                    db.Createtni(new tni(null, Snama, Sumur, Spangkat, Ssatuan));

                    Intent a = new Intent(MainCreate.this,
                            com.example.rizkiadityaprasetyo_1918124.MainActivity.class);
                    startActivity(a);
                }

            }
        });
    }
}