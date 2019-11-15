package com.csci5115.group8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.csci5115.group8.data.DataManager;
import com.google.android.material.snackbar.Snackbar;

import javax.net.ssl.SNIHostName;

public class VerificationActivity extends AppCompatActivity {

    public static final int VERIFICATION_ELIGIBILITY_THRESHOLD = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        String notEligibleMessage =
                "Minimum level to apply for verification is " + VERIFICATION_ELIGIBILITY_THRESHOLD + ". " +
                        "You can increase your level by contributing to ApartMate community by creating and correcting apartment listings";
        String eligibleMessage = "You can now request for verification and get apartment review privileges. " +
                "Once request is made apartment listings created and edited by you will be manually tallied for information correctness";

        final ConstraintLayout layout = findViewById(R.id.activity_verification);
        final TextView level = layout.findViewById(R.id.level);
        final TextView eligibilityMessage = layout.findViewById(R.id.eligibilityMessage);
        final Button verifyMe = layout.findViewById(R.id.verifyMe);

        level.setText(DataManager.currentUser.level + "");
        if (DataManager.currentUser.level < VERIFICATION_ELIGIBILITY_THRESHOLD) {
            eligibilityMessage.setText(notEligibleMessage);
            verifyMe.setVisibility(View.GONE);
        } else {
            eligibilityMessage.setText(eligibleMessage);
            verifyMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setVisibility(View.GONE);
                    DataManager.currentUser.isVerified = true;
                    Toast.makeText(getApplicationContext(), "You verification request is approved!", Toast.LENGTH_LONG).show();
                    finish();
                }
            });
        }
    }
}
