package com.csci5115.group8;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.user.User;
import com.csci5115.group8.data.user.UserPreferences;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.InputStream;

public class EditYourProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_your_profile);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final User currentUser = DataManager.currentUser;
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
        final TextView level = findViewById(R.id.level);
        final ImageView image = findViewById(R.id.image);

        currentUser.setProfileImage(image);

        isVerified.setText(currentUser.isVerified ? "VERIFIED" : "NOT VERIFIED\nClick to verify\nAnd get\nrating previlages");
        if (!currentUser.isVerified) {
            isVerified.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), VerificationActivity.class));
                }
            });
        }
        isVerified.setTextColor(Color.WHITE);
        isVerified.setBackgroundColor(currentUser.isVerified ? Color.GREEN : Color.RED);
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
        level.setText("Level " + currentUser.level);

        FloatingActionButton submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get fields
                // Validate (all fields filled, email should not be duplicate)
                // Save user
                if (name.getText().toString().isEmpty()) {
                    Snackbar.make(v, "Please enter your name", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (email.getText().toString().isEmpty()) {
                    Snackbar.make(v, "Please add at least one unit to", Snackbar.LENGTH_LONG).show();
                    return;
                }
                // Save new info to currentUser in data manager
                DataManager.updateUser(
                        email.getText().toString(),
                        name.getText().toString(),
                        Integer.parseInt(age.getText().toString()),
                        Integer.parseInt(maxBudget.getText().toString()),
                        gender.getText().toString(),
                        nativeLanguage.getText().toString(),
                        new UserPreferences(
                                doesSmoke.isChecked(),
                                drugsOkay.isChecked(),
                                hasPets.isChecked(),
                                partiesOkay.isChecked(),
                                canCook.isChecked(),
                                needsPrivateBedroom.isChecked(),
                                hasCar.isChecked()
                        )
                );
                Toast.makeText(EditYourProfileActivity.this, "Profile updated!", Toast.LENGTH_LONG).show();
                // Go back
                finish();
            }

        });
    }
}
