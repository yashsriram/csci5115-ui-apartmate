package com.csci5115.group8;

import android.os.Bundle;

import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.Thread;
import com.csci5115.group8.data.ThreadMessage;
import com.csci5115.group8.ui.threadMessage.threadMessagesFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class ThreadActivity extends AppCompatActivity implements threadMessagesFragment.OnListFragmentInteractionListener {

    private Thread thread;

    public Thread getThread() {
        if (thread == null) {
            String thread_fname = getIntent().getStringExtra("thread_fname");
            String thread_lname = getIntent().getStringExtra("thread_lname");
            for(Thread t : DataManager.getInstance().threads) {
                if(t.first_name.equals(thread_fname) && t.last_name.equals(thread_lname)) {
                    this.thread = t;
                    break;
                }
            }
        }
        return this.thread;
    }

    @Override
    public void onListFragmentInteraction(ThreadMessage item) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        System.out.println("GOT");
        System.out.println(this.getThread().first_name);
        setTitle("Chat - " + this.getThread().first_name + " " + this.getThread().last_name);
    }

}
