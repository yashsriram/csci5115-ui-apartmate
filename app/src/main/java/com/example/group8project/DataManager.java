package com.example.group8project;

public class DataManager {

    // Add public data and methods here

    private static DataManager soleInstance;

    private DataManager(){
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
