package com.android.projek_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.Month;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class kalender extends AppCompatActivity {
    public static  final  String ITEM_EXTRA = "item_extra";
    EditText etTanggal, etJam, etPasien, etNik, etDokter ,  etKeluhan;
    TextView tvTanggal, tvJam, tvPasien, tvNik, tvDokter, tvKeluhan;
    Button btnBooking;

    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    SimpleDateFormat dateFormat;
    FirebaseFirestore db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalender);

        etTanggal =(EditText) findViewById(R.id.etTanggal);
        etJam = findViewById(R.id.etJam);
        etPasien = findViewById(R.id.etPasien);
        etNik = findViewById(R.id.etNik);
        etDokter = findViewById(R.id.etDokter);
        etKeluhan = findViewById(R.id.etKeluhan);
        
        tvTanggal = findViewById(R.id.tvTanggal);
        tvJam = findViewById(R.id.tvJam);
        tvPasien = findViewById(R.id.tvPasien);
        tvNik = findViewById(R.id.tvNik);
        tvDokter = findViewById(R.id.tvDokter);
        tvKeluhan = findViewById(R.id.tvKeluhan);
        
        btnBooking = findViewById(R.id.btnBooking);

        db = FirebaseFirestore.getInstance();

        ImageView ivGambar = findViewById(R.id.ivGambar);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("imageUrl");
        Glide.with(this)
                        .load(imageUrl)
                        .placeholder(R.drawable.ic_launcher_background)
                                        .into(ivGambar);

        
        etTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        etJam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                startActivity(new Intent(getApplicationContext(), Terdaftar.class));
            }
        });
        

        



    }



    private void showTimePickerDialog() {
        // Mendapatkan waktu saat ini
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Membuat instance TimePickerDialog dan menampilkannya
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Menetapkan waktu yang dipilih ke etTime
                        etJam.setText(String.format("%02d:%02d", hourOfDay, minute));
                    }
                },
                hour, minute, true);
        timePickerDialog.show();
    }

    private void showDatePickerDialog() {
        // Mengambil tanggal saat ini
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Membuat instance DatePickerDialog dan menampilkannya
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Menetapkan tanggal yang dipilih ke EditText
                        etTanggal.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },
                year, month, day);
        datePickerDialog.show();
    }

    private void saveData() {
       String pasien = etPasien.getText().toString();
       String nik = etNik.getText().toString();
       String dokter = etDokter.getText().toString();
       String keluhan = etKeluhan.getText().toString();
       String tanggal = etTanggal.getText().toString();
       String jam = etJam.getText().toString();

        Map<String, Object> user =new HashMap<>();
        user.put("pasien", pasien);
        user.put("nik", nik);
        user.put("dokter", dokter);
        user.put("keluhan", keluhan);
        user.put("tanggal", tanggal);
        user.put("jam", jam);

        db.collection("user")
                .add(user)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(kalender.this,"data tersimpan", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(kalender.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void clearFields() {
        etTanggal.setText("");
        etJam.setText("");
        etPasien.setText("");
        etNik.setText("");
        etDokter.setText("");
        etKeluhan.setText("");
    }




}