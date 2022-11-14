package com.example.azmart_android.network.api_manager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.azmart_android.data.model.BestProductsResponse;
import com.example.azmart_android.data.model.CategoriesResponse;
import com.example.azmart_android.data.model.ProductDetails.ProductDetailsResponse;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.presenter.CategoryPresenter;
import com.example.azmart_android.presenter.HomePresenter;
import com.example.azmart_android.presenter.ProductPresenter;
import com.example.azmart_android.presenter.ProductsPresenter;
import com.example.azmart_android.presenter.SearchPresenter;
import com.example.azmart_android.presenter.WishlistPresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ApiDataManager {
    private final String TAG = "OnNetworkResponse";
    ApiInterFace apiInterFace;
    FirebaseFirestore firebaseFirestore;

    public void searchItemsByName(SearchPresenter presenter, String searchText) {
        try {
            if (apiInterFace == null)
                apiInterFace = ApiClient.getClientServerApi().create(ApiInterFace.class);

            apiInterFace
                    .searchItems(searchText)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<SearchResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(SearchResponse searchResponse) {
                            presenter.onSearchResultResponse(searchResponse);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: " + e.getMessage());
                            presenter.onApiError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                        }
                    });


        } catch (Exception e) {
            presenter.onApiError(e.getMessage());
            Log.e(TAG, "Exception caught in " + e.getMessage().toString());
        }
    }


    public void getHomeDetails(HomePresenter presenter) {
        try {
            if (apiInterFace == null)
                apiInterFace = ApiClient.getClientServerApi().create(ApiInterFace.class);
            Map<String, Object> responseMap = new HashMap<>();

            Observable<List<CategoriesResponse>> observable1 = apiInterFace.getCategories();
            Observable<List<BestProductsResponse>> observable2 = apiInterFace.getBestProducts();

           /* Observable.just(observable1,observable2)
                    .doOnNext(observable -> {
                        Log.d(TAG, "Emitting item " + observable.toString());
                    }).subscribeOn(Schedulers.io())
                    .subscribe(observable -> {
                        Log.d(TAG, "Consuming item " + observable + " on: Subscribe");
                        responseMap.put("bestProducts", observable.toString());
                        presenter.getHomeResponse(responseMap);
                    });*/

            Observable.merge(
                            observable1.subscribeOn(Schedulers.io()),
                            observable2.subscribeOn(Schedulers.io())
                    ).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<? extends Object>>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(List<?> objects) {
                            Log.d(TAG, "onNext: " + objects.get(0));
                            if (objects.get(0) instanceof BestProductsResponse) {
                                presenter.getBestProductsResponse((List<BestProductsResponse>) objects);
                            } else
                                presenter.getCategoriesResponse((List<CategoriesResponse>) objects);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: " + e.getMessage());
                            presenter.onApiError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                        }
                    });


        } catch (Exception e) {
            presenter.onApiError(e.getMessage());
            Log.e(TAG, "Exception caught in " + e.getMessage().toString());
        }
    }

    public void getCategoryList(CategoryPresenter presenter) {

        try {
            if (apiInterFace == null)
                apiInterFace = ApiClient.getClientServerApi().create(ApiInterFace.class);

            apiInterFace
                    .getCategoriesList()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<List<CategoriesResponse>>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(List<CategoriesResponse> categoriesResponse) {
                            presenter.onCategoryResultResponse(categoriesResponse);

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: " + e.getMessage());
                            presenter.onApiError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                        }
                    });


        } catch (Exception e) {
            presenter.onApiError(e.getMessage());
            Log.e(TAG, "Exception caught in " + e.getMessage().toString());
        }

    }

    public void getSearchCategoriesList(HomePresenter presenter) {

        try {
            if (apiInterFace == null)
                apiInterFace = ApiClient.getClientServerApi().create(ApiInterFace.class);

            apiInterFace
                    .getCategoriesList()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<List<CategoriesResponse>>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(List<CategoriesResponse> categoriesResponse) {
                            presenter.onSearchCategoryResultResponse(categoriesResponse);

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: " + e.getMessage());
                            presenter.onApiError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                        }
                    });


        } catch (Exception e) {
            presenter.onApiError(e.getMessage());
            Log.e(TAG, "Exception caught in " + e.getMessage().toString());
        }

    }

    public void getProductsByCategory(ProductsPresenter presenter, String categoryId) {
        try {
            if (apiInterFace == null)
                apiInterFace = ApiClient.getClientServerApi().create(ApiInterFace.class);

            apiInterFace
                    .getProductsByCategory(categoryId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<SearchResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(SearchResponse searchResponse) {
                            presenter.onProductsResultResponse(searchResponse);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: " + e.getMessage());
                            presenter.onApiError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                        }
                    });


        } catch (Exception e) {
            presenter.onApiError(e.getMessage());
            Log.e(TAG, "Exception caught in " + e.getMessage().toString());
        }
    }

    public void getProductByCategory(ProductPresenter presenter, String productId) {
        try {
            if (apiInterFace == null)
                apiInterFace = ApiClient.getClientServerApi().create(ApiInterFace.class);

            apiInterFace
                    .getProductByProductId(productId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<ProductDetailsResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(ProductDetailsResponse productDetailsResponse) {
                            presenter.onProductResultResponse(productDetailsResponse);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: " + e.getMessage());
                            presenter.onApiError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                        }
                    });


        } catch (Exception e) {
            presenter.onApiError(e.getMessage());
            Log.e(TAG, "Exception caught in " + e.getMessage().toString());
        }
    }

    public void addProductToCart(ProductPresenter presenter, Map<String, Object> objectMap) {
        if (firebaseFirestore == null)
            firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("cart")
                .add(objectMap)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        presenter.onAddToCartResponse("Added to cart successfully");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        presenter.onApiError(e.getMessage());
                        Log.e(TAG, "Exception caught in " + e.getMessage().toString());
                    }
                });
    }

    public void addProductToWishlist(ProductPresenter presenter, Map<String, Object> objectMap) {
        if (firebaseFirestore == null)
            firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("wishlist")
                .add(objectMap)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        presenter.onAddToWishlistResponse("Added to wishlist successfully");
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                presenter.onApiError(e.getMessage());
                Log.e(TAG, "Exception caught in " + e.getMessage().toString());
            }
        });
    }

    public void isExistProductInWishlist(ProductPresenter presenter, Map<String, Object> objectMap) {
        if (firebaseFirestore == null)
            firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("wishlist").whereEqualTo("product_id",objectMap.get("product_id")).whereEqualTo("user_id",objectMap.get("user_id"))
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            presenter.isExistWishlistResponse("isExist");
                        }else {
                            Log.e("database data :","Data Not rerived");
                        }
                    }

        });
    }

    public void deleteProductFromWishlist(ProductPresenter presenter, Map<String, Object> objectMap) {
        if (firebaseFirestore == null)
            firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("wishlist").whereEqualTo("product_id",objectMap.get("product_id")).whereEqualTo("user_id",objectMap.get("user_id"))
                .get()
        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()  && !task.getResult().isEmpty()) {
                    DocumentSnapshot document = task.getResult().getDocuments().get(0);
                    String documentId = document.getId();
                    firebaseFirestore.collection("wishlist")
                            .document(documentId)
                            .delete()
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    presenter.deleteProductInWishlistResponse("Removed From Wishlist");
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            presenter.deleteProductInWishlistResponse("Error Removed From Wishlist");
                        }
                    });

                }
            }
        });
    }

    public void getProductsFromWishlist(WishlistPresenter presenter, String userId) {
        if (firebaseFirestore == null)
            firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("wishlist").whereEqualTo("user_id",userId)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            presenter.onWishlistProductResultResponse("wishlist");
//                            presenter.onWishlistProductResultResponse(task.getResult());
                        }else {
                            Log.e("message","Error");
                        }
                    }

                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                presenter.onApiError(e.getMessage());
                Log.e(TAG, "Exception caught in " + e.getMessage().toString());
            }
        });
    }

}