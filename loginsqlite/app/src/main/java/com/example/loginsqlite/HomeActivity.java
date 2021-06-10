package com.example.loginsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.loginsqlite.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_menu, R.id.navigation_mymusic, R.id.navigation_user)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_home);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        /*Button btnChinese = (Button)findViewById(R.id.chinese);
        Button btnEnglish = (Button)findViewById(R.id.english);
        Button btnKorean = (Button)findViewById(R.id.korean);
        Button btnJapanese = (Button)findViewById(R.id.japanese);
        Button btnClassical = (Button)findViewById(R.id.classical);
        Button btnElectronic = (Button)findViewById(R.id.electronic);

        btnChinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String message = "1";
                        Intent intent = new Intent(HomeActivity.this, MusicTypeActivity.class);
                        //intent.setClass(this, MusicTypeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("MESSAGE", message);
                        Log.d("1: ",message);
                        intent.putExtras(bundle);
                        //setResult(2, intent);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);
            }
        });*/
    }

}