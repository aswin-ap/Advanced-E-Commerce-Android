package com.example.azmart_android.view.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager2.widget.ViewPager2;

import com.example.azmart_android.adapter.DealsViewPagerAdapter;
import com.example.azmart_android.contracts.HomeContract;
import com.example.azmart_android.databinding.FragmentHomeBinding;
import com.example.azmart_android.presenter.HomePresenter;
import com.example.azmart_android.view.BaseFragment;

public class HomeFragment extends BaseFragment implements HomeContract.View {
    private FragmentHomeBinding binding;
    private HomePresenter presenter;
    private DealsViewPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HomePresenter();
        adapter = new DealsViewPagerAdapter(presenter.dealsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.dealsViewpager.setAdapter(adapter);
        binding.dealsViewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showApiErrorWarning(String string) {

    }

    @Override
    public void showWarningMessage(String message) {

    }

    @Override
    public void showSuccess(String message) {

    }

    @Override
    public void showInputWarning() {

    }
}