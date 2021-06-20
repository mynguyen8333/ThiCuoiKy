package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Screen02 extends AppCompatActivity {
    ImageView imageView;
    TextView textName,tvGia;
    Coffe coffe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen02);
        imageView = findViewById(R.id.img_screen2);
        textName = findViewById(R.id.tvName2);
        tvGia = findViewById(R.id.tvGia2);

        Intent intent = getIntent();
        if(intent!=null){
            coffe = (Coffe) intent.getSerializableExtra("key1");
            imageView.setImageResource(coffe.getImg());
            textName.setText(coffe.getName());
            tvGia.setText(coffe.getGia());

        }
    }
}