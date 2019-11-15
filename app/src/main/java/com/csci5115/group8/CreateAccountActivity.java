package com.csci5115.group8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.user.User;
import com.csci5115.group8.data.user.User.UserPreferences;
import com.google.android.material.snackbar.Snackbar;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        final LinearLayout layout = findViewById(R.id.activity_create_account);

        final TextView userName = layout.findViewById(R.id.username);
        final TextView email = layout.findViewById(R.id.email);
        final TextView password = layout.findViewById(R.id.password);
        final TextView repeatPassword = layout.findViewById(R.id.re_password);
        final TextView age = layout.findViewById(R.id.age);
        final TextView gender = layout.findViewById(R.id.gender);
        final Button submit = layout.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validation
                String _username = userName.getText().toString();
                String _email = email.getText().toString();
                String _password = password.getText().toString();
                String _repeatPassword = repeatPassword.getText().toString();
                String _age = age.getText().toString();
                String _gender = gender.getText().toString();
                if (_username.isEmpty() || _email.isEmpty() || _password.isEmpty() || _repeatPassword.isEmpty() || _age.isEmpty() || _gender.isEmpty()) {
                    Snackbar.make(view, "Please fill all fields", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (!_password.equals(_repeatPassword)) {
                    Snackbar.make(view, "Passwords do not match. Please recheck", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (DataManager.getUser(email.getText().toString()) != null) {
                    Snackbar.make(view, "Account with same email exists. Please try using another email", Snackbar.LENGTH_LONG).show();
                    return;
                }
                new User(_email, _password, _username, _gender, _age, "", -1, "", new UserPreferences(false, false, false, false, false, false)));
                Toast.makeText(CreateAccountActivity.this, "Account created successfully. Please log in", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
