package com.example.newrestaurantadvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FicheMenuActivity extends AppCompatActivity {

    private static RestaurantApi restaurantApi;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_menu);

        //Envoyer les infos du menu séléctionné dans l'activité fiche
        String menuName = getIntent().getStringExtra("menuName");
        TextView textView = (TextView) findViewById(R.id.MenuName);
        textView.setText(menuName);
        String menuDesc = getIntent().getStringExtra("menuDesc");
        TextView textView2 = (TextView) findViewById(R.id.MenuDesc);
        textView2.setText(menuDesc);
        String menuPrice = getIntent().getStringExtra("menuPrice");
        TextView textView3 = (TextView) findViewById(R.id.MenuPrice);
        textView3.setText(menuPrice);


        this.configureRetrofit();
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
}