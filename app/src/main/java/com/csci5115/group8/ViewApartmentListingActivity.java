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
import android.widget.TextView;
import android.widget.Toast;

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

public class ViewApartmentListingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_apartment_listing);

        int apartmentId = getIntent().getIntExtra("apartmentId", -1);
        Apartment apartment = DataManager.getApartment(apartmentId);
        if (apartmentId == -1 || apartment == null) {
            Toast.makeText(this, "It seems that the information of this apartment is removed from our system", Toast.LENGTH_LONG).show();
            finish();
        }

        final ConstraintLayout layout = findViewById(R.id.activity_view_apartment_listing);

        final RecyclerView recyclerView = layout.findViewById(R.id.unitsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<ApartmentUnit> apartmentUnits = apartment.units;
        final RecyclerView.Adapter adapter = new ApartmentUnitAdapter(this, apartmentUnits, null);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        final TextView name = layout.findViewById(R.id.name);
        final TextView address = layout.findViewById(R.id.address);
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

        FloatingActionButton submit = layout.findViewById(R.id.submit_new_apartment_listing);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
