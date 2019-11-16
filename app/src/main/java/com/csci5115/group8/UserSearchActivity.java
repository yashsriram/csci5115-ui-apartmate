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
import com.csci5115.group8.ui.usersearch.UserSearchState;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import it.beppi.tristatetogglebutton_library.TriStateToggleButton;

import static com.csci5115.group8.data.DataManager.currentUser;
import static com.csci5115.group8.data.DataManager.first_initalized;
import static com.csci5115.group8.data.DataManager.userSearchState;

public class UserSearchActivity extends AppCompatActivity {

    EditText searchText;
    TextView numMatches;
    CheckBox gender_male;
    CheckBox gender_female;
    CheckBox gender_other;
    EditText age;
    EditText age2;
    EditText maxBudget;
    EditText maxBudget2;
    TriStateToggleButton doesSmoke;
    TriStateToggleButton drugsOkay;
    TriStateToggleButton hasPets;
    TriStateToggleButton partiesOkay;
    TriStateToggleButton canCook;
    TriStateToggleButton needsPrivateBedroom;
    EditText nativeLanguage;
    TriStateToggleButton hasCar;

    final TriStateToggleButton.OnToggleChanged updateNumberOfMatchesCB1 = new TriStateToggleButton.OnToggleChanged() {
        @Override
        public void onToggle(TriStateToggleButton.ToggleStatus toggleStatus, boolean b, int i) {
            numMatches.setText(getNumSearchResults() + " Matches");
        }
    };

    final TextWatcher updateNumberOfMatchesCB2 = new TextWatcher() {
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
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);

        //recommended search option
        /*if(first_initalized) {
            DataManager.userSearchState.set(
                    "", 1, 1, 1, currentUser.age - 5, currentUser.age + 5, currentUser.maxBudget - 200, currentUser.maxBudget + 200,
                    currentUser.preferences.doesSmoke ? 2 : 1, currentUser.preferences.drugsOkay ? 2 : 1,
                    currentUser.preferences.hasPets ? 2 : 1, currentUser.preferences.partiesOkay ? 2 : 1,
                    currentUser.preferences.canCook ? 2 : 1, currentUser.preferences.needsPrivateBedroom ? 2 : 1,
                    currentUser.preferences.hasCar ? 2 : 1, currentUser.nativeLanguage
            );
            first_initalized=true;
        }*/


        final ConstraintLayout layout = findViewById(R.id.activity_user_search);
        numMatches = layout.findViewById(R.id.numMatches2);

        searchText = layout.findViewById(R.id.searchText2);
        gender_male= layout.findViewById(R.id.male);
        gender_female = layout.findViewById(R.id.female);
        gender_other = layout.findViewById(R.id.otherSex);
        age = layout.findViewById(R.id.age);
        age2 = layout.findViewById(R.id.age2);
        maxBudget = layout.findViewById(R.id.maxBudget);
        maxBudget2 = layout.findViewById(R.id.maxBudget2);
        doesSmoke = layout.findViewById(R.id.doesSmoke);
        drugsOkay = layout.findViewById(R.id.drugsOkay);
        hasPets = layout.findViewById(R.id.hasPets);
        partiesOkay = layout.findViewById(R.id.partiesOkay);
        canCook = layout.findViewById(R.id.canCook);
        needsPrivateBedroom = layout.findViewById(R.id.needsPrivateBedroom);
        hasCar = layout.findViewById(R.id.hasCar);
        nativeLanguage = layout.findViewById(R.id.nativeLanguage);

