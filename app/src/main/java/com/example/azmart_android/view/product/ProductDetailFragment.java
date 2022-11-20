package com.example.azmart_android.view.product;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.azmart_android.R;
import com.example.azmart_android.adapter.ProductViewPagerAdaptor;
import com.example.azmart_android.contracts.ProductContract;
import com.example.azmart_android.data.model.ProductDetails.ProductDetailsResponse;
import com.example.azmart_android.databinding.FragmentProductBinding;
import com.example.azmart_android.presenter.ProductPresenter;
import com.example.azmart_android.utils.NetworkManager;
import com.example.azmart_android.view.BaseFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProductDetailFragment extends BaseFragment implements ProductContract.View {

    FirebaseUser currentUser;
    private ProductPresenter productPresenter;
    private FragmentProductBinding binding;
    private ProductDetailsResponse productDetailsResponse;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productPresenter = new ProductPresenter(this);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.srfProduct.setColorSchemeColors(getResources().getColor(R.color.green_700));
        binding.srfProduct.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initView();
                binding.srfProduct.setRefreshing(false);
            }
        });
        initView();
    }

    private void initView() {
//        String productName=ProductFragmentArgs.fromBundle(getArguments()).getProductName();
//        binding.tvProductName.setText(productName);
        String productId = ProductDetailFragmentArgs.fromBundle(getArguments()).getProductId();
        Log.e("productid :", productId);

        if (NetworkManager.isNetworkAvailable(requireContext())) {
            binding.llProduct.setVisibility(View.GONE);
            binding.tvNetworkWorning.setVisibility(View.GONE);
            productPresenter.getProduct(productId);
        } else {
            binding.tvNetworkWorning.setVisibility(View.VISIBLE);
        }
        productPresenter.isExistProductInWishlist(productId, currentUser.getUid());
        binding.btnProductAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productPresenter.addProductToCart(
                        productDetailsResponse.getProductId(), currentUser.getUid(), productDetailsResponse.getMetadata().getTitleModule().getProductTitle(),
                        productDetailsResponse.getFeedBackRating().getEvarageStar(), String.valueOf(productDetailsResponse.getAppSalePrice()),
                        productDetailsResponse.getProductSmallImageUrls().getString().get(0)
                );
            }
        });
        binding.ivWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.ivWishlist.isChecked()) {
                    productPresenter.addProductToWishlist(
                            productDetailsResponse.getProductId(), currentUser.getUid(), productDetailsResponse.getMetadata().getTitleModule().getProductTitle(),
                            productDetailsResponse.getFeedBackRating().getEvarageStar(), productDetailsResponse.getMetadata().getPriceModule().getFormatedPrice(),
                            productDetailsResponse.getProductSmallImageUrls().getString().get(0)

                    );
                } else {
                    productPresenter.deleteProductInWishlist(
                            productDetailsResponse.getProductId(), currentUser.getUid()
                    );
                }

            }
        });
    }

    @Override
    public void showLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
    }

    @Override
    public void showApiErrorWarning(String string) {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        showSnackBar(requireView(), string);
    }

    @Override
    public void showProductResponse(ProductDetailsResponse productDetailsResponse) {
        this.productDetailsResponse = productDetailsResponse;
        ProductViewPagerAdaptor productViewPagerAdaptor;
        productViewPagerAdaptor = new ProductViewPagerAdaptor(getActivity().getBaseContext(), productDetailsResponse.getMetadata().getImageModule().getImagePathList());
        binding.vpProductImage.setAdapter(productViewPagerAdaptor);
        binding.ciIndicator.attachTo(binding.vpProductImage);
        productViewPagerAdaptor.notifyDataSetChanged();
//        binding.rbRating.setRating((float) productDetailsResponse.getEvaluateRate());
        binding.tvProductName.setText(productDetailsResponse.getMetadata().getTitleModule().getProductTitle());
        binding.tvRating.setText(productDetailsResponse.getFeedBackRating().getEvarageStar());
        binding.tvPrice.setText(productDetailsResponse.getMetadata().getPriceModule().getFormatedPrice());
        binding.tvProductDescription.setText(productDetailsResponse.getMetadata().getTitleModule().getProductDescription());
        hideLoading();
        binding.llProduct.setVisibility(View.VISIBLE);
    }

    @Override
    public void showAddedToCartResponse(String message) {
        // hideLoadingDialogue();
        showSnackBar(requireView(), message);
    }

    @Override
    public void showAddedToWishlistResponse(String message) {
        hideLoadingDialogue();
        showSnackBar(requireView(), message);
    }

    @Override
    public void showIsExistWishlist(String message) {
        binding.ivWishlist.setChecked(true);
    }

    @Override
    public void showDeleteProductWishlist(String message) {
        hideLoadingDialogue();
        showSnackBar(requireView(), message);
    }

    @Override
    public void showLoadingDialog() {
        super.showLoadingDialog(requireContext());
    }

    @Override
    public void hideLoadingDialogue() {
        super.hideLoadingDialog();
    }
}