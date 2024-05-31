package com.android.projek_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    private EditText  edt4, edt5, edt6;
    private Button btn2;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edt4 =findViewById(R.id.edt4);
        edt5 =findViewById(R.id.edt5);
        edt6 =findViewById(R.id.edt6);
        btn2 =findViewById(R.id.btn2);
        auth = FirebaseAuth.getInstance();

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edt4.getText().toString();
                String password = edt5.getText().toString();
                String konfirPassword = edt6.getText().toString();

                if (!(email.isEmpty() || password.isEmpty() || konfirPassword.isEmpty())){

                    if (konfirPassword.equals(password)){
                        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){
                                    auth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(getApplicationContext(), "daftar berhasil", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(getApplicationContext(), login.class));

                                            }else {
                                                Toast.makeText(getApplicationContext(), "verfikasi gagal", Toast.LENGTH_SHORT).show();


                                            }
                                        }
                                    });
                                }else {
                                    Toast.makeText(getApplicationContext(), "daftar gagal", Toast.LENGTH_SHORT).show();


                                }
                            }
                        });

                    }else {
                        edt6.setError("password tidak sama");

                    }

                }else {
                    Toast.makeText(getApplicationContext(), "data belum lengkap", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}