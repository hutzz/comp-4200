package com.example.viewrecycler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<MyDataSet> dataList;
    Context context;
    public MyAdapter(ArrayList<MyDataSet> data, Context context){
        this.dataList = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyDataSet data = dataList.get(position);
        holder.imageView.setImageResource(data.getImage());
        holder.textView.setText(data.getText());
        ((Button) holder.itemView.findViewById(R.id.button)).setText(data.getBtnText());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 1) {
                    Intent intent = new Intent(context, CardActivity.class);
                    context.startActivity(intent);
                } else {
                    String msg = "You clicked Card "+(position+1);
                    Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.itemView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getColour(((Button) holder.itemView.findViewById(R.id.button)).getText().toString()) == getColour("white")) {
                    holder.textView.setTextColor(ContextCompat.getColor(context, R.color.white));
                    ((Button) holder.itemView.findViewById(R.id.button)).setText(data.getBtnText());
                } else {
                    holder.textView.setTextColor(getColour(data.getBtnText()));
                    ((Button) holder.itemView.findViewById(R.id.button)).setText("White");
                }
            }
        });
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] text = holder.textView.getText().toString().split(" ");
                if (text[0].equals("Card") && Integer.parseInt(text[1]) >= 1 && Integer.parseInt(text[1]) <= 3) {
                    holder.textView.setText("Text " + text[1]);
                }
            }
        });
    }
    private int getColour(String btnText) {
        try {
            return Color.parseColor(btnText.toLowerCase());
        } catch (Exception e) {
            return R.color.black;
        }
    }

    @Override
//    public int getItemCount() {
//        return Math.min(dataList.size(), 2);
//    }
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.tv_card);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

}


