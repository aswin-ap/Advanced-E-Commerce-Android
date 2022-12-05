package com.example.azmart_android.view.performance;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import com.example.azmart_android.adapter.PerformanceViewPagerAdapter;
import com.example.azmart_android.contracts.PerformanceContract;
import com.example.azmart_android.data.model.PerformanceModel;
import com.example.azmart_android.databinding.FragmentPerformanceCheckBinding;
import com.example.azmart_android.databinding.PerformanceItemBinding;
import com.example.azmart_android.presenter.PerformancePresenter;
import com.example.azmart_android.view.BaseFragment;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

public class PerformanceCheckFragment extends BaseFragment implements PerformanceContract.View {
    private FragmentPerformanceCheckBinding binding;
    private PerformanceViewPagerAdapter adapter;
    private PerformancePresenter performancePresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showLoading() {
        showLoadingDialog(requireContext());
    }

    @Override
    public void hideLoading() {
        hideLoadingDialog();
    }

    @Override
    public void showApiErrorWarning(String string) {
        showToast(requireContext(), string);
    }

    @Override
    public void showPerformance(List<PerformanceModel> performanceModelList) {
        for (int i = 0; i < performanceModelList.size(); i++) {
            String substr = String.valueOf(performanceModelList.get(i).getTimeTookToProcess()).substring(String.valueOf(performanceModelList.get(i).getTimeTookToProcess()).length() - 4);

            Log.d("ProgressValue", "showPerformance: " + performanceModelList.get(i).getTimeTookToProcess());
            Log.d("ProgressValue", "showConvertedValute: " + substr);
            PerformanceItemBinding performanceItemBinding = PerformanceItemBinding.inflate(getLayoutInflater());

            setProgressMax(performanceItemBinding.progressLinear, 10000);
            performanceItemBinding.tvType.setText(performanceModelList.get(i).getType());
            performanceItemBinding.tvTime.setText(String.valueOf(performanceModelList.get(i).getTimeTookToProcess()));
            setProgressAnimate(performanceItemBinding.progressLinear, Integer.parseInt(substr));
            binding.performanceLayout.addView(performanceItemBinding.getRoot());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPerformanceCheckBinding.inflate(inflater, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        performancePresenter = new PerformancePresenter(this, requireContext());
        adapter = new PerformanceViewPagerAdapter(performancePresenter.performanceModelList);
        binding.performanceSlider.setSliderAdapter(adapter);

        binding.performanceSlider.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        binding.performanceSlider.setScrollTimeInSec(4);
        binding.performanceSlider.setAutoCycle(true);
        binding.performanceSlider.startAutoCycle();


        binding.btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performancePresenter.getPerformance();
            }
        });

    }

    private void setProgressMax(LinearProgressIndicator pb, int max) {
        pb.setMax(max * 100);
    }

    private void setProgressAnimate(LinearProgressIndicator pb, int progressTo) {
        ObjectAnimator animation = ObjectAnimator.ofInt(pb, "progress", pb.getProgress(), progressTo * 100);
        animation.setDuration(500);
        animation.setAutoCancel(true);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
    }
}