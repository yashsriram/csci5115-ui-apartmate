package com.csci5115.group8.data.user;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.csci5115.group8.data.Thread;

import java.io.InputStream;

public class User {
    public String email;
    public String password;
    public String name;
    public String gender;
    public int age;
    public int maxBudget;
    public String nativeLanguage;
    public boolean isVerified;
    public UserPreferences preferences;
    public int level;

    protected Bitmap userImage = null;


    public User(String email, String password, String name, String gender, int age, int maxBudget, String nativeLanguage, boolean isVerified, UserPreferences preferences, int level) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.maxBudget = maxBudget;
        this.nativeLanguage = nativeLanguage;
        this.isVerified = isVerified;
        this.preferences = preferences;
        this.level = level;
    }

    public User(String email, String password, String name, String gender, int age) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.maxBudget = -1;
        this.nativeLanguage = "";
        this.isVerified = false;
        this.preferences = new UserPreferences(false, false, false, false, false, false, false);
        this.level = 0;
    }

    public void setProfileImage(ImageView imageView) {
        if (userImage == null) {
            new DownloadImageTask(imageView,this).execute("https://i.pravatar.cc/50");
        } else {
            imageView.setImageBitmap(userImage);
        }
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(email).hashCode();
    }
}

// https://stackoverflow.com/questions/2471935/how-to-load-an-imageview-by-url-in-android
class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    User user;

    public DownloadImageTask(ImageView bmImage, User u) {
        this.bmImage = bmImage;
        this.user = u;
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
        user.userImage = result;
    }
}