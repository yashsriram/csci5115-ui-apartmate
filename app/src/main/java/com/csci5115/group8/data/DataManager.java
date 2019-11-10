package com.csci5115.group8.data;

import com.csci5115.group8.data.apartment.Apartment;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    // Add public data to access here

    public List<Apartment> apartments = new ArrayList<Apartment>();
    public List<Thread> threads = new ArrayList<Thread>();


    // end public accessible data


    private static DataManager soleInstance;

    private DataManager() {

        ////// START CREATE DEFAULT DATA

        // populate threads
        Thread thread1 = new Thread("Bob", "Dylan");
        thread1.addMessage("Hi hows it going, BOB", true);
        thread1.addMessage("not too bad", false);
        threads.add(thread1);

        Thread thread2 = new Thread("Jim", "Smith");
        thread2.addMessage("Hi hows it going, JIM", true);
        thread2.addMessage("pretty good yo", false);
        threads.add(thread2);


        ////// END CREATE DEFAULT DATA


        if (soleInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static DataManager getInstance() {
        if (soleInstance == null) { //if there is no instance available... create new one
            soleInstance = new DataManager();
        }

        return soleInstance;
    }
}
