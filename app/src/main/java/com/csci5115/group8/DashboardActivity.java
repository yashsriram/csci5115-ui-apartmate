package com.csci5115.group8;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    private boolean firstExitTry = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        final ConstraintLayout layout = findViewById(R.id.activity_dashboard);
        BottomNavigationView navView = layout.findViewById(R.id.dashboard_nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.dashboard_apt_search, R.id.dashboard_user_search, R.id.dashboard_chat)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard_activity_top_nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.customize_apt_srl:
                Intent i1 = new Intent(this, AptSRLCustomizationActivity.class);
                startActivity(i1);
                return true;
            case R.id.customize_user_srl:
                Intent i2 = new Intent(this, UserSRLCustomizationActivity.class);
                startActivity(i2);
            case R.id.create_apartment_lisiting:
                Intent i3 = new Intent(this, CreateApartmentListingActivity.class);
                startActivity(i3);
            case R.id.edit_your_profile:
                Intent i4 = new Intent(this, EditYourProfileActivity.class);
                startActivity(i4);
                return true;
            case R.id.create_apartment_lisiting:
                Intent i3 = new Intent(this, CreateApartmentListingActivity.class);
                startActivity(i3);
                return true;
            case R.id.edit_your_profile:
                Intent i4 = new Intent(this, EditYourProfileActivity.class);
                startActivity(i4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (firstExitTry) {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
            firstExitTry = false;
            return;
        }
        firstExitTry = true;
        super.onBackPressed();
    }
}
