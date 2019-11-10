package com.csci5115.group8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.csci5115.group8.data.user.UserSRL;

public class UserSRLCustomizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_srl_customzation);

        // init visibilities of all features and bind callback for switches-features
        final ConstraintLayout layout = findViewById(R.id.user_srl_customization);

        final Switch ageSwitch = layout.findViewById(R.id.ageSwitch);
        ageSwitch.setChecked(UserSRL.ageVisible);
        final View age = layout.findViewById(R.id.age);
        age.setVisibility(UserSRL.ageVisible ? View.VISIBLE : View.GONE);
        ageSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                age.setVisibility(b ? View.VISIBLE : View.GONE);
                UserSRL.ageVisible = b;
            }
        });

        final Switch genderSwitch = layout.findViewById(R.id.genderSwitch);
        genderSwitch.setChecked(UserSRL.genderVisible);
        final View gender = layout.findViewById(R.id.gender);
        gender.setVisibility(UserSRL.genderVisible ? View.VISIBLE : View.GONE);
        genderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                gender.setVisibility(b ? View.VISIBLE : View.GONE);
                UserSRL.genderVisible = b;
            }
        });

    }

}
