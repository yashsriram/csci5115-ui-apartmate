package com.csci5115.group8.data;

import android.os.Handler;

import com.csci5115.group8.ui.threadMessage.threadMessagesFragment;

import java.util.ArrayList;

public class Thread {
    public String first_name;
    public String last_name;
    public ArrayList<ThreadMessage> messages = new ArrayList<ThreadMessage>();

    public Thread(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public void addMessage(String message, Boolean isMe) {
        messages.add(new ThreadMessage(message, isMe));
    }

    public void addResponse(final String message, int delaySeconds, threadMessagesFragment frag) {
        final Handler handler = new Handler();
        final threadMessagesFragment thefrag = frag;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                messages.add(new ThreadMessage(message, false));
                thefrag.refreshRecycler();
            }
        }, delaySeconds * 1000);
    }
}
