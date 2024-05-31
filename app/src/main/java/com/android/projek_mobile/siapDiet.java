package com.android.projek_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class siapDiet extends AppCompatActivity {
    private ImageButton beranda, tekan, tekan1,  tekan3, tekan4, tekan5, tekan6, tekan7, tekan8, tekan9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siap_diet);

        beranda = findViewById(R.id.beranda);
        tekan = findViewById(R.id.tekan);
        tekan1 = findViewById(R.id.tekan1);
        tekan3 = findViewById(R.id.tekan3);
        tekan4 = findViewById(R.id.tekan4);
        tekan5 = findViewById(R.id.tekan5);
        tekan6 = findViewById(R.id.tekan6);
        tekan7 = findViewById(R.id.tekan7);
        tekan8 = findViewById(R.id.tekan8);
        tekan9 = findViewById(R.id.tekan9);

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), beranda.class));
            }
        });

        tekan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://pgsp.big.go.id/gizi-cukup-sehat-dan-semangat/"));
                startActivity(x);

            }
        });
        tekan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://primayahospital.com/gizi/gizi-yang-baik-untuk-anak/"));
                startActivity(x);

            }
        });

        tekan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://www.unicef.org/indonesia/id/gizi/artikel/dampak-wasting-pada-anak"));
                startActivity(x);

            }
        });

        tekan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://telemed.ihc.id/artikel-detail-152-8-Kandungan-Gizi-Penting-untuk-Hidup-Sehat.html"));
                startActivity(x);

            }
        });

        tekan5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://www.emc.id/id/care-plus/gizi-seimbang-untuk-gaya-hidup-yang-sehatl"));
                startActivity(x);

            }
        });

        tekan6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://www.halodoc.com/artikel/mengenal-pedoman-gizi-seimbang-dan-manfaat-untuk-kesehatan"));
                startActivity(x);

            }
        });
        tekan7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://www.halodoc.com/artikel/jumlah-kebutuhan-zat-gizi-yang-dibutuhkan-oleh-tubuh-manusia"));
                startActivity(x);

            }
        });
        tekan8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://ditsmp.kemdikbud.go.id/komposisi-zat-dalam-pola-makanan-bergizi-dan-seimbang/"));
                startActivity(x);

            }
        });

        tekan9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Intent.ACTION_VIEW);
                x.setData(Uri.parse("https://telemed.ihc.id/artikel-detail-710-Bagaimana-Kriteria-Makanan-Sehat-Dan-Bergizi.html"));
                startActivity(x);

            }
        });




    }
}