package com.android.projek_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailDokter extends AppCompatActivity {
    public static final  String ITEM_EXTRA = "item_extra";
    Button btnBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dokter);

        ImageView ivDetail = findViewById(R.id.ivDetail);
        TextView tvNamaDokter = findViewById(R.id.tvNamaDokter);
        TextView tvIsi = findViewById(R.id.tvIsi);

        Intent inten = getIntent();

        btnBook = findViewById(R.id.btnBook);

        String nama = getIntent().getStringExtra("nama");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        String imageUrl = getIntent().getStringExtra("imageUrl");

        // Mengatur data ke views
        tvNamaDokter.setText(nama);
        tvIsi.setText(deskripsi);
        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.gambar1)
                .into(ivDetail);

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kalender = new Intent(DetailDokter.this,kalender.class);
                kalender.putExtra("imageuRL",imageUrl);
                startActivity(kalender);
            }
        });
    }
}