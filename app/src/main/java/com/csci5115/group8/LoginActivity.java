package com.csci5115.group8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.csci5115.group8.data.ApartmentSRL;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final LinearLayout layout = findViewById(R.id.activity_login);


        final Button login = layout.findViewById(R.id.login);
        final Button create_account = layout.findViewById(R.id.create_account);
        final Button pswd_forget = layout.findViewById(R.id.forget_password);

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        pswd_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PswdResetActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });

    }
}
