package com.csci5115.group8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import it.beppi.tristatetogglebutton_library.TriStateToggleButton;

public class ApartmentSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_search);

        final ConstraintLayout layout = findViewById(R.id.activity_apartment_search);
        FloatingActionButton submit = layout.findViewById(R.id.submit_apartment_search);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Replace with your own action", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        TriStateToggleButton tstb_1 = findViewById(R.id.buildingLock);
        tstb_1.setOnToggleChanged(new TriStateToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(TriStateToggleButton.ToggleStatus toggleStatus, boolean booleanToggleStatus, int toggleIntValue) {
                switch (toggleStatus) {
                    case off:
                        Toast.makeText(ApartmentSearchActivity.this, "off", Toast.LENGTH_SHORT).show();
                        break;
                    case mid:
                        Toast.makeText(ApartmentSearchActivity.this, "mid", Toast.LENGTH_SHORT).show();
                        break;
                    case on:
                        Toast.makeText(ApartmentSearchActivity.this, "on", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
