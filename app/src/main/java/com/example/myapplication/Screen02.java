package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Screen02 extends AppCompatActivity {
    ImageView imageView;
    TextView textName,tvGia;
    Coffe coffe;
    Button btnAdd;
    String url = "https://60b5d3bbfe923b0017c84b46.mockapi.io/";
    TextView tvSoluong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen02);
        imageView = findViewById(R.id.img_screen2);
        textName = findViewById(R.id.tvName2);
        tvGia = findViewById(R.id.tvGia2);
        tvSoluong = findViewById(R.id.tvSoluong);
        btnAdd = findViewById(R.id.btnAddToCard);
        Intent intent = getIntent();
        if(intent!=null){
            coffe = (Coffe) intent.getSerializableExtra("key1");
            imageView.setImageResource(coffe.getImg());
            textName.setText(coffe.getName());
            tvGia.setText(coffe.getGia());

        }
        btnAdd.setOnClickListener(view->{
           postAPI(url);
        });
    }
    private void postAPI(String url)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url + "Coffe", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Screen02.this,"True", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Screen02.this,"True",Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String ,String> params = new HashMap<>();
                params.put("id","");
                params.put("name",textName.getText().toString());
                params.put("Price",tvGia.getText().toString());
                params.put("Quantity",tvSoluong.getText().toString());
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}