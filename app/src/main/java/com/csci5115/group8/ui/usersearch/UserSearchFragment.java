package com.csci5115.group8.ui.usersearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.csci5115.group8.EditYourProfile;
import com.csci5115.group8.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class UserSearchFragment extends Fragment {

    private UserSearchViewModel userSearchViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        userSearchViewModel =
                ViewModelProviders.of(this).get(UserSearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user_search, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        userSearchViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        final FloatingActionButton editYourProfile = root.findViewById(R.id.edit_your_profile);
        editYourProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditYourProfile.class);
                startActivity(intent);
            }
        });
        final FloatingActionButton searchUsers = root.findViewById(R.id.search_users);
        searchUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        return root;
    }
}