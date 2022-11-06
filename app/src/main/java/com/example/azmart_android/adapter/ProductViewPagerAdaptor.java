package com.example.azmart_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.azmart_android.R;

import java.util.ArrayList;
import java.util.List;

public class ProductViewPagerAdaptor extends PagerAdapter {
    List<String> imageList;
    Context context;
    LayoutInflater mLayoutInflater;

    public ProductViewPagerAdaptor(Context context, List<String> imageList) {
    this.imageList=imageList;
    this.context=context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount () {
        // return the number of images
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject (@NonNull View view, @NonNull Object object){
        return view == ((ConstraintLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem (@NonNull ViewGroup container,final int position){
        // inflating the item.xml
        View itemView = mLayoutInflater.inflate(R.layout.product_image_item, container, false);

        // referencing the image view from the item.xml file
        ImageView imageView = (ImageView) itemView.findViewById(R.id.iv_images);

        // setting the image in the imageView
        Glide.with(context).load(imageList.get(position))
                .placeholder(R.drawable.ic_image_placeholder)
                .error(R.drawable.ic_image_error)
                .into(imageView);

        ViewPager vp = (ViewPager) container;
        vp.addView(itemView, 0);

            return itemView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((ConstraintLayout) object);
    }
}