        searchText.addTextChangedListener(updateNumberOfMatchesCB2);
        gender_other.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View view) {numMatches.setText(getNumSearchResults() + " Matches");}});
        gender_male.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View view) {numMatches.setText(getNumSearchResults() + " Matches");}});
        gender_female.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View view) {numMatches.setText(getNumSearchResults() + " Matches");}});
        age.addTextChangedListener(updateNumberOfMatchesCB2);
        age2.addTextChangedListener(updateNumberOfMatchesCB2);
        maxBudget.addTextChangedListener(updateNumberOfMatchesCB2);
        maxBudget2.addTextChangedListener(updateNumberOfMatchesCB2);
        doesSmoke.setOnToggleChanged(updateNumberOfMatchesCB1);
        drugsOkay.setOnToggleChanged(updateNumberOfMatchesCB1);
        hasPets.setOnToggleChanged(updateNumberOfMatchesCB1);
        partiesOkay.setOnToggleChanged(updateNumberOfMatchesCB1);
        canCook.setOnToggleChanged(updateNumberOfMatchesCB1);
        needsPrivateBedroom.setOnToggleChanged(updateNumberOfMatchesCB1);
        hasCar.setOnToggleChanged(updateNumberOfMatchesCB1);
        nativeLanguage.addTextChangedListener(updateNumberOfMatchesCB2);

        searchText.setText(userSearchState.searchText);
        nativeLanguage.setText(userSearchState.nativeLanguage);
        if(userSearchState.gender_male==1){
            gender_male.setChecked(true);
        }else if(userSearchState.gender_male==0){
            gender_male.setChecked(false);
        }
        if(userSearchState.gender_female==1){
            gender_female.setChecked(true);
        }else if(userSearchState.gender_female==0){
            gender_female.setChecked(false);
        }
        if(userSearchState.gender_other==1){
            gender_other.setChecked(true);
        }else if(userSearchState.gender_other==0){
            gender_other.setChecked(false);
        }
        if(userSearchState.age!=-1){
            age.setText(userSearchState.age);
        }
        if(userSearchState.age2!=-1){
            age2.setText(userSearchState.age2);
        }
        if(userSearchState.maxBudget!=-1){
            maxBudget.setText(userSearchState.maxBudget);
        }
        if(userSearchState.maxBudget2!=-1){
            maxBudget2.setText(userSearchState.maxBudget2);
        }
        doesSmoke.setToggleStatus(IntToToggleStatus(userSearchState.doesSmoke));
        drugsOkay.setToggleStatus(IntToToggleStatus(userSearchState.drugsOkay));
        hasPets.setToggleStatus(IntToToggleStatus(userSearchState.hasPets));
        partiesOkay.setToggleStatus(IntToToggleStatus(userSearchState.partiesOkay));
        canCook.setToggleStatus(IntToToggleStatus(userSearchState.canCook));
        needsPrivateBedroom.setToggleStatus(IntToToggleStatus(userSearchState.needsPrivateBedroom));
        hasCar.setToggleStatus(IntToToggleStatus(userSearchState.hasCar));





        FloatingActionButton submit = layout.findViewById(R.id.submit_user_search);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Collect data, serialize and put in intent
                Intent returnIntent = new Intent();
                returnIntent.putExtra("searchText", searchText.getText().toString());
                setResult(AppCompatActivity.RESULT_OK, returnIntent);


                returnIntent.putExtra("gender_male",gender_male.isChecked()?1:0 );
                returnIntent.putExtra("gender_female",gender_female.isChecked()?1:0  );
                returnIntent.putExtra("gender_other",gender_other.isChecked()?1:0  );
                returnIntent.putExtra("age", toInt(age.getText().toString()));
                returnIntent.putExtra("maxBudget", toInt(maxBudget.getText().toString()));
                returnIntent.putExtra("age2", toInt(age2.getText().toString()));
                returnIntent.putExtra("maxBudget2", toInt(maxBudget2.getText().toString()));
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
        numMatches.setText(getNumSearchResults() + " Matches");
    }

    private int toInt(String s){
        if(s.length()>0)
        return Integer.parseInt(s);
        else return -1;
    }

    private TriStateToggleButton.ToggleStatus IntToToggleStatus(int i) {
        switch (i) {
            case 2:
                return TriStateToggleButton.ToggleStatus.on;
            case 1:
                return TriStateToggleButton.ToggleStatus.mid;
            case 0:
                return TriStateToggleButton.ToggleStatus.off;
        }
        return TriStateToggleButton.ToggleStatus.off;
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

        String ages = age.getText().toString();
        int agei = ages.length() < 1 ? -1 : Integer.parseInt(ages);

        String maxBudgets = maxBudget.getText().toString();
        int maxBudgeti = maxBudgets.length() < 1 ? -1 : Integer.parseInt(maxBudgets);

        String ages2 = age2.getText().toString();
        int agei2 = ages2.length() < 1 ? -1 : Integer.parseInt(ages2);

        String maxBudgets2 = maxBudget2.getText().toString();
        int maxBudgeti2 = maxBudgets2.length() < 1 ? -1 : Integer.parseInt(maxBudgets2);

        List<User> searchResults = DataManager.searchUsers(
                new UserSearchState(searchString,
                        gender_male.isChecked()?1:0,
                        gender_female.isChecked()?1:0,
                        gender_other.isChecked()?1:0,
                        agei,
                        agei2,
                        maxBudgeti,
                        maxBudgeti2,
                        toggleStatusToInt(doesSmoke.getToggleStatus()),
                        toggleStatusToInt(drugsOkay.getToggleStatus()),
                        toggleStatusToInt(hasPets.getToggleStatus()),
                        toggleStatusToInt(partiesOkay.getToggleStatus()),
                        toggleStatusToInt(canCook.getToggleStatus()),
                        toggleStatusToInt(needsPrivateBedroom.getToggleStatus()),
                        toggleStatusToInt(hasCar.getToggleStatus()),
                        nativeLanguage.getText().toString()
                )
        );
        return searchResults.size();
    }


}
