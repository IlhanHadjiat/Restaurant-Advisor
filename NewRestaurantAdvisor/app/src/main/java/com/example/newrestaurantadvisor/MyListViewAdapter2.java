package com.example.newrestaurantadvisor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class MyListViewAdapter2 extends BaseAdapter {
    private Context context;
    private List<Menu> menuList;

    public MyListViewAdapter2(Context context, List menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @Override
    public int getCount() {return menuList.size();}

    @Override
    public Object getItem(int position) {return menuList.get(position);}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.menu_raw,null);
        }

        Menu menu = menuList.get(position);

        TextView textViewMenuID = (TextView) convertView.findViewById(R.id.menu_id);
        TextView textViewMenuName = (TextView) convertView.findViewById(R.id.menu_name);

        textViewMenuID.setText(menu.getID());
        textViewMenuName.setText(menu.getName());

        return convertView;
    }

}
