package com.csci5115.group8;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.user.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditYourProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_your_profile);

        User currentUser = DataManager.currentUser;
        final TextView isVerified = findViewById(R.id.isVerified);
        final EditText name = findViewById(R.id.name);
        final EditText email = findViewById(R.id.email);
        final EditText age = findViewById(R.id.age);
        final EditText maxBudget = findViewById(R.id.maxBudget);
        final EditText gender = findViewById(R.id.gender);
        final EditText nativeLanguage = findViewById(R.id.nativeLanguage);
        final CheckBox doesSmoke = findViewById(R.id.doesSmoke);
        final CheckBox drugsOkay = findViewById(R.id.drugsOkay);
        final CheckBox hasPets = findViewById(R.id.hasPets);
        final CheckBox partiesOkay = findViewById(R.id.partiesOkay);
        final CheckBox canCook = findViewById(R.id.canCook);
        final CheckBox hasCar = findViewById(R.id.hasCar);
        final CheckBox needsPrivateBedroom = findViewById(R.id.needsPrivateBedroom);
        final ImageView image = findViewById(R.id.image);

        isVerified.setText(currentUser.isVerified ? "VERIFIED" : "NOT VERIFIED");
        isVerified.setTextColor(currentUser.isVerified ? Color.GREEN : Color.RED);
        name.setText(currentUser.name);
        email.setText(currentUser.email);
        age.setText(String.format("%s", currentUser.age));
        maxBudget.setText(String.format("%s", currentUser.maxBudget));
        gender.setText(currentUser.gender);
        nativeLanguage.setText(currentUser.nativeLanguage);
        doesSmoke.setChecked(currentUser.preferences.doesSmoke);
        drugsOkay.setChecked(currentUser.preferences.drugsOkay);
        hasPets.setChecked(currentUser.preferences.hasPets);
        partiesOkay.setChecked(currentUser.preferences.partiesOkay);
        canCook.setChecked(currentUser.preferences.canCook);
        needsPrivateBedroom.setChecked(currentUser.preferences.needsPrivateBedroom);
        hasCar.setChecked(currentUser.preferences.hasCar);

        FloatingActionButton submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get fields
                // Validate (all fields filled, email should not be duplicate)
                // Save user
                finish();
            }

        });
    }
}
