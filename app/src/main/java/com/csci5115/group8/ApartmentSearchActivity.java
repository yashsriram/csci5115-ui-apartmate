package com.csci5115.group8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.apartment.Apartment;
import com.csci5115.group8.ui.aptsearch.ApartmentSearchFragment;
import com.csci5115.group8.ui.aptsearch.ApartmentSearchState;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import it.beppi.tristatetogglebutton_library.TriStateToggleButton;

public class ApartmentSearchActivity extends AppCompatActivity {
    EditText searchText;
    TextView numMatches;
    TriStateToggleButton refrigerator;
    TriStateToggleButton oven;
    TriStateToggleButton microwave;
    TriStateToggleButton dishwasher;
    TriStateToggleButton washingMachine;
    TriStateToggleButton heating;
    TriStateToggleButton cooling;

    TriStateToggleButton laundryRoom;
    TriStateToggleButton longue;
    TriStateToggleButton printingService;
    TriStateToggleButton reception;
    TriStateToggleButton parking;

    TriStateToggleButton securityCameras;
    TriStateToggleButton smokeDetectors;
    TriStateToggleButton sprinklers;
    TriStateToggleButton buildingLock;

    final TriStateToggleButton.OnToggleChanged updateNumberOfMatches = new TriStateToggleButton.OnToggleChanged() {
        @Override
        public void onToggle(TriStateToggleButton.ToggleStatus toggleStatus, boolean b, int i) {
            numMatches.setText(getNumSearchResults() + " Matches");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_search);

        final ConstraintLayout layout = findViewById(R.id.activity_apartment_search);

        searchText = layout.findViewById(R.id.searchText);
        numMatches = layout.findViewById(R.id.numMatches);

        // Setting on toggle changed listeners
        refrigerator = layout.findViewById(R.id.refrigerator);
        refrigerator.setOnToggleChanged(updateNumberOfMatches);
        oven = layout.findViewById(R.id.oven);
        oven.setOnToggleChanged(updateNumberOfMatches);
        microwave = layout.findViewById(R.id.microwave);
        microwave.setOnToggleChanged(updateNumberOfMatches);
        dishwasher = layout.findViewById(R.id.dishwasher);
        dishwasher.setOnToggleChanged(updateNumberOfMatches);
        washingMachine = layout.findViewById(R.id.washingMachine);
        washingMachine.setOnToggleChanged(updateNumberOfMatches);
        heating = layout.findViewById(R.id.heating);
        heating.setOnToggleChanged(updateNumberOfMatches);
        cooling = layout.findViewById(R.id.cooling);
        cooling.setOnToggleChanged(updateNumberOfMatches);
        laundryRoom = layout.findViewById(R.id.laundryRoom);
        laundryRoom.setOnToggleChanged(updateNumberOfMatches);
        longue = layout.findViewById(R.id.longue);
        longue.setOnToggleChanged(updateNumberOfMatches);
        printingService = layout.findViewById(R.id.printingService);
        printingService.setOnToggleChanged(updateNumberOfMatches);
        reception = layout.findViewById(R.id.reception);
        reception.setOnToggleChanged(updateNumberOfMatches);
        parking = layout.findViewById(R.id.parking);
        parking.setOnToggleChanged(updateNumberOfMatches);
        securityCameras = layout.findViewById(R.id.securityCameras);
        securityCameras.setOnToggleChanged(updateNumberOfMatches);
        smokeDetectors = layout.findViewById(R.id.smokeDetectors);
        smokeDetectors.setOnToggleChanged(updateNumberOfMatches);
        sprinklers = layout.findViewById(R.id.sprinklers);
        sprinklers.setOnToggleChanged(updateNumberOfMatches);
        buildingLock = layout.findViewById(R.id.buildingLock);
        buildingLock.setOnToggleChanged(updateNumberOfMatches);

        // Setting on key press listener
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                numMatches.setText(getNumSearchResults() + " Matches");
            }
        });

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

        // Show number of matches using regex matching across all apartments by default == len of all apartments
        numMatches.setText(DataManager.apartments.size() + " Matches");
    }

    private int toggleStatusToInt(TriStateToggleButton.ToggleStatus toggleStatus) {
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

    private int getNumSearchResults() {
        String searchString = searchText.getText().toString();
        List<Apartment> searchResults = DataManager.searchApartments(new ApartmentSearchState(
                searchString,
                toggleStatusToInt(refrigerator.getToggleStatus()),
                toggleStatusToInt(oven.getToggleStatus()),
                toggleStatusToInt(microwave.getToggleStatus()),
                toggleStatusToInt(dishwasher.getToggleStatus()),
                toggleStatusToInt(washingMachine.getToggleStatus()),
                toggleStatusToInt(heating.getToggleStatus()),
                toggleStatusToInt(cooling.getToggleStatus()),

                toggleStatusToInt(laundryRoom.getToggleStatus()),
                toggleStatusToInt(longue.getToggleStatus()),
                toggleStatusToInt(printingService.getToggleStatus()),
                toggleStatusToInt(reception.getToggleStatus()),
                toggleStatusToInt(parking.getToggleStatus()),

                toggleStatusToInt(securityCameras.getToggleStatus()),
                toggleStatusToInt(smokeDetectors.getToggleStatus()),
                toggleStatusToInt(sprinklers.getToggleStatus()),
                toggleStatusToInt(buildingLock.getToggleStatus())
        ));
        return searchResults.size();
    }
}
