package com.example.newrestaurantadvisor;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestaurantApi {

    @GET("api/restaurants/")
    Call<List<Restaurant>> getRestaurants();

    @GET("api/restaurants/{id}/menus")
    Call<List<Menu>> getMenus(@Path("id") String var);

}
