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
    protected Bitmap userImage = null;

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

    public void setUserImage(ImageView imageView) {
        if (userImage == null) {
            new DownloadImageTask(imageView,this).execute("https://i.pravatar.cc/50");
        } else {
            imageView.setImageBitmap(userImage);
        }
    }
}

// https://stackoverflow.com/questions/2471935/how-to-load-an-imageview-by-url-in-android
class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    Thread chatThread;

    public DownloadImageTask(ImageView bmImage, Thread t) {
        this.bmImage = bmImage;
        this.chatThread = t;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
        chatThread.userImage = result;
    }
}