package com.csci5115.group8;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.csci5115.group8.data.DataManager;

import com.csci5115.group8.data.user.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewUserListingActivity extends AppCompatActivity {
    String email_ = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_listing);

        email_ = getIntent().getStringExtra("email");

        final ConstraintLayout layout = findViewById(R.id.activity_view_user_listing);

    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    private void refresh() {
        User currentUser = DataManager.getUser(email_);
        if (currentUser == null) {
            Toast.makeText(this, "It seems that the information of this user is removed from our system", Toast.LENGTH_LONG).show();
            finish();
        }

        final ConstraintLayout layout = findViewById(R.id.activity_view_user_listing);

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


        isVerified.setText(currentUser.isVerified ? "VERIFIED" : "NOT VERIFIED");
        isVerified.setTextColor(Color.WHITE);
        isVerified.setBackgroundColor(currentUser.isVerified ? Color.GREEN : Color.RED);
        name.setText(currentUser.name);
        name.setKeyListener(null);
        email.setText(currentUser.email);
        email.setKeyListener(null);
        age.setText(String.format("%s", currentUser.age));
        age.setKeyListener(null);
        maxBudget.setText(String.format("%s", currentUser.maxBudget));
        maxBudget.setKeyListener(null);
        gender.setText(currentUser.gender);
        gender.setKeyListener(null);
        nativeLanguage.setText(currentUser.nativeLanguage);
        nativeLanguage.setKeyListener(null);
        doesSmoke.setChecked(currentUser.preferences.doesSmoke);
        drugsOkay.setChecked(currentUser.preferences.drugsOkay);
        hasPets.setChecked(currentUser.preferences.hasPets);
        partiesOkay.setChecked(currentUser.preferences.partiesOkay);
        canCook.setChecked(currentUser.preferences.canCook);
        needsPrivateBedroom.setChecked(currentUser.preferences.needsPrivateBedroom);
        hasCar.setChecked(currentUser.preferences.hasCar);
        level.setText("Level " + currentUser.level);


        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton send_message = layout.findViewById(R.id.send_message);
        send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send message
                //target user email is "email_"
                Intent threadIntent = new Intent(ViewUserListingActivity.this, ThreadActivity.class);
                threadIntent.putExtra("email", email_);
                startActivity(threadIntent);
            }
        });

    }

}
