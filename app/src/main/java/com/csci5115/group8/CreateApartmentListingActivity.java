package com.csci5115.group8;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.csci5115.group8.adapters.ApartmentUnitAdapter;
import com.csci5115.group8.data.apartment.Apartment;
import com.csci5115.group8.data.apartment.ApartmentUnit;
import com.csci5115.group8.data.apartment.CommonAmenities;
import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.apartment.PerUnitAmenities;
import com.csci5115.group8.data.apartment.SecurityFeatures;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class CreateApartmentListingActivity extends AppCompatActivity {

    List<ApartmentUnit> apartmentUnits = new ArrayList<>();
    RecyclerView recyclerView;
    ApartmentUnitAdapter.ItemClickListener itemClickListener = new ApartmentUnitAdapter.ItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(CreateApartmentListingActivity.this, "Del " + position, Toast.LENGTH_SHORT).show();
            apartmentUnits.remove(position);
            final RecyclerView.Adapter adapter = new ApartmentUnitAdapter(getApplicationContext(), apartmentUnits, itemClickListener);
            recyclerView.setAdapter(adapter);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_apartment_listing);

        final ConstraintLayout layout = findViewById(R.id.activity_create_apartment_listing);

        recyclerView = layout.findViewById(R.id.unitsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final RecyclerView.Adapter adapter = new ApartmentUnitAdapter(this, apartmentUnits, itemClickListener);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        final EditText unitNumber = layout.findViewById(R.id.unitNumber);
        final EditText numBedrooms = layout.findViewById(R.id.numBedrooms);
        final EditText numBathrooms = layout.findViewById(R.id.numBathrooms);
        final EditText areaInSqFt = layout.findViewById(R.id.areaInSqFt);
        final CheckBox isLeased = layout.findViewById(R.id.isLeased);
        final Button createUnitButton = layout.findViewById(R.id.createUnitButton);
        createUnitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validate
                int _unitNumber;
                int _numBedrooms;
                int _numBathrooms;
                float _areaSqFt;
                try {
                    _unitNumber = Integer.parseInt(unitNumber.getText().toString());
                    _numBedrooms = Integer.parseInt(numBedrooms.getText().toString());
                    _numBathrooms = Integer.parseInt(numBathrooms.getText().toString());
                    _areaSqFt = Float.parseFloat(areaInSqFt.getText().toString());
                    for (ApartmentUnit unit : apartmentUnits) {
                        if (_unitNumber == unit.unitNumber) {
                            Snackbar.make(view, "It seems that this unit is already registered", Snackbar.LENGTH_LONG).show();
                            return;
                        }
                    }
                } catch (Exception e) {
                    Snackbar.make(view, "Please provide all information of unit", Snackbar.LENGTH_LONG).show();
                    return;
                }
                // Add a unit
                apartmentUnits.add(new ApartmentUnit(_unitNumber, _numBedrooms, _numBathrooms, _areaSqFt, isLeased.isChecked()));
                final RecyclerView.Adapter adapter = new ApartmentUnitAdapter(getApplicationContext(), apartmentUnits, itemClickListener);
                recyclerView.setAdapter(adapter);
                Snackbar.make(view, "Unit created", Snackbar.LENGTH_SHORT).show();
            }
        });

        final EditText name = layout.findViewById(R.id.name);
        final EditText address = layout.findViewById(R.id.address);
        final EditText videoTourUrl = layout.findViewById(R.id.videoTourUrl);
        final CheckBox refrigerator = layout.findViewById(R.id.refrigerator);
        final CheckBox oven = layout.findViewById(R.id.oven);
        final CheckBox microwave = layout.findViewById(R.id.microwave);
        final CheckBox dishwasher = layout.findViewById(R.id.dishwasher);
        final CheckBox washingMachine = layout.findViewById(R.id.washingMachine);
        final CheckBox heating = layout.findViewById(R.id.heating);
        final CheckBox cooling = layout.findViewById(R.id.cooling);

        final CheckBox laundryRoom = layout.findViewById(R.id.laundryRoom);
        final CheckBox longue = layout.findViewById(R.id.longue);
        final CheckBox printingService = layout.findViewById(R.id.printingService);
        final CheckBox reception = layout.findViewById(R.id.reception);
        final CheckBox parking = layout.findViewById(R.id.parking);

        final CheckBox securityCameras = layout.findViewById(R.id.securityCameras);
        final CheckBox smokeDetectors = layout.findViewById(R.id.smokeDetectors);
        final CheckBox sprinklers = layout.findViewById(R.id.sprinklers);
        final CheckBox buildingLock = layout.findViewById(R.id.buildingLock);

        FloatingActionButton submit = layout.findViewById(R.id.submit_new_apartment_listing);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validate fields
                if (name.getText().toString().isEmpty()) {
                    Snackbar.make(view, "Please enter the apartment building name", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (address.getText().toString().isEmpty()) {
                    Snackbar.make(view, "Please enter the apartment building address", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (videoTourUrl.getText().toString().isEmpty()) {
                    Snackbar.make(view, "Please enter the video tour embed code", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (apartmentUnits.size() == 0) {
                    Snackbar.make(view, "Please add at least one unit to", Snackbar.LENGTH_LONG).show();
                    return;
                }
                // Check for duplicates
                Apartment apartment = DataManager.getApartment(address.getText().toString());
                if (apartment != null) {
                    Snackbar.make(view, "Apartment with same address is already registered. Please edit that", Snackbar.LENGTH_LONG).show();
                    return;
                }
                // Save apartment in data manager
                DataManager.createApartment(
                        new Apartment(
                                DataManager.getNumAparments(),
                                name.getText().toString(),
                                address.getText().toString(),
                                videoTourUrl.getText().toString(),
                                new PerUnitAmenities(
                                        refrigerator.isChecked(),
                                        oven.isChecked(),
                                        microwave.isChecked(),
                                        dishwasher.isChecked(),
                                        washingMachine.isChecked(),
                                        heating.isChecked(),
                                        cooling.isChecked()),
                                new CommonAmenities(
                                        laundryRoom.isChecked(),
                                        longue.isChecked(),
                                        printingService.isChecked(),
                                        reception.isChecked(),
                                        parking.isChecked()
                                ),
                                new SecurityFeatures(
                                        securityCameras.isChecked(),
                                        smokeDetectors.isChecked(),
                                        sprinklers.isChecked(),
                                        buildingLock.isChecked()
                                ),
                                apartmentUnits
                        )
                );
                Toast.makeText(CreateApartmentListingActivity.this, "New apartment listing created. Your level is increased!", Toast.LENGTH_LONG).show();
                // Go back
                finish();
            }
        });
    }

}
