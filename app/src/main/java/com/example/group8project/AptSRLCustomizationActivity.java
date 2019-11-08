package com.example.group8project;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.group8project.data.Apartment;
import com.example.group8project.data.ApartmentSRL;

public class AptSRLCustomizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apt_srl_customization);


        // init visibilities of all features and bind callback for switches-features
        final ConstraintLayout layout = findViewById(R.id.apt_srl_customization);

        final Switch nameSwitch = layout.findViewById(R.id.nameSwitch);
        nameSwitch.setChecked(ApartmentSRL.nameVisible);
        final View name = layout.findViewById(R.id.name);
        name.setVisibility(ApartmentSRL.nameVisible ? View.VISIBLE : View.GONE);
        nameSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                name.setVisibility(b ? View.VISIBLE : View.GONE);
            }
        });

        final Switch addressSwitch = layout.findViewById(R.id.addressSwitch);
        addressSwitch.setChecked(ApartmentSRL.addressVisible);
        final View address = layout.findViewById(R.id.address);
        address.setVisibility(ApartmentSRL.addressVisible ? View.VISIBLE : View.GONE);
        addressSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                address.setVisibility(b ? View.VISIBLE : View.GONE);
            }
        });

    }
}
