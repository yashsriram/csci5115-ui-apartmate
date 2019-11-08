package com.example.group8project.ui.aptsearch;

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
import com.example.group8project.R;

public class AptSearchFragment extends Fragment {

    private AptSearchViewModel aptSearchViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        aptSearchViewModel =
                ViewModelProviders.of(this).get(AptSearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_apt_search, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        aptSearchViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}