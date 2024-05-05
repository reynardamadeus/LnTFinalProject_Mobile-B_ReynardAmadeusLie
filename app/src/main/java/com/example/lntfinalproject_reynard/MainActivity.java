package com.example.lntfinalproject_reynard;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    CounterFragment counter_page = new CounterFragment();
    LuasFragment luas_page = new LuasFragment();
    VolumeFragment volume_page = new VolumeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, counter_page).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int item_id = menuItem.getItemId();

                if(item_id == R.id.counter)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, counter_page).commit();
                    return true;
                }else if(item_id == R.id.luas)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, luas_page).commit();
                    return true;
                }else if(item_id == R.id.volume)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, volume_page).commit();
                    return true;
                }else
                {
                    return false;
                }
            }
        });


    }
}