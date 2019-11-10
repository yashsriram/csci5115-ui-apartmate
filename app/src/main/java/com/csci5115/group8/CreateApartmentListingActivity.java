package com.csci5115.group8;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CreateApartmentListingActivity extends ListActivity {
    List<String> listItems = new ArrayList<>();

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_apartment_listing);

        listItems.add("LOL");
        listItems.add("Foo");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);

        final ConstraintLayout layout = findViewById(R.id.activity_create_apartment_listing);
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
