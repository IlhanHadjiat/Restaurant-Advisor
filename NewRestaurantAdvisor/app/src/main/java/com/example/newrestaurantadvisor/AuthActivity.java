package com.example.newrestaurantadvisor;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.newrestaurantadvisor.Fragments.SignInFragment;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameAuthContainer, new SignInFragment()).commit();
    }

}
