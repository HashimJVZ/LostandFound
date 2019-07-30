package com.example.lostandfound;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lostandfound.model.CardData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

    private Context context;
    List<CardData> cardData;

    public CardAdapter(Context context, List<CardData> cardData) {
        this.context = context;
        this.cardData = cardData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        try {
            Picasso.get().load(cardData.get(position).getImage()).into(holder.imageView);
        }
        catch (Exception e){

        }
        holder.title.setText(cardData.get(position).getTitle());
        holder.description.setText(cardData.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return cardData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title, description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cardimage);
            title = itemView.findViewById(R.id.cardtitle);
            description = itemView.findViewById(R.id.carddescription);
        }
    }
}
