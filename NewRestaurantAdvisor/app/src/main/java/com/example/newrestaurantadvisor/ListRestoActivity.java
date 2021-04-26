package com.example.newrestaurantadvisor;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListRestoActivity extends AppCompatActivity {

    private final String TAG = "ListRestoActivity";
    private static RestaurantApi restaurantApi;
    private Retrofit retrofit;
    private MyListViewAdapter myListViewAdapter;
    private List<Restaurant> restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_resto);

        restaurants = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.ListViewResto);

        this.myListViewAdapter = new MyListViewAdapter(getApplicationContext(), restaurants);
        listView.setAdapter(myListViewAdapter);

        listView.setOnItemClickListener((parent, view, position, id)->{
            Restaurant restaurant1 = restaurants.get(position);
            startActivity(restaurant1.getName(), restaurant1.getID(), restaurant1.getDescription(), restaurant1.getGrade(), restaurant1.getLocalization(), restaurant1.getPhone(), restaurant1.getWebsite(), restaurant1.getHours());
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Restaurant restaurant_oui = restaurants.get(position);
                startActivity(restaurant_oui.getName(), restaurant_oui.getID(), restaurant_oui.getDescription(), restaurant_oui.getGrade(), restaurant_oui.getLocalization(), restaurant_oui.getPhone(), restaurant_oui.getWebsite(), restaurant_oui.getHours());
            }
        });
        this.configureRetrofit();

        getRestaurantsVieAPI();

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private void configureRetrofit(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.81:80/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restaurantApi = retrofit.create(RestaurantApi.class);
    }

    private void startActivity(String restaurantName, String restaurantID, String restaurantDesription, String restaurantGrade, String restaurantLocalization, String restaurantPhone, String restaurantWebsite, String restaurantHours){
        Intent intent = new Intent(this, FicheRestoActivity.class);
        intent.putExtra("restID", restaurantID);
        intent.putExtra("restName", restaurantName);
        intent.putExtra("restDesc", restaurantDesription);
        intent.putExtra("restGrade", restaurantGrade);
        intent.putExtra("restLocalization", restaurantLocalization);
        intent.putExtra("restPhone", restaurantPhone);
        intent.putExtra("restWebsite", restaurantWebsite);
        intent.putExtra("restHours", restaurantHours);
        startActivity(intent);
    }

    private void getRestaurantsVieAPI() {
        restaurantApi.getRestaurants().enqueue(new Callback<List<Restaurant>>(){
            @Override
            public void onResponse(@NotNull Call<List<Restaurant>> call, @NotNull Response<List<Restaurant>> response){
                Log.d(TAG, "onResponse:");

                List<Restaurant> restaurantsList = response.body();
                if(restaurantsList != null){
                    for(Restaurant restaurant: restaurantsList){
                        Log.d(TAG, "restaurant reçu: ID= " + restaurant.getID() + " Nom= " + restaurant.getName());
                        restaurants.add(restaurant);
                    }
                    myListViewAdapter.notifyDataSetChanged();
                } else {
                    Log.d(TAG, "onResponse: restaurants is empty");
                }
            }
            @Override
            public void onFailure(@NotNull Call<List<Restaurant>> call, @NotNull Throwable t){
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}