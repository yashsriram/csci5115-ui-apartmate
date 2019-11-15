package com.csci5115.group8.ui.aptsearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.csci5115.group8.ApartmentSearchActivity;
import com.csci5115.group8.adapters.ApartmentSearchResultsAdapter;
import com.csci5115.group8.R;
import com.csci5115.group8.ViewApartmentListingActivity;
import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.apartment.Apartment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ApartmentSearchFragment extends Fragment {

    private ApartmentSearchViewModel apartmentSearchViewModel;
    private ApartmentSearchState apartmentSearchState = new ApartmentSearchState();
    private RecyclerView recyclerView;
    private List<Apartment> apartmentSearchResults = DataManager.apartments;
    private ApartmentSearchResultsAdapter.ItemClickListener itemClickListener = new ApartmentSearchResultsAdapter.ItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Intent i = new Intent(getContext(), ViewApartmentListingActivity.class);
            i.putExtra("apartmentId", apartmentSearchResults.get(position).id);
            startActivity(i);
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        apartmentSearchViewModel = ViewModelProviders.of(this).get(ApartmentSearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_apartment_search, container, false);

        final FloatingActionButton searchApartments = root.findViewById(R.id.search_apartments);
        searchApartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ApartmentSearchActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        recyclerView = root.findViewById(R.id.apartment_search_results);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ApartmentSearchResultsAdapter(getContext(), apartmentSearchResults, itemClickListener));

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

                    apartmentSearchState.set(
                            searchText,
                            refrigerator,
                            oven,
                            microwave,
                            dishwasher,
                            washingMachine,
                            heating,
                            cooling,
                            laundryRoom,
                            longue,
                            printingService,
                            reception,
                            parking,
                            securityCameras,
                            smokeDetectors,
                            sprinklers,
                            buildingLock
                    );

                    apartmentSearchResults = searchApartments(apartmentSearchState);
                    recyclerView.setAdapter(new ApartmentSearchResultsAdapter(getContext(), apartmentSearchResults, null));

                    break;
                case AppCompatActivity.RESULT_CANCELED:
                    break;
                default:
                    break;
            }
        }
    }

    public static List<Apartment> searchApartments(ApartmentSearchState state) {
        String regexString = ".*" + state.searchText + ".*";
        Pattern pattern = Pattern.compile(regexString, Pattern.CASE_INSENSITIVE);
        List<Apartment> results = new ArrayList<>();
        for (Apartment apt : DataManager.apartments) {
            // If search matches name or address and all filters match then only add apt to search results
            if ((pattern.matcher(apt.name).matches() || pattern.matcher(apt.address).matches())
                    && filterMatch(state.refrigerator, apt.perUnitAmenities.refrigerator)
                    && filterMatch(state.oven, apt.perUnitAmenities.oven)
                    && filterMatch(state.microwave, apt.perUnitAmenities.microwave)
                    && filterMatch(state.dishwasher, apt.perUnitAmenities.dishwasher)
                    && filterMatch(state.washingMachine, apt.perUnitAmenities.washingMachine)
                    && filterMatch(state.heating, apt.perUnitAmenities.heating)
                    && filterMatch(state.cooling, apt.perUnitAmenities.cooling)
                    && filterMatch(state.laundryRoom, apt.commonAmenities.laundryRoom)
                    && filterMatch(state.longue, apt.commonAmenities.longue)
                    && filterMatch(state.printingService, apt.commonAmenities.printingService)
                    && filterMatch(state.reception, apt.commonAmenities.reception)
                    && filterMatch(state.parking, apt.commonAmenities.parking)
                    && filterMatch(state.securityCameras, apt.securityFeatures.securityCameras)
                    && filterMatch(state.smokeDetectors, apt.securityFeatures.smokeDetectors)
                    && filterMatch(state.sprinklers, apt.securityFeatures.sprinklers)
                    && filterMatch(state.buildingLock, apt.securityFeatures.buildingLock)) {
                results.add(apt);
            }
        }
        return results;
    }

    private static boolean filterMatch(int filter, boolean field) {
        if (filter == 0) {
            return true;
        } else if (filter == 1) {
            return !field;
        } else {
            return field;
        }
    }

}