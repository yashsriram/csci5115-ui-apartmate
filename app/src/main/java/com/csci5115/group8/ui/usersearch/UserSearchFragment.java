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

import com.csci5115.group8.R;
import com.csci5115.group8.UserSearchActivity;
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
            Snackbar.make(getView(), "TODO", Snackbar.LENGTH_SHORT).show();
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
                    String gender = data.getStringExtra("gender");
                    int age = data.getIntExtra("age", -1);
                    int maxBudget = data.getIntExtra("maxBudget", -1);
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
                            gender,
                            age,
                            maxBudget,
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