package com.csci5115.group8;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.csci5115.group8.data.ApartmentSRL;

public class AptSRLCustomizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apt_srl_customization);


        // init visibilities of all features and bind callback for switches-features
        final ConstraintLayout layout = findViewById(R.id.activity_apt_srl_customization);

        final Switch addressSwitch = layout.findViewById(R.id.addressSwitch);
        addressSwitch.setChecked(ApartmentSRL.addressVisible);
        final View address = layout.findViewById(R.id.address);
        address.setVisibility(ApartmentSRL.addressVisible ? View.VISIBLE : View.GONE);
        addressSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                address.setVisibility(b ? View.VISIBLE : View.GONE);
                ApartmentSRL.addressVisible = b;
            }
        });

        final Switch perUnitAmenitiesSwitch = layout.findViewById(R.id.perUnitAmenitiesSwitch);
        perUnitAmenitiesSwitch.setChecked(ApartmentSRL.perUnitAmenitiesVisible);
        final View perUnitAmenities = layout.findViewById(R.id.perUnitAmenities);
        perUnitAmenities.setVisibility(ApartmentSRL.perUnitAmenitiesVisible ? View.VISIBLE : View.GONE);
        perUnitAmenitiesSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                perUnitAmenities.setVisibility(b ? View.VISIBLE : View.GONE);
                ApartmentSRL.perUnitAmenitiesVisible = b;
            }
        });

        final Switch commonAmenitiesSwitch = layout.findViewById(R.id.commonAmenitiesSwitch);
        commonAmenitiesSwitch.setChecked(ApartmentSRL.commonAmenitiesVisible);
        final View commonAmenities = layout.findViewById(R.id.commonAmenities);
        commonAmenities.setVisibility(ApartmentSRL.commonAmenitiesVisible ? View.VISIBLE : View.GONE);
        commonAmenitiesSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                commonAmenities.setVisibility(b ? View.VISIBLE : View.GONE);
                ApartmentSRL.commonAmenitiesVisible = b;
            }
        });

        final Switch securityFeaturesSwitch = layout.findViewById(R.id.securityFeaturesSwitch);
        securityFeaturesSwitch.setChecked(ApartmentSRL.securityFeaturesVisible);
        final View securityFeatures = layout.findViewById(R.id.securityFeatures);
        securityFeatures.setVisibility(ApartmentSRL.securityFeaturesVisible ? View.VISIBLE : View.GONE);
        securityFeaturesSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                securityFeatures.setVisibility(b ? View.VISIBLE : View.GONE);
                ApartmentSRL.securityFeaturesVisible = b;
            }
        });

    }
}
