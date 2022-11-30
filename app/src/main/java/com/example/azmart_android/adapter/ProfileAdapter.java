package com.example.azmart_android.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.azmart_android.R;
import com.example.azmart_android.databinding.SettingsListItemBinding;

import java.util.List;

public class ProfileAdapter extends ArrayAdapter<String> {
    private Activity context;
    private String[] itemsList;


    public ProfileAdapter(@NonNull Activity context, String[] list) {
        super(context, R.layout.settings_list_item);
        this.context = context;
        this.itemsList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SettingsListItemBinding binding;
        if (convertView == null) {
            binding = SettingsListItemBinding.inflate(context.getLayoutInflater(), parent, false);
            convertView = binding.getRoot();
            convertView.setTag(R.id.viewBinding, binding);
        } else
            binding = ((SettingsListItemBinding) convertView.getTag(R.id.viewBinding));
        String item = itemsList[position];
        binding.tvItemName.setText(item);
        return convertView;

    }

    @Override
    public int getCount() {
        return itemsList.length;
    }
}
