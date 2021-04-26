package com.example.newrestaurantadvisor;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

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

public class FicheRestoActivity extends AppCompatActivity {

    private final String TAG = "FicheRestoActivity";
    private static RestaurantApi restaurantApi;
    private Retrofit retrofit;
    private MyListViewAdapter2 myListViewAdapter;
    private List<Menu> menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_resto);

        //Envoyer les infos du resto séléctionné dans l'activité fiche
        String restoName = getIntent().getStringExtra("restName");
        TextView textView = (TextView) findViewById(R.id.RestoName);
        textView.setText(restoName);
        String restoDesc = getIntent().getStringExtra("restDesc");
        TextView textView2 = (TextView) findViewById(R.id.RestoDescription);
        textView2.setText(restoDesc);
        String restoGrade = getIntent().getStringExtra("restGrade");
        TextView textView3 = (TextView) findViewById(R.id.RestoGrade);
        textView3.setText(restoGrade);
        String restoLocalization = getIntent().getStringExtra("restLocalization");
        TextView textView4 = (TextView) findViewById(R.id.RestoLocalization);
        textView4.setText(restoLocalization);
        String restoPhone = getIntent().getStringExtra("restPhone");
        TextView textView5 = (TextView) findViewById(R.id.RestoPhone);
        textView5.setText(restoPhone);
        String restoWebsite = getIntent().getStringExtra("restNWebsite");
        TextView textView6 = (TextView) findViewById(R.id.RestoWebsite);
        textView6.setText(restoWebsite);
        String restoHours = getIntent().getStringExtra("restHours");
        TextView textView7 = (TextView) findViewById(R.id.RestoHours);
        textView7.setText(restoHours);

        menus = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.ListViewMenu);
        this.myListViewAdapter = new MyListViewAdapter2(getApplicationContext(), menus);
        listView.setAdapter(myListViewAdapter);

        listView.setOnItemClickListener((parent, view, position, id)->{
            Menu menu1 = menus.get(position);
            startActivity(menu1.getName(), menu1.getDescription(), menu1.getPrice());
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Menu menu_oui = menus.get(position);
                startActivity(menu_oui.getName(), menu_oui.getDescription(), menu_oui.getPrice());
            }
        });
        this.configureRetrofit();

        String id = getIntent().getStringExtra("restID");
        getMenusVieAPI(id);

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

    private void startActivity(String menuName, String menuDescription, String menuPrice){
        Intent intent = new Intent(this, FicheMenuActivity.class);
        intent.putExtra("menuName", menuName);
        intent.putExtra("menuDesc", menuDescription);
        intent.putExtra("menuPrice", menuPrice);
        startActivity(intent);
    }

    private void getMenusVieAPI(String id) {
        restaurantApi.getMenus(id).enqueue(new Callback<List<Menu>>(){
            @Override
            public void onResponse(@NotNull Call<List<Menu>> call, @NotNull Response<List<Menu>> response){
                Log.d(TAG, "onResponse:");

                List<Menu> menuList = response.body();
                if(menuList != null){
                    for(Menu menu: menuList){
                        Log.d(TAG, "menu reçu: ID= " + menu.getID() + " Nom= " + menu.getName());
                        menus.add(menu);
                    }
                    myListViewAdapter.notifyDataSetChanged();
                } else {
                    Log.d(TAG, "onResponse: menus is empty");
                }
            }
            @Override
            public void onFailure(@NotNull Call<List<Menu>> call, @NotNull Throwable t){
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}