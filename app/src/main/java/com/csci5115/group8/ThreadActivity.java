package com.csci5115.group8;

import android.os.Bundle;

import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.Thread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class ThreadActivity extends AppCompatActivity {

    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String thread_fname = getIntent().getStringExtra("thread_fname");
        String thread_lname = getIntent().getStringExtra("thread_lname");
        for(Thread t : DataManager.getInstance().threads) {
            if(t.first_name.equals(thread_fname) && t.last_name.equals(thread_lname)) {
                this.thread = t;
                break;
            }
        }
        System.out.println("GOT");
        System.out.println(this.thread.first_name);
    }

}
