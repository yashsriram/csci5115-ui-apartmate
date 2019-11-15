package com.csci5115.group8.ui.usersearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.csci5115.group8.EditYourProfileActivity;
import com.csci5115.group8.R;
import com.csci5115.group8.UserSRLCustomizationActivity;
import com.csci5115.group8.UserSearchActivity;
import com.csci5115.group8.UserSearchResultsAdapter;

import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.user.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class UserSearchFragment extends Fragment {

    private UserSearchViewModel userSearchViewModel;
    private RecyclerView recyclerView;
    private Map<String,User> userSearchResults = DataManager.getInstance().users;

    private UserSearchResultsAdapter.ItemClickListener itemClickListener = new UserSearchResultsAdapter.ItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Intent i = new Intent(getContext(), UserSRLCustomizationActivity.class);
            i.putExtra("userName", userSearchResults.get(position).name);
            startActivity(i);
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        userSearchViewModel =
                ViewModelProviders.of(this).get(UserSearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user_search, container, false);
        final FloatingActionButton searchUsers = root.findViewById(R.id.search_users);
        searchUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), UserSearchActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = root.findViewById(R.id.user_search_results);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new UserSearchResultsAdapter(getContext(), userSearchResults, itemClickListener));
        return root;
    }

    //////////
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            switch (resultCode) {
                case AppCompatActivity.RESULT_OK:
                    String searchText = data.getStringExtra("searchText");
                    int age = data.getIntExtra("age", -1);


                    userSearchResults = searchUsers(
                            searchText,
                            // Per unit amenities
                            age
                    );
                    recyclerView.setAdapter(new UserSearchResultsAdapter(getContext(), userSearchResults, null));

                    break;
                case AppCompatActivity.RESULT_CANCELED:
                    break;
                default:
                    break;
            }
        }
    }

    public static Map<String,User> searchUsers(String searchText,
                                                  int age) {
        String regexString = ".*" + searchText + ".*";
        Pattern pattern = Pattern.compile(regexString, Pattern.CASE_INSENSITIVE);
        Map<String,User> results = new HashMap<>();
        Map<String,User> mapa=DataManager.getInstance().users;
        for (Map.Entry<String, User> entry : mapa.entrySet()) {
            // If search matches name or address and all filters match then only add apt to search results
            if ((pattern.matcher(entry.getValue().name).matches() )
                    && filterMatch(age, entry.getValue().canCook)
                   ) {
                results.put(entry.getValue().name,entry.getValue());
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