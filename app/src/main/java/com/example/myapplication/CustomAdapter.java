package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private ArrayList<Coffe> mCoffes;

    public CustomAdapter(ArrayList<Coffe> mCoffes) {
        this.mCoffes = mCoffes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kem_item,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public int getItemCount() {
        return mCoffes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView anh;
        TextView tvName,tvGia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            anh = itemView.findViewById(R.id.imgAnh);
            tvName = itemView.findViewById(R.id.tvName);
            tvGia = itemView.findViewById(R.id.tvGia);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Coffe coffe = mCoffes.get(position);
        holder.tvName.setText(coffe.getName());
        holder.tvGia.setText(coffe.getGia());
        holder.anh.setImageResource(coffe.getImg());


    }
}
