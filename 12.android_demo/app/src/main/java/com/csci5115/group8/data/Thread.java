package com.csci5115.group8.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.csci5115.group8.data.user.User;
import com.csci5115.group8.ui.threadMessage.threadMessagesFragment;

import java.io.InputStream;
import java.util.ArrayList;

public class Thread {
    public User user;
    public ArrayList<ThreadMessage> messages = new ArrayList<ThreadMessage>();

    public Thread(User user) {
        this.user = user;
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

