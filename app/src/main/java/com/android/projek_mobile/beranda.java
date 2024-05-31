package com.android.projek_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class beranda extends AppCompatActivity {

    private ImageButton konsultasi, diet, nutrisi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        konsultasi = findViewById(R.id.konsultasi);
        diet = findViewById(R.id.diet);
        nutrisi = findViewById(R.id.nutrisi);

        konsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), konsultas.class));
            }
        });

        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), siapDiet.class));
            }
        });

        nutrisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Nutrisi.class));
            }
        });


    }
}