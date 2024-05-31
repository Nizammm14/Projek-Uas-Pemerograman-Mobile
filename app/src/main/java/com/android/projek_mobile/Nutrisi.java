package com.android.projek_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Nutrisi extends AppCompatActivity {
    private ImageButton beranda1, imgbtn, imgbtn2, imgbtn3, imgbtn4, imgbtn5;
    private TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrisi);

        beranda1 = findViewById(R.id.beranda1);
        imgbtn = findViewById(R.id.imgbtn);
        imgbtn2 = findViewById(R.id.imgbtn2);
        imgbtn3 = findViewById(R.id.imgbtn3);
        imgbtn4 = findViewById(R.id.imgbtn4);
        imgbtn5 = findViewById(R.id.imgbtn5);
        text1 = findViewById(R.id.text1);

        beranda1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), beranda.class));
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://www.idai.or.id/artikel/seputar-kesehatan-anak/nutrisi-pada-remaja"));
                startActivity(x);

            }
        });

        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://www.sehataqua.co.id/nutrisi-adalah/"));
                startActivity(x);

            }
        });

        imgbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://www.frisianflag.com/milkpedia/nutrisi-dan-kesehatan/5-jenis-nutrisi-yang-harus-dipenuhi-untuk-tubuh-sehat"));
                startActivity(x);

            }
        });

        imgbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://www.bhinneka.com/blog/apa-itu-nutrisi-pengertian-dan-manfaat-nutrisi-untuk-tubuh/"));
                startActivity(x);

            }
        });

        imgbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://www.nakedpress.co/blogs/stories/tubuh-harus-punya-7-nutrisi-apa-saja-mereka-1"));
                startActivity(x);

            }
        });

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://www.idai.or.id/artikel/seputar-kesehatan-anak/nutrisi-pada-remaja"));
                startActivity(x);

            }
        });




    }
}