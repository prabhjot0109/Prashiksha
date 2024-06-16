package com.example.prashiksha;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.prashiksha.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.prashiksha.databinding.ActivityInterface2Binding;  // Ensure this matches your layout file name

public class Interface2Activity extends AppCompatActivity {

    private ActivityInterface2Binding binding;  // Correct the binding class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInterface2Binding.inflate(getLayoutInflater());  // Ensure this matches your layout file name
        setContentView(binding.getRoot());

        BottomNavigationView navView2 = binding.navView2;  // Access navView directly from binding
        // Passing each menu ID as a set of IDs because each menu should be considered as top-level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                com.example.prashiksha.R.id.navigation_home2, R.id.navigation_bits2, R.id.navigation_fix2, R.id.navigation_resources2, R.id.navigation_cult2)
                .build();
        NavController navController2 = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main2);
        NavigationUI.setupActionBarWithNavController(this, navController2, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView2, navController2);
    }
}
