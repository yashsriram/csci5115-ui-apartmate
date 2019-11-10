package com.csci5115.group8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.csci5115.group8.data.DataManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import it.beppi.tristatetogglebutton_library.TriStateToggleButton;

public class ApartmentSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_search);

        final ConstraintLayout layout = findViewById(R.id.activity_apartment_search);

        final EditText searchText = layout.findViewById(R.id.searchText);
        final TextView numMatches = layout.findViewById(R.id.numMatches);
        searchText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                // Get search string
                String string = searchText.getText().toString();
                // Show number of matches using regex matching across all apartments
                return false;
            }
        });
        // Show number of matches using regex matching across all apartments by default == len of all apartments
        numMatches.setText(DataManager.getInstance().apartments.size() + " Matches");

        final TriStateToggleButton refrigerator = layout.findViewById(R.id.refrigerator);
        final TriStateToggleButton oven = layout.findViewById(R.id.oven);
        final TriStateToggleButton microwave = layout.findViewById(R.id.microwave);
        final TriStateToggleButton dishwasher = layout.findViewById(R.id.dishwasher);
        final TriStateToggleButton washingMachine = layout.findViewById(R.id.washingMachine);
        final TriStateToggleButton heating = layout.findViewById(R.id.heating);
        final TriStateToggleButton cooling = layout.findViewById(R.id.cooling);

        final TriStateToggleButton laundryRoom = layout.findViewById(R.id.laundryRoom);
        final TriStateToggleButton longue = layout.findViewById(R.id.longue);
        final TriStateToggleButton printingService = layout.findViewById(R.id.printingService);
        final TriStateToggleButton reception = layout.findViewById(R.id.reception);
        final TriStateToggleButton parking = layout.findViewById(R.id.parking);

        final TriStateToggleButton securityCameras = layout.findViewById(R.id.securityCameras);
        final TriStateToggleButton smokeDetectors = layout.findViewById(R.id.smokeDetectors);
        final TriStateToggleButton sprinklers = layout.findViewById(R.id.sprinklers);
        final TriStateToggleButton buildingLock = layout.findViewById(R.id.buildingLock);

        FloatingActionButton submit = layout.findViewById(R.id.submit_apartment_search);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Collect data, serialize and put in intent
                Intent returnIntent = new Intent();
                returnIntent.putExtra("searchText", searchText.getText().toString());
                setResult(AppCompatActivity.RESULT_OK, returnIntent);

                returnIntent.putExtra("refrigerator", toggleStatusToInt(refrigerator.getToggleStatus()));
                returnIntent.putExtra("oven", toggleStatusToInt(oven.getToggleStatus()));
                returnIntent.putExtra("microwave", toggleStatusToInt(microwave.getToggleStatus()));
                returnIntent.putExtra("dishwasher", toggleStatusToInt(dishwasher.getToggleStatus()));
                returnIntent.putExtra("washingMachine", toggleStatusToInt(washingMachine.getToggleStatus()));
                returnIntent.putExtra("heating", toggleStatusToInt(heating.getToggleStatus()));
                returnIntent.putExtra("cooling", toggleStatusToInt(cooling.getToggleStatus()));

                returnIntent.putExtra("laundryRoom", toggleStatusToInt(laundryRoom.getToggleStatus()));
                returnIntent.putExtra("longue", toggleStatusToInt(longue.getToggleStatus()));
                returnIntent.putExtra("printingService", toggleStatusToInt(printingService.getToggleStatus()));
                returnIntent.putExtra("reception", toggleStatusToInt(reception.getToggleStatus()));
                returnIntent.putExtra("parking", toggleStatusToInt(parking.getToggleStatus()));

                returnIntent.putExtra("securityCameras", toggleStatusToInt(securityCameras.getToggleStatus()));
                returnIntent.putExtra("smokeDetectors", toggleStatusToInt(smokeDetectors.getToggleStatus()));
                returnIntent.putExtra("sprinklers", toggleStatusToInt(sprinklers.getToggleStatus()));
                returnIntent.putExtra("buildingLock", toggleStatusToInt(buildingLock.getToggleStatus()));
                // Finish
                finish();
            }
        });
    }

    int toggleStatusToInt(TriStateToggleButton.ToggleStatus toggleStatus) {
        switch (toggleStatus) {
            case on:
                return 2;
            case mid:
                return 1;
            case off:
                return 0;
        }
        return -1;
    }
}
