package com.csci5115.group8.ui.usersearch;

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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.csci5115.group8.CreateAccountActivity;
import com.csci5115.group8.R;
import com.csci5115.group8.UserSearchActivity;
import com.csci5115.group8.ViewUserListingActivity;
import com.csci5115.group8.adapters.UserSearchResultsAdapter;
import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.user.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import java.util.List;

public class UserSearchFragment extends Fragment {

    private UserSearchViewModel userSearchViewModel;
    private RecyclerView recyclerView;
    private List<User> userSearchResults = DataManager.searchUsers(DataManager.userSearchState);

    private UserSearchResultsAdapter.ItemClickListener itemClickListener = new UserSearchResultsAdapter.ItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            //add user detail page
            Intent i = new Intent(getContext(), ViewUserListingActivity.class);
            i.putExtra("email", userSearchResults.get(position).email);
            startActivity(i);
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userSearchViewModel =
                ViewModelProviders.of(this).get(UserSearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user_search, container, false);
        final SwipeRefreshLayout swipeRefreshLayout = root.findViewById(R.id.userSearchResultsSwipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                userSearchResults = DataManager.searchUsers(DataManager.userSearchState);
                recyclerView.setAdapter(new UserSearchResultsAdapter(getContext(), userSearchResults, itemClickListener));
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        final FloatingActionButton searchUsers = root.findViewById(R.id.search_users);
        searchUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), UserSearchActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        recyclerView = root.findViewById(R.id.userSearchResults);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new UserSearchResultsAdapter(getContext(), userSearchResults, itemClickListener));

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            switch (resultCode) {
                case AppCompatActivity.RESULT_OK:
                    String searchText = data.getStringExtra("searchText");
                    int gender_male = data.getIntExtra("gender_male", -1);
                    int gender_female = data.getIntExtra("gender_female", -1);
                    int gender_other = data.getIntExtra("gender_other", -1);
                    int age = data.getIntExtra("age", -1);
                    int maxBudget = data.getIntExtra("maxBudget", -1);
                    int age2 = data.getIntExtra("age2", -1);
                    int maxBudget2 = data.getIntExtra("maxBudget2", -1);
                    int doesSmoke = data.getIntExtra("doesSmoke", -1);
                    int drugsOkay = data.getIntExtra("drugsOkay", -1);
                    int hasPets = data.getIntExtra("hasPets", -1);
                    int partiesOkay = data.getIntExtra("partiesOkay", -1);
                    int canCook = data.getIntExtra("canCook", -1);
                    int needsPrivateBedroom = data.getIntExtra("needsPrivateBedroom", -1);
                    int hasCar = data.getIntExtra("hasCar", -1);
                    String nativeLanguage = data.getStringExtra("nativeLanguage");

                    DataManager.userSearchState.set(
                            searchText,
                            gender_male,
                            gender_female,
                            gender_other,
                            age,
                            age2,
                            maxBudget,
                            maxBudget2,
                            doesSmoke,
                            drugsOkay,
                            hasPets,
                            partiesOkay,
                            canCook,
                            needsPrivateBedroom,
                            hasCar,
                            nativeLanguage
                    );

                    userSearchResults = DataManager.searchUsers(DataManager.userSearchState);
                    recyclerView.setAdapter(new UserSearchResultsAdapter(getContext(), userSearchResults, itemClickListener));

                    break;
                case AppCompatActivity.RESULT_CANCELED:
                    break;
                default:
                    break;
            }
        }
    }
}