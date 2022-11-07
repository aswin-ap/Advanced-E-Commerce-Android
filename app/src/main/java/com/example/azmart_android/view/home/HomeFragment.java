package com.example.azmart_android.view.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.azmart_android.R;
import com.example.azmart_android.adapter.BestProductHomeAdapter;
import com.example.azmart_android.adapter.CategoryHomeAdapter;
import com.example.azmart_android.adapter.DealsViewPagerAdapter;
import com.example.azmart_android.contracts.HomeContract;
import com.example.azmart_android.data.model.BestProductsResponse;
import com.example.azmart_android.data.model.CategoriesResponse;
import com.example.azmart_android.databinding.FragmentHomeBinding;
import com.example.azmart_android.presenter.HomePresenter;
import com.example.azmart_android.utils.Validation;
import com.example.azmart_android.view.BaseFragment;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeFragment extends BaseFragment implements HomeContract.View {
    Random rand = new Random();
    private FragmentHomeBinding binding;
    private HomePresenter presenter;
    private String searchText;
    private DealsViewPagerAdapter adapter;
    private CategoryHomeAdapter categoryHomeAdapter;
    private List<CategoriesResponse> categoriesList = new ArrayList<>();
    private BestProductHomeAdapter bestProductHomeAdapter;
    private List<BestProductsResponse> bestProductsList = new ArrayList<>();
    private List<Integer> colorList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HomePresenter(this);
        adapter = new DealsViewPagerAdapter(presenter.dealsList);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (binding.etSearch.getText().toString() != null) {
            binding.etSearch.setText("");
        }
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

        binding.tvViewAll.setOnClickListener(v -> {
            Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_categoryFragment);
        });

        colorList.clear();
        for (int i = 0; i <= 15; i++) {
            colorList.add(getRandomColor());
        }
        categoryHomeAdapter = new CategoryHomeAdapter(categoriesList, this, colorList);
        binding.rvCategory.setHasFixedSize(true);
        binding.rvCategory.setLayoutManager(new LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false));
        binding.rvCategory.setAdapter(categoryHomeAdapter);

        bestProductHomeAdapter = new BestProductHomeAdapter(bestProductsList, this);
        binding.rvBestProducts.setHasFixedSize(true);
        binding.rvBestProducts.setLayoutManager(new LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false));
        binding.rvBestProducts.setAdapter(bestProductHomeAdapter);

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
         presenter.getHomeDetails();
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
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showToast(requireContext(), string);
            }
        });
    }

    @Override
    public void showCategoriesResponse(List<CategoriesResponse> categoriesResponseList) {
        if (categoriesResponseList.size() > 0) {
            categoriesList.clear();
            for (int i = 0; i <= 15; i++) {
                categoriesList.add(categoriesResponseList.get(rand.nextInt(categoriesResponseList.size())));
            }
            categoryHomeAdapter.notifyDataSetChanged();
        } else
            showToast(requireContext(), "Category Not found");

        binding.shimmerCategory.setVisibility(View.GONE);
        binding.rvCategory.setVisibility(View.VISIBLE);
    }

    @Override
    public void showBestProductsResponse(List<BestProductsResponse> bestProductsResponses) {
        if (bestProductsResponses.size() > 0) {
            bestProductsList.clear();
            for (int i = 0; i <= 15; i++) {
                bestProductsList.add(bestProductsResponses.get(rand.nextInt(bestProductsResponses.size())));
            }
            bestProductHomeAdapter.notifyDataSetChanged();
        } else
            showToast(requireContext(), "Best Products Not found");

        binding.shimmerBestProducts.setVisibility(View.GONE);
        binding.rvBestProducts.setVisibility(View.VISIBLE);
    }

    public int getRandomColor() {
        // This is the base color which will be mixed with the generated one
        final int baseColor = Color.WHITE;

        final int baseRed = Color.red(baseColor);
        final int baseGreen = Color.green(baseColor);
        final int baseBlue = Color.blue(baseColor);

        final int red = (baseRed + rand.nextInt(256)) / 2;
        final int green = (baseGreen + rand.nextInt(256)) / 2;
        final int blue = (baseBlue + rand.nextInt(256)) / 2;

        return Color.rgb(red, green, blue);
        // return Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    public void navigateToCategory() {
        // Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_categoryFragment);
    }
}