package com.android.projek_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class konsultas extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DokterAdapter adapter;
    private ArrayList<Dokter> dokterList;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultas);

        recyclerView = findViewById(R.id.rv_konsul);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dokterList = new ArrayList<>();
        adapter = new DokterAdapter(this, dokterList);
        recyclerView.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();

        // Mengambil data dari Firestore
        db.collection("dokter")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Dokter dokter = document.toObject(Dokter.class);
                                dokterList.add(dokter);
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.w("Firestore", "Error getting documents.", task.getException());
                        }
                    }
                });


    }
}
