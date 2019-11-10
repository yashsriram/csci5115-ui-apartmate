package com.csci5115.group8;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.csci5115.group8.data.ApartmentUnit;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class CreateApartmentListingActivity extends AppCompatActivity {

    List<ApartmentUnit> apartmentUnits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_apartment_listing);

        final ConstraintLayout layout = findViewById(R.id.activity_create_apartment_listing);

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
                            Snackbar.make(view, "It seems that this unit is already registered", Snackbar.LENGTH_SHORT).show();
                            return;
                        }
                    }
                } catch (Exception e) {
                    Snackbar.make(view, "Please provide all information of unit", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                // Add a unit
                apartmentUnits.add(new ApartmentUnit(_unitNumber, _numBedrooms, _numBathrooms, _areaSqFt, isLeased.isChecked()));
                adapter.notifyDataSetChanged();
                Snackbar.make(view, "Unit created", Snackbar.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton submit = layout.findViewById(R.id.submit_new_apartment_listing);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validate fields
                // Check for duplicates
                // Save apartment
                finish();
            }
        });
    }

}
