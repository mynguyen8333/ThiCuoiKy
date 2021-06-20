package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    /*
    Ten dang nhap:mynguyen8333@gmail.com
    Mat Khau:123456
     */
    Button btnDangNhap;
    EditText edName,edpassword;
    FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDangNhap = findViewById(R.id.btnLogin);
        edName = findViewById(R.id.edEmail);
        edpassword = findViewById(R.id.edPassoword);
        mauth = FirebaseAuth.getInstance();

        btnDangNhap.setOnClickListener(view->{
            dangnhap();
        });



    }

    private void dangnhap(){
        String email = edName.getText().toString().trim();
        String password = edpassword.getText().toString().trim();
        if(email.equalsIgnoreCase("")){
            Toast.makeText(MainActivity.this,"Chua nhap user name",Toast.LENGTH_SHORT).show();
        }else if(password.equalsIgnoreCase("")){
            Toast.makeText(MainActivity.this,"Chua nhap mat khau",Toast.LENGTH_SHORT).show();
        }else{
            mauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        edName.setText("");
                        edpassword.setText("");
                        Toast.makeText(MainActivity.this,"Danh nhap thanh cong",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,Screen01.class));
                    }else{
                        Toast.makeText(MainActivity.this,"Sai ten tai khoan hoac mat khau",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}