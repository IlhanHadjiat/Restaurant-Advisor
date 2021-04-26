package com.example.newrestaurantadvisor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class MyListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Restaurant> restaurantList;

    public MyListViewAdapter(Context context, List restaurantList) {
        this.context = context;
        this.restaurantList = restaurantList;
    }

    @Override
    public int getCount() {return restaurantList.size();}

    @Override
    public Object getItem(int position) {return restaurantList.get(position);}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.restaurant_raw,null);
        }

        Restaurant restaurant = restaurantList.get(position);

        TextView textViewRestaurantName = (TextView) convertView.findViewById(R.id.restaurant_name);
        TextView textViewRestaurantDescription = (TextView) convertView.findViewById(R.id.restaurant_description);

        textViewRestaurantName.setText(restaurant.getName());
        textViewRestaurantDescription.setText(restaurant.getDescription());

        return convertView;
    }

}
