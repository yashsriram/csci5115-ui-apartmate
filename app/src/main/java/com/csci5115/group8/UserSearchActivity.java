package com.csci5115.group8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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
    CheckBox male;
    CheckBox female;
    CheckBox other;
    EditText age;
    TriStateToggleButton maxBudget;
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

    private int getNumSearchResults() {
        String searchString = searchText.getText().toString();
        Map<String,User> searchResults = UserSearchFragment.searchUsers(
                searchString,
                toggleStatusToInt(canCook.getToggleStatus())
        );
        return searchResults.size();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);

        final ConstraintLayout layout = findViewById(R.id.activity_user_search);
        FloatingActionButton submit = layout.findViewById(R.id.submit_user_search);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Replace with your own action", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
