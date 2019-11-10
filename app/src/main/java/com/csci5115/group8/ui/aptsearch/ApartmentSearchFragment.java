package com.csci5115.group8.ui.aptsearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.csci5115.group8.ApartmentSearchActivity;
import com.csci5115.group8.R;
import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.apartment.Apartment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import it.beppi.tristatetogglebutton_library.TriStateToggleButton;

public class ApartmentSearchFragment extends Fragment {

    private ApartmentSearchViewModel apartmentSearchViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        apartmentSearchViewModel = ViewModelProviders.of(this).get(ApartmentSearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_apartment_search, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        apartmentSearchViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        final FloatingActionButton searchApartments = root.findViewById(R.id.search_apartments);
        searchApartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ApartmentSearchActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            switch (resultCode) {
                case AppCompatActivity.RESULT_OK:
                    String searchText = data.getStringExtra("searchText");
                    int refrigerator = data.getIntExtra("refrigerator", -1);
                    int oven = data.getIntExtra("oven", -1);
                    int microwave = data.getIntExtra("microwave", -1);
                    int dishwasher = data.getIntExtra("dishwasher", -1);
                    int washingMachine = data.getIntExtra("washingMachine", -1);
                    int heating = data.getIntExtra("heating", -1);
                    int cooling = data.getIntExtra("cooling", -1);

                    int laundryRoom = data.getIntExtra("laundryRoom", -1);
                    int longue = data.getIntExtra("longue", -1);
                    int printingService = data.getIntExtra("printingService", -1);
                    int reception = data.getIntExtra("reception", -1);
                    int parking = data.getIntExtra("parking", -1);

                    int securityCameras = data.getIntExtra("securityCameras", -1);
                    int smokeDetectors = data.getIntExtra("smokeDetectors", -1);
                    int sprinklers = data.getIntExtra("sprinklers", -1);
                    int buildingLock = data.getIntExtra("buildingLock", -1);

                    List<Apartment> searchResults = search(
                            searchText,
                            // Per unit amenities
                            refrigerator,
                            oven,
                            microwave,
                            dishwasher,
                            washingMachine,
                            heating,
                            cooling,
                            // Common amenities
                            laundryRoom,
                            longue,
                            printingService,
                            reception,
                            parking,
                            // Security features
                            securityCameras,
                            smokeDetectors,
                            sprinklers,
                            buildingLock
                    );

                    break;
                case AppCompatActivity.RESULT_CANCELED:
                    break;
                default:
                    break;
            }
        }
    }

    private List<Apartment> search(String searchText,
                                   // Per unit amenities
                                   int refrigerator,
                                   int oven,
                                   int microwave,
                                   int dishwasher,
                                   int washingMachine,
                                   int heating,
                                   int cooling,
                                   // Common amenities
                                   int laundryRoom,
                                   int longue,
                                   int printingService,
                                   int reception,
                                   int parking,
                                   // Security features
                                   int securityCameras,
                                   int smokeDetectors,
                                   int sprinklers,
                                   int buildingLock) {
        List<Apartment> results = new ArrayList<>();
        for (Apartment apt : DataManager.getInstance().apartments) {
            if (!(Pattern.matches(searchText, apt.name) || Pattern.matches(searchText, apt.address))) {
                continue;
            }
            // If search matches name or address and all filters match then only add apt to search results
            if ((Pattern.matches(searchText, apt.name) || Pattern.matches(searchText, apt.address)
                    && filterMatch(refrigerator, apt.perUnitAmenities.refrigerator)
                    && filterMatch(oven, apt.perUnitAmenities.oven
                    && filterMatch(microwave, apt.perUnitAmenities.microwave
                    && filterMatch(dishwasher, apt.perUnitAmenities.dishwasher
                    && filterMatch(washingMachine, apt.perUnitAmenities.washingMachine
                    && filterMatch(heating, apt.perUnitAmenities.heating
                    && filterMatch(cooling, apt.perUnitAmenities.cooling
                    && filterMatch(laundryRoom, apt.commonAmenities.laundryRoom
                    && filterMatch(longue, apt.commonAmenities.longue
                    && filterMatch(printingService, apt.commonAmenities.printingService
                    && filterMatch(reception, apt.commonAmenities.reception
                    && filterMatch(parking, apt.commonAmenities.parking
                    && filterMatch(securityCameras, apt.securityFeatures.securityCameras
                    && filterMatch(smokeDetectors, apt.securityFeatures.smokeDetectors
                    && filterMatch(sprinklers, apt.securityFeatures.sprinklers
                    && filterMatch(buildingLock, apt.securityFeatures.buildingLock) {
                results.add(apt);
            }
        }
        return results;
    }

    private boolean filterMatch(int filter, boolean field) {
        if (filter == 0) {
            return true;
        } else if (filter == 1) {
            return !field;
        } else {
            return field;
        }
    }

}