package com.example.emargencyhelpline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
  BottomNavigationView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        bottomNavView=findViewById(R.id.bottom_nav_bar);
        if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HomeNavigation()).commit();
        }
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                if (item.getItemId()==R.id.home_nav)
                {
                    fragment=new HomeNavigation();
                }
                if (item.getItemId()==R.id.prfile_nav)
                {
                    fragment=new ProfileNavigation();
                }
                if (item.getItemId()==R.id.history_nav)
                {
                    fragment=new HistoryNavigation();
                }
                if (item.getItemId()==R.id.settings_nav)
                {
                    fragment=new SettingsNavigation();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();

             return false;
            }
        });
    }
}