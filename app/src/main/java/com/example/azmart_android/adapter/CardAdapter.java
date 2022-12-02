package com.example.azmart_android.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.azmart_android.R;
import com.example.azmart_android.data.model.CardsModel;
import com.example.azmart_android.databinding.CardItemBinding;
import com.example.azmart_android.utils.OnItemClickListener;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.AdapterViewHolder> {
    List<CardsModel> cardModelList;
    Context context;
    int selectedPosition;
    OnItemClickListener clickListener;

    public CardAdapter(List<CardsModel> cardModelList, Context context, int selectedPosition, OnItemClickListener listener) {
        this.cardModelList = cardModelList;
        this.context = context;
        this.selectedPosition = selectedPosition;
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterViewHolder(CardItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.setData(cardModelList.get(position), position, this.selectedPosition);
        holder.itemView.setOnClickListener(v -> {
            clickListener.onItemClick(position);
        });

    }

    @Override
    public int getItemCount() {
        return cardModelList != null ? cardModelList.size() : 0;
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        private CardItemBinding cardItemBinding;

        public AdapterViewHolder(CardItemBinding itemView) {
            super(itemView.getRoot());
            this.cardItemBinding = itemView;
        }

        void setData(CardsModel cardModelList, int position, int selectedPosition) {
            try {
                if (position == selectedPosition)
                    cardItemBinding.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.green_500));
                else
                    cardItemBinding.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.white));
                cardItemBinding.tvName.setText(cardModelList.getCardNumber());
                cardItemBinding.tvNumber.setText(cardModelList.getCardHolderName());

            } catch (Exception e) {
                Log.e("error :", e.toString());
            }
        }
    }

    public void updatePosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }
}





