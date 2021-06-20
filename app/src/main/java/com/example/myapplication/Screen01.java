package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Screen01 extends AppCompatActivity implements OnClickListener{
    RecyclerView rsv_coffe;
    CustomAdapter adt;
    ArrayList<Coffe> mCoffes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen01);
        rsv_coffe = findViewById(R.id.rsv_item);

        mCoffes = new ArrayList<>();
        mCoffes.add(new Coffe(R.drawable.caramel,"Stabuck Coffee","150$"));
        mCoffes.add(new Coffe(R.drawable.lymauhong,"Black Coffee","120$"));
        adt=  new CustomAdapter(mCoffes,this);

        rsv_coffe.setAdapter(adt);
        rsv_coffe.setHasFixedSize(true);
        rsv_coffe.setLayoutManager(new GridLayoutManager(this,2));


    }

    @Override
    public void itemClick(Coffe coffe) {
        Intent  intent=new Intent(Screen01.this,Screen02.class);
        intent.putExtra("key1",coffe);
        startActivity(intent);
    }
}