package com.android.projek_mobile;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Dokter implements Parcelable {
    private String nama;
    private String deskripsi;
    private String imageUrl;



    public Dokter(String nama, String deskripsi, String imageUrl) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.imageUrl = imageUrl;
    }


    public Dokter() {
        // Diperlukan untuk Firestore
    }
    protected Dokter(Parcel in) {
        nama = in.readString();
        deskripsi = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Dokter> CREATOR = new Creator<Dokter>() {
        @Override
        public Dokter createFromParcel(Parcel in) {
            return new Dokter(in);
        }

        @Override
        public Dokter[] newArray(int size) {
            return new Dokter[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(deskripsi);
        dest.writeString(imageUrl);
    }
}
