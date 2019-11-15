package com.csci5115.group8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.user.User;

import com.csci5115.group8.ui.usersearch.UserSearchFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Map;

import it.beppi.tristatetogglebutton_library.TriStateToggleButton;

import static it.beppi.tristatetogglebutton_library.TriStateToggleButton.toggleStatusToInt;

public class UserSearchActivity extends AppCompatActivity {

    EditText searchText;
    TextView numMatches;
    EditText gender;
    EditText age;
    EditText maxBudget;
    TriStateToggleButton  doesSmoke;
    TriStateToggleButton drugsOkay;
    TriStateToggleButton hasPets;
    TriStateToggleButton partiesOkay;
    TriStateToggleButton canCook;
    TriStateToggleButton needsPrivateBedroom;
    EditText nativeLanguage;
    TriStateToggleButton hasCar;

    final TriStateToggleButton.OnToggleChanged updateNumberOfMatches = new TriStateToggleButton.OnToggleChanged() {
        @Override
        public void onToggle(TriStateToggleButton.ToggleStatus toggleStatus, boolean b, int i) {
            numMatches.setText(getNumSearchResults() + " Matches");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);

        final ConstraintLayout layout = findViewById(R.id.activity_user_search);
        searchText = layout.findViewById(R.id.searchText2);
        numMatches = layout.findViewById(R.id.numMatches2);

        gender = layout.findViewById(R.id.gender2);
        age = layout.findViewById(R.id.age2);
        maxBudget = layout.findViewById(R.id.maxBudget);
        doesSmoke = layout.findViewById(R.id.doesSmoke);
        doesSmoke.setOnToggleChanged(updateNumberOfMatches);
        drugsOkay = layout.findViewById(R.id.drugsOkay);
        drugsOkay.setOnToggleChanged(updateNumberOfMatches);
        hasPets = layout.findViewById(R.id.hasPets);
        hasPets.setOnToggleChanged(updateNumberOfMatches);
        partiesOkay = layout.findViewById(R.id.partiesOkay);
        partiesOkay.setOnToggleChanged(updateNumberOfMatches);
        canCook = layout.findViewById(R.id.canCook);
        canCook.setOnToggleChanged(updateNumberOfMatches);
        needsPrivateBedroom = layout.findViewById(R.id.needsPrivateBedroom);
        needsPrivateBedroom.setOnToggleChanged(updateNumberOfMatches);
        nativeLanguage = layout.findViewById(R.id.nativeLanguage);
        hasCar = layout.findViewById(R.id.hasCar);
        hasCar.setOnToggleChanged(updateNumberOfMatches);

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                numMatches.setText(getNumSearchResults() + " Matches");
            }
        });

        gender.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                numMatches.setText(getNumSearchResults() + " Matches");
            }
        });

        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                numMatches.setText(getNumSearchResults() + " Matches");
            }
        });

        maxBudget.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                numMatches.setText(getNumSearchResults() + " Matches");
            }
        });

        nativeLanguage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                numMatches.setText(getNumSearchResults() + " Matches");
            }
        });

        FloatingActionButton submit = layout.findViewById(R.id.submit_user_search);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Replace with your own action", Toast.LENGTH_LONG).show();
                // Collect data, serialize and put in intent

                Intent returnIntent = new Intent();
                returnIntent.putExtra("searchText", searchText.getText().toString());
                setResult(AppCompatActivity.RESULT_OK, returnIntent);


                returnIntent.putExtra("gender", gender.getText().toString());
                returnIntent.putExtra("age", age.getText().toString());
                returnIntent.putExtra("maxBudget", maxBudget.getText().toString());
                returnIntent.putExtra("nativeLanguage", nativeLanguage.getText().toString());
                returnIntent.putExtra("doesSmoke", toggleStatusToInt(doesSmoke.getToggleStatus()));
                returnIntent.putExtra("drugsOkay", toggleStatusToInt(drugsOkay.getToggleStatus()));
                returnIntent.putExtra("hasPets", toggleStatusToInt(hasPets.getToggleStatus()));
                returnIntent.putExtra("partiesOkay", toggleStatusToInt(partiesOkay.getToggleStatus()));
                returnIntent.putExtra("canCook", toggleStatusToInt(canCook.getToggleStatus()));
                returnIntent.putExtra("needsPrivateBedroom", toggleStatusToInt(needsPrivateBedroom.getToggleStatus()));
                returnIntent.putExtra("hasCar", toggleStatusToInt(hasCar.getToggleStatus()));


                finish();
            }
        });
        numMatches.setText(DataManager.getInstance().users.size() + " Matches");
    }

    private int toggleStatusToInt(TriStateToggleButton.ToggleStatus toggleStatus) {
        switch (toggleStatus) {
            case on:
                return 2;
            case mid:
                return 1;
            case off:
                return 0;
        }
        return -1;
    }

    private int getNumSearchResults() {
        String searchString = searchText.getText().toString();

        String ages=age.getText().toString();
        int agei;
        if(ages.length()<1)agei=-1;
        else agei=Integer.parseInt(ages);

        String maxBudgets=maxBudget.getText().toString();
        int maxBudgeti;
        if(maxBudgets.length()<1)maxBudgeti=-1;
        else maxBudgeti=Integer.parseInt(maxBudgets);

        Map<String,User> searchResults = UserSearchFragment.searchUsers(
                searchString,
                gender.getText().toString(),
                agei,
                maxBudgeti,
                toggleStatusToInt(doesSmoke.getToggleStatus()),
                toggleStatusToInt(drugsOkay.getToggleStatus()),
                toggleStatusToInt(hasPets.getToggleStatus()),
                toggleStatusToInt(partiesOkay.getToggleStatus()),
                toggleStatusToInt(canCook.getToggleStatus()),
                toggleStatusToInt(needsPrivateBedroom.getToggleStatus()),
                toggleStatusToInt(hasCar.getToggleStatus()),
                        nativeLanguage.getText().toString()
        );
        return searchResults.size();
    }


}
