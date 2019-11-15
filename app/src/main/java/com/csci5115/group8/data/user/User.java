package com.csci5115.group8.data.user;

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

    public User(String email, String password, String name, String gender, int age, int maxBudget, String nativeLanguage, boolean isVerified, UserPreferences preferences) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.maxBudget = maxBudget;
        this.nativeLanguage = nativeLanguage;
        this.isVerified = isVerified;
        this.preferences = preferences;
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
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(email).hashCode();
    }
}
