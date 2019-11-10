package com.csci5115.group8;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.csci5115.group8.data.Apartment;
import com.csci5115.group8.data.ApartmentUnit;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CreateApartmentListingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_apartment_listing);

        final ConstraintLayout layout = findViewById(R.id.activity_create_apartment_listing);

        List<ApartmentUnit> apartmentUnits = new ArrayList<>();
        apartmentUnits.add(new ApartmentUnit(1, 2, 3, 100.1f, false));
        apartmentUnits.add(new ApartmentUnit(1, 2, 3, 100.1f, false));
        apartmentUnits.add(new ApartmentUnit(1, 2, 3, 100.1f, false));
        apartmentUnits.add(new ApartmentUnit(1, 2, 3, 100.1f, false));
        apartmentUnits.add(new ApartmentUnit(1, 2, 3, 100.1f, false));
        apartmentUnits.add(new ApartmentUnit(1, 2, 3, 100.1f, false));
        apartmentUnits.add(new ApartmentUnit(1, 2, 3, 100.1f, false));

        RecyclerView recyclerView = layout.findViewById(R.id.unitsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.Adapter adapter = new ApartmentUnitAdapter(this, apartmentUnits, null);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

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
