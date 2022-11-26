package com.example.azmart_android.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.azmart_android.R;
import com.example.azmart_android.data.model.AddressModel;
import com.example.azmart_android.data.model.WishListModel;
import com.example.azmart_android.databinding.AddressItemBinding;
import com.example.azmart_android.databinding.SearchItemBinding;
import com.example.azmart_android.utils.OnItemClickListener;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AdapterViewHolder> {
    List<AddressModel> addressModelList;

    public AddressAdapter(List<AddressModel> addressModelList) {
        this.addressModelList = addressModelList;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterViewHolder(AddressItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.setData(addressModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return addressModelList != null ? addressModelList.size() : 0;
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        private AddressItemBinding addressItemBinding;

        public AdapterViewHolder(AddressItemBinding itemView) {
            super(itemView.getRoot());
            this.addressItemBinding = itemView;
        }

        void setData(AddressModel addressModel) {
            try {
                addressItemBinding.tvName.setText(addressModel.getFullName());
                addressItemBinding.tvAddress.setText(addressModel.getFullName() + ", " + addressModel.getState() + ", "
                        +addressModel.getCity() + " - " + addressModel.getPinCode());
                addressItemBinding.tvMobile.setText(addressModel.getPhoneNumber());

            } catch (Exception e) {
                Log.e("error :", e.toString());
            }

        }
    }
}


