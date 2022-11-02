package com.example.azmart_android.network.api_manager;

import com.example.azmart_android.data.model.BestProductsResponse;
import com.example.azmart_android.data.model.CategoriesResponse;
import com.example.azmart_android.data.model.SearchResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterFace {
/*    @FormUrlEncoded
    @POST("driver/notifications")
    Call<Notification> postNotificationDetails(
            @Header("Authorization") String token,
            @Field("offset") String offset,
            @Field("limit") String limit);*/

    @GET("api/v2/categories")
    Observable<List<CategoriesResponse>> getCategories();

    @GET("api/bestSales/SortedByNewest")
    Observable<List<BestProductsResponse>> getBestProducts();

    @GET("api/products/search")
    Observable<SearchResponse> searchItems(
            @Query("name") String searchText
    );

    @GET("api/v2/categories")
    Observable<List<CategoriesResponse>> getCategoriesList();

}
