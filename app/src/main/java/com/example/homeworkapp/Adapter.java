package com.example.homeworkapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<HashMap<String,String>> data;
    private Context context;


    public Adapter(Context context,List<HashMap<String,String>>data)
    {
        this.context=context;
        this.data=data;

    }







    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        MyViewHolder vh= new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, final int position) {




        String name=data.get(position).get("name");
        String phone=data.get(position).get("phone");


        holder.txtView.setText("Name:"+name);
        holder.txtView2.setText("Phone:"+phone);








    }

    @Override
    public int getItemCount()
    { return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView,imgView2;
        TextView txtView,txtView2;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            imgView= itemView.findViewById(R.id.img_view);
            imgView2=itemView.findViewById(R.id.img_view2);
            txtView=itemView.findViewById(R.id.txt_view);
            txtView2=itemView.findViewById(R.id.txt_view2);


        }
    }
}
