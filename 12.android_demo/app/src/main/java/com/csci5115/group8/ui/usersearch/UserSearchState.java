package com.csci5115.group8.ui.usersearch;

public class UserSearchState {
    public String searchText;
    public int gender_male;
    public int gender_female;
    public int gender_other;
    public int age;
    public int age2;
    public int maxBudget;
    public int maxBudget2;
    public int doesSmoke;
    public int drugsOkay;
    public int hasPets;
    public int partiesOkay;
    public int canCook;
    public int needsPrivateBedroom;
    public int hasCar;
    public String nativeLanguage;

    public UserSearchState() {
        set("",
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                ""
        );
    }

    public UserSearchState(String searchText,
                           int gender_male,int gender_female,int gender_other, int age,int age2, int maxBudget,int maxBudget2,
                           int doesSmoke,
                           int drugsOkay,
                           int hasPets,
                           int partiesOkay,
                           int canCook,
                           int needsPrivateBedroom,
                           int hasCar,
                           String nativeLanguage) {
        set(searchText,
        gender_male,gender_female,gender_other, age, age2,  maxBudget, maxBudget2,
                doesSmoke,
                drugsOkay,
                hasPets,
                partiesOkay,
                canCook,
                needsPrivateBedroom,
                hasCar,
                nativeLanguage
        );
    }

    public void set(String searchText, int gender_male,int gender_female,int gender_other, int age,int age2, int maxBudget,int maxBudget2, int doesSmoke, int drugsOkay, int hasPets, int partiesOkay, int canCook, int needsPrivateBedroom, int hasCar, String nativeLanguage) {
        this.searchText = searchText;
        this.gender_male = gender_male;
        this.gender_female = gender_female;
        this.gender_other = gender_other;
        this.age = age;
        this.age2 = age2;
        this.maxBudget = maxBudget;
        this.maxBudget2 = maxBudget2;
        this.doesSmoke = doesSmoke;
        this.drugsOkay = drugsOkay;
        this.hasPets = hasPets;
        this.partiesOkay = partiesOkay;
        this.canCook = canCook;
        this.needsPrivateBedroom = needsPrivateBedroom;
        this.hasCar = hasCar;
        this.nativeLanguage = nativeLanguage;
    }
}
