package com.csci5115.group8.data;

import java.util.ArrayList;

public class DataManager {

    // Add public data to access here

    public ArrayList<Apartment> apartments = new ArrayList<Apartment>();
    public ArrayList<Thread> threads = new ArrayList<Thread>();


    // end public accessible data


    private static DataManager soleInstance;

    private DataManager() {

        ////// START CREATE DEFAULT DATA

        apartments.add(new Apartment()); // example

        // populate threads
        Thread thread1 = new Thread("Bob", "Dylan");
        thread1.addMessage("Hi hows it going, BOB", true);
        threads.add(thread1);

        Thread thread2 = new Thread("Jim", "Smith");
        thread2.addMessage("Hi hows it going, JIM", true);
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
