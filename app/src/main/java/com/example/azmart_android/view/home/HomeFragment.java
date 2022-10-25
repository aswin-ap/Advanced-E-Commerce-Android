package com.example.azmart_android.view.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.navigation.Navigation;

import com.example.azmart_android.adapter.DealsViewPagerAdapter;
import com.example.azmart_android.contracts.HomeContract;
import com.example.azmart_android.databinding.FragmentHomeBinding;
import com.example.azmart_android.model.CategoriesResponse;
import com.example.azmart_android.presenter.HomePresenter;
import com.example.azmart_android.utils.Validation;
import com.example.azmart_android.view.BaseFragment;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

public class HomeFragment extends BaseFragment implements HomeContract.View {
    private FragmentHomeBinding binding;
    private HomePresenter presenter;
    private String searchText;
    private DealsViewPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HomePresenter(this);
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
        binding.dealsSliderView.setSliderAdapter(adapter);
        binding.dealsSliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        binding.dealsSliderView.setScrollTimeInSec(4);
        binding.dealsSliderView.setAutoCycle(true);
        binding.dealsSliderView.startAutoCycle();

        binding.etSearch.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchText = binding.etSearch.getText().toString();
                if (Validation.isNotNullOrEmpty(searchText))
                    Navigation.findNavController(requireView()).navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment(searchText));
                else
                    showSnackBar(requireView(), "Search field can't be empty");
                return true;
            }
            return false;
        });
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
    public void showCategoriesResponse(List<CategoriesResponse> categoriesResponseList) {

    }
}