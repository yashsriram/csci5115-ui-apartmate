package com.csci5115.group8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.user.User;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final LinearLayout layout = findViewById(R.id.activity_login);


        final EditText email = layout.findViewById(R.id.email);
        final EditText password = layout.findViewById(R.id.password);
        final Button login = layout.findViewById(R.id.login);
        final Button createAccount = layout.findViewById(R.id.create_account);
        final Button forgetPassword = layout.findViewById(R.id.forget_password);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PswdResetActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, User> users = DataManager.getInstance().users;
                if (users.containsKey(email.getText().toString())
                        && users.get(email.getText().toString()).password.equals(password.getText().toString())) {
                    DataManager.getInstance().currentUser = DataManager.getInstance().users.get(users.get(email.getText().toString()));
                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Credentials are not correct. Please recheck email and password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
