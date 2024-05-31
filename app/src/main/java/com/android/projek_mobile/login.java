package com.android.projek_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    private Button btn1, btn;
    private EditText edt1, edt2;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt1 =findViewById(R.id.edt1);
        edt2 =findViewById(R.id.edt2);
        btn =findViewById(R.id.btn);
        btn1 =findViewById(R.id.btn1);
        auth = FirebaseAuth.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), register.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edt1.getText().toString();
                String password = edt2.getText().toString();

                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                           if (auth.getCurrentUser().isEmailVerified()){
                               Toast.makeText(getApplicationContext(),"login berhasil", Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(getApplicationContext(), beranda.class));


                           }else {
                               edt1.setError("verifikasi email anda");
                           }


                        }else{
                            Toast.makeText(getApplicationContext(),"login gagal", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });

    }
}