package com.csci5115.group8;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.csci5115.group8.data.DataManager;
import com.csci5115.group8.data.Thread;
import com.csci5115.group8.data.ThreadMessage;
import com.csci5115.group8.ui.threadMessage.threadMessagesFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


public class ThreadActivity extends AppCompatActivity implements threadMessagesFragment.OnListFragmentInteractionListener {

    private Thread thread;
    private threadMessagesFragment frag;

    public Thread getThread() {
        if (thread == null) {
            String email = getIntent().getStringExtra("email");
            for(Thread t : DataManager.threads) {
                if(t.user.email.equals(email)) {
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

    public void setThreadFragment(threadMessagesFragment frag) {
        this.frag = frag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        System.out.println("GOT");
//        System.out.println(this.getThread().first_name);
        setTitle("Chat - " + this.getThread().user.name);

        final TextView textView = findViewById(R.id.editText4);

        View fragview = findViewById(R.id.threadMessagesFrag);

        textView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    System.out.println(v.getText());
                    getThread().addMessage(v.getText().toString(), true);
                    textView.setText("");
                    getThread().addResponse("This is a response!", 2, frag);
                    frag.refreshRecycler();
                }
                return true;
            }
        });
    }

}
