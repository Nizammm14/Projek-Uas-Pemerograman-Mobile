package com.android.projek_mobile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DokterAdapter extends RecyclerView.Adapter<DokterAdapter.DokterViewHolder> {

    private Context context;
    private ArrayList<Dokter> dokterArrayList;

    public DokterAdapter(Context context, ArrayList<Dokter> dokterArrayList) {
        this.context = context;
        this.dokterArrayList = dokterArrayList;
    }

    @NonNull
    @Override
    public DokterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listdokter, parent, false);
        return new DokterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DokterViewHolder holder, int position) {
        Dokter dokter = dokterArrayList.get(position);

        if (dokter != null) {
            holder.tvNama.setText(dokter.getNama());
            holder.tvDeskripsi.setText(dokter.getDeskripsi());

            Glide.with(context)
                    .load(dokter.getImageUrl())
                    .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                    .error(R.drawable.gambar1)
                    .into(holder.ivDokter);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailDokter.class);
                    intent.putExtra("nama", dokter.getNama());
                    intent.putExtra("deskripsi", dokter.getDeskripsi());
                    intent.putExtra("imageUrl", dokter.getImageUrl());
                    context.startActivity(intent);
                }
            });


        }
    }

    @Override
    public int getItemCount() {
        return dokterArrayList.size();
    }

    public static class DokterViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvDeskripsi;
        ImageView ivDokter;

        public DokterViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDokter = itemView.findViewById(R.id.ivDokter);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvDeskripsi = itemView.findViewById(R.id.tvDeskripsi);
        }
    }
}
