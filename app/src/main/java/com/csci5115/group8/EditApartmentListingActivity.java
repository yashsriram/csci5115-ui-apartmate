package com.csci5115.group8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.csci5115.group8.adapters.ApartmentUnitAdapter;
import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.apartment.Apartment;
import com.csci5115.group8.data.apartment.ApartmentUnit;
import com.csci5115.group8.data.apartment.CommonAmenities;
import com.csci5115.group8.data.apartment.PerUnitAmenities;
import com.csci5115.group8.data.apartment.SecurityFeatures;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class EditApartmentListingActivity extends AppCompatActivity {

    List<ApartmentUnit> apartmentUnits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_apartment_listing);

        final int apartmentId = getIntent().getIntExtra("apartmentId", -1);
        Apartment apartment = DataManager.getApartment(apartmentId);
        if (apartmentId == -1 || apartment == null) {
            Toast.makeText(this, "It seems that the information of this apartment is removed from our system", Toast.LENGTH_LONG).show();
            finish();
        }
        apartmentUnits = apartment.units;


        final ConstraintLayout layout = findViewById(R.id.activity_edit_apartment_listing);

        final RecyclerView recyclerView = layout.findViewById(R.id.unitsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final RecyclerView.Adapter adapter = new ApartmentUnitAdapter(this, apartmentUnits, null);
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
                adapter.notifyDataSetChanged();
                Snackbar.make(view, "Unit created", Snackbar.LENGTH_SHORT).show();
            }
        });

        final EditText name = layout.findViewById(R.id.name);
        final EditText address = layout.findViewById(R.id.address);
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

        name.setText(apartment.name);
        address.setText(apartment.address);

        refrigerator.setChecked(apartment.perUnitAmenities.refrigerator);
        oven.setChecked(apartment.perUnitAmenities.oven);
        microwave.setChecked(apartment.perUnitAmenities.microwave);
        dishwasher.setChecked(apartment.perUnitAmenities.dishwasher);
        washingMachine.setChecked(apartment.perUnitAmenities.washingMachine);
        heating.setChecked(apartment.perUnitAmenities.heating);
        cooling.setChecked(apartment.perUnitAmenities.cooling);

        laundryRoom.setChecked(apartment.commonAmenities.laundryRoom);
        longue.setChecked(apartment.commonAmenities.longue);
        printingService.setChecked(apartment.commonAmenities.printingService);
        reception.setChecked(apartment.commonAmenities.reception);
        parking.setChecked(apartment.commonAmenities.parking);

        securityCameras.setChecked(apartment.securityFeatures.securityCameras);
        smokeDetectors.setChecked(apartment.securityFeatures.smokeDetectors);
        sprinklers.setChecked(apartment.securityFeatures.sprinklers);
        buildingLock.setChecked(apartment.securityFeatures.buildingLock);

        FloatingActionButton submit = layout.findViewById(R.id.submit_edited_apartment_listing);
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
                if (apartmentUnits.size() == 0) {
                    Snackbar.make(view, "Please add at least one unit to", Snackbar.LENGTH_LONG).show();
                    return;
                }
                // Save apartment in data manager
                DataManager.updateApartment(
                        apartmentId,
                        new Apartment(
                                apartmentId,
                                name.getText().toString(),
                                address.getText().toString(),
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
                Toast.makeText(EditApartmentListingActivity.this, "Apartment listing updated. Your level is increased!", Toast.LENGTH_LONG).show();
                // Go back
                finish();
            }
        });
    }
}
