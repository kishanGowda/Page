package com.example.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder>{
    ArrayList<OrganizationCard> organizationCards;

    public CardAdapter(ArrayList<OrganizationCard> organizationCards) {
        this.organizationCards = organizationCards;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        CardViewHolder cardViewHolder=new CardViewHolder(view);
                return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
            OrganizationCard currentOrganizationCard=this.organizationCards.get(position);
            holder.organizationName.setText(currentOrganizationCard.getOrganizationName());
            holder.organizationImage.setImageResource(currentOrganizationCard.getImageResource());
    }

    @Override
    public int getItemCount() {
        return organizationCards.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{

        public  TextView organizationName;
        public ImageView organizationImage;
        public Button visitButton;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            organizationName=itemView.findViewById(R.id.organizationName);
            organizationImage=itemView.findViewById(R.id.organizationImage);
            visitButton=itemView.findViewById(R.id.buttonVisit);
        }
    }
}
