package com.example.azmart_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.azmart_android.R;
import com.example.azmart_android.view.home.HomeFragment;
import com.example.azmart_android.view.home.HomeFragmentDirections;

import java.util.List;

public class SearchCatSugesstionAdaptor extends ArrayAdapter<String> {

    HomeFragment homeFragment;

    public SearchCatSugesstionAdaptor(Context context, List<String> arrayList, HomeFragment homeFragment) {
        super(context, 0, arrayList);
        this.homeFragment=homeFragment;
    }

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.category_item, parent, false);
        }

        String currentNumberPosition = getItem(position);

        assert currentNumberPosition != null;
        TextView categoryName = currentItemView.findViewById(R.id.category_title);
        categoryName.setText(currentNumberPosition);

        categoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(homeFragment.requireView()).navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment(currentNumberPosition));


            }
        });

        return currentItemView;
    }

}
