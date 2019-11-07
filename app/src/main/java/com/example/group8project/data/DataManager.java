package com.example.group8project.data;

import java.util.ArrayList;

public class DataManager {

    // Add public data to access here
    public ArrayList<Apartment> apartments = new ArrayList<Apartment>();



    private static DataManager soleInstance;

    private DataManager(){

        // add default data here
        apartments.add(new Apartment());



        if (soleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static DataManager getInstance(){
        if (soleInstance == null){ //if there is no instance available... create new one
            soleInstance = new DataManager();
        }

        return soleInstance;
    }
}
