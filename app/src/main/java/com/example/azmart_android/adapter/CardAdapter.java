package com.example.azmart_android.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.azmart_android.data.model.AddressModel;
import com.example.azmart_android.data.model.CardsModel;
import com.example.azmart_android.databinding.AddressItemBinding;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.AdapterViewHolder> {
    List<CardsModel> cardModelList;

    public CardAdapter(List<CardsModel> cardModelList) {
        this.cardModelList = cardModelList;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterViewHolder(AddressItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.setData(cardModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return cardModelList != null ? cardModelList.size() : 0;
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        private AddressItemBinding addressItemBinding;

        public AdapterViewHolder(AddressItemBinding itemView) {
            super(itemView.getRoot());
            this.addressItemBinding = itemView;
        }

        void setData(CardsModel cardModelList) {
            try {
                addressItemBinding.tvName.setText(cardModelList.getCardNumber());
                addressItemBinding.tvAddress.setText(cardModelList.getCardHolderName());

            } catch (Exception e) {
                Log.e("error :", e.toString());
            }

        }
    }
}


