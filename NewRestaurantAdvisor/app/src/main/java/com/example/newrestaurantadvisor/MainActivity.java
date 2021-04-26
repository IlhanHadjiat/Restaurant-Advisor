package com.example.newrestaurantadvisor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

import com.example.newrestaurantadvisor.Fragments.SignInFragment;

public class MainActivity extends AppCompatActivity {
    private Button loginbutton;
    private Button invitebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginbutton = (Button) findViewById(R.id.login);
        loginbutton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(AuthActivity.class);
            }
        });
        invitebutton = (Button) findViewById(R.id.invite);
        invitebutton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(ListRestoActivity.class);
            }
        });
    }
    public void open(Class oui) {
        Intent intent = new Intent(this, oui);
        startActivity(intent);
    }
}