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
        threads.add(new Thread("Bob"));


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
