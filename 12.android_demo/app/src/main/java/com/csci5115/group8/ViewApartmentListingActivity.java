package com.csci5115.group8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.csci5115.group8.adapters.ApartmentUnitAdapter;
import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.apartment.Apartment;
import com.csci5115.group8.data.apartment.ApartmentUnit;
import com.csci5115.group8.data.user.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewApartmentListingActivity extends AppCompatActivity {
    int apartmentId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_apartment_listing);

        apartmentId = getIntent().getIntExtra("apartmentId", -1);

        final ConstraintLayout layout = findViewById(R.id.activity_view_apartment_listing);
        FloatingActionButton submit = layout.findViewById(R.id.submit_edit_apartment_listing);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), EditApartmentListingActivity.class);
                i.putExtra("apartmentId", apartmentId);
                startActivity(i);
            }
        });

        final RatingBar ratingBar = layout.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                boolean done = DataManager.reviewManager.setReview(apartmentId, DataManager.currentUser.email, (int) rating);
                if (!done) {
                    Snackbar.make(ratingBar, "Rating could not be saved. Data might be outdated", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    private void refresh() {
        Apartment currentApartment = DataManager.getApartment(apartmentId);
        final User currentUser = DataManager.currentUser;
        if (apartmentId == -1 || currentApartment == null) {
            Toast.makeText(this, "It seems that the information of this apartment is removed from our system", Toast.LENGTH_LONG).show();
            finish();
        }

        final ConstraintLayout layout = findViewById(R.id.activity_view_apartment_listing);

        final WebView videoTour = layout.findViewById(R.id.videoTour);
        WebSettings webSettings = videoTour.getSettings();
        webSettings.setJavaScriptEnabled(true);
        videoTour.loadData(currentApartment.videoTourUrl, "text/html", "utf-8");

        final RecyclerView recyclerView = layout.findViewById(R.id.unitsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<ApartmentUnit> apartmentUnits = currentApartment.units;
        final RecyclerView.Adapter adapter = new ApartmentUnitAdapter(this, apartmentUnits, null);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        final RatingBar ratingBar = findViewById(R.id.ratingBar);
        final TextView ratingBarHint = findViewById(R.id.ratingBarHint);
        final TextView name = layout.findViewById(R.id.name);
        final TextView address = layout.findViewById(R.id.address);
        final CheckBox refrigerator = layout.findViewById(R.id.refrigerator);
        final CheckBox oven = layout.findViewById(R.id.oven);
        final CheckBox microwave = layout.findViewById(R.id.microwave);
        final CheckBox dishwasher = layout.findViewById(R.id.dishwasher);
        final CheckBox washingMachine = layout.findViewById(R.id.washingMachine);
        final CheckBox heating = layout.findViewById(R.id.heating);
        final CheckBox cooling = layout.findViewById(R.id.cooling);

        final CheckBox laundryRoom = layout.findViewById(R.id.laundryRoom);
        final CheckBox longue = layout.findViewById(R.id.longue);
        final CheckBox printingService = layout.findViewById(R.id.printingService);
        final CheckBox reception = layout.findViewById(R.id.reception);
        final CheckBox parking = layout.findViewById(R.id.parking);

        final CheckBox securityCameras = layout.findViewById(R.id.securityCameras);
        final CheckBox smokeDetectors = layout.findViewById(R.id.smokeDetectors);
        final CheckBox sprinklers = layout.findViewById(R.id.sprinklers);
        final CheckBox buildingLock = layout.findViewById(R.id.buildingLock);

        ratingBar.setVisibility(DataManager.currentUser.isVerified ? View.VISIBLE : View.GONE);
        ratingBarHint.setVisibility(DataManager.currentUser.isVerified ? View.VISIBLE : View.GONE);
        ratingBar.setRating(DataManager.reviewManager.getReview(apartmentId, currentUser.email));
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser) {
                    DataManager.reviewManager.setReview(apartmentId, currentUser.email, (int) rating);
                    refreshRatingBlock();
                    Snackbar.make(ratingBar, "Rating saved", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        name.setText(currentApartment.name);
        address.setText(currentApartment.address);

        refrigerator.setChecked(currentApartment.perUnitAmenities.refrigerator);
        refrigerator.setEnabled(false);
        oven.setChecked(currentApartment.perUnitAmenities.oven);
        microwave.setChecked(currentApartment.perUnitAmenities.microwave);
        microwave.setEnabled(false);
        oven.setEnabled(false);
        dishwasher.setChecked(currentApartment.perUnitAmenities.dishwasher);
        dishwasher.setEnabled(false);
        washingMachine.setChecked(currentApartment.perUnitAmenities.washingMachine);
        washingMachine.setEnabled(false);
        heating.setChecked(currentApartment.perUnitAmenities.heating);
        heating.setEnabled(false);
        cooling.setChecked(currentApartment.perUnitAmenities.cooling);
        cooling.setEnabled(false);

        laundryRoom.setChecked(currentApartment.commonAmenities.laundryRoom);
        laundryRoom.setEnabled(false);
        longue.setChecked(currentApartment.commonAmenities.longue);
        longue.setEnabled(false);
        printingService.setChecked(currentApartment.commonAmenities.printingService);
        printingService.setEnabled(false);
        reception.setChecked(currentApartment.commonAmenities.reception);
        reception.setEnabled(false);
        parking.setChecked(currentApartment.commonAmenities.parking);
        parking.setEnabled(false);

        securityCameras.setChecked(currentApartment.securityFeatures.securityCameras);
        securityCameras.setEnabled(false);
        smokeDetectors.setChecked(currentApartment.securityFeatures.smokeDetectors);
        smokeDetectors.setEnabled(false);
        sprinklers.setChecked(currentApartment.securityFeatures.sprinklers);
        sprinklers.setEnabled(false);
        buildingLock.setChecked(currentApartment.securityFeatures.buildingLock);
        buildingLock.setEnabled(false);

        refreshRatingBlock();
    }

    private void refreshRatingBlock() {
        Map<Integer, Integer> starCountHistogram = DataManager.reviewManager.getStarCountHistogram(apartmentId);

        final ConstraintLayout layout = findViewById(R.id.activity_view_apartment_listing);

        List<ProgressBar> ratingPercentages = new ArrayList<>();
        ratingPercentages.add((ProgressBar) layout.findViewById(R.id.rating1Percentage));
        ratingPercentages.add((ProgressBar) layout.findViewById(R.id.rating2Percentage));
        ratingPercentages.add((ProgressBar) layout.findViewById(R.id.rating3Percentage));
        ratingPercentages.add((ProgressBar) layout.findViewById(R.id.rating4Percentage));
        ratingPercentages.add((ProgressBar) layout.findViewById(R.id.rating5Percentage));

        List<TextView> ratingCounts = new ArrayList<>();
        ratingCounts.add((TextView) layout.findViewById(R.id.rating1Count));
        ratingCounts.add((TextView) layout.findViewById(R.id.rating2Count));
        ratingCounts.add((TextView) layout.findViewById(R.id.rating3Count));
        ratingCounts.add((TextView) layout.findViewById(R.id.rating4Count));
        ratingCounts.add((TextView) layout.findViewById(R.id.rating5Count));

        int total = 0;
        float weightedRating = 0;
        for (int i = 0; i < 5; i++) {
            total += starCountHistogram.get(i + 1);
            weightedRating += (i + 1) * starCountHistogram.get(i + 1);
            ratingPercentages.get(i).setProgress(total == 0 ? 0 : (int) ((float) starCountHistogram.get(i + 1) / total * 100));
            ratingCounts.get(i).setText(starCountHistogram.get(i + 1) + " people");
        }

        final TextView averageRating = layout.findViewById(R.id.averageRating);
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        averageRating.setText(total == 0 ? "No reviews yet" : df.format((weightedRating / total)) + " Stars / " + total + " People");
    }

}
