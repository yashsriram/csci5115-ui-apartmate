package com.csci5115.group8.data.user;

public class User {
    public String email;
    public String name;
    public String gender;
    public String age;
    public String currentLocation;
    public int maxBudget;
    public UserPreferences userPreferences;


    public User (String email, String name, String gender, String age, String currentLocation,
                  int maxBudget, UserPreferences userPreferences){
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.currentLocation = currentLocation;
        this.maxBudget = maxBudget;
        this.userPreferences = userPreferences;
    }

}
    
