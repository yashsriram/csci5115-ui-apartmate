package com.csci5115.group8.ui.usersearch;

public class UserSearchState {
    String searchText;
    String gender;
    int age;
    int maxBudget;
    int doesSmoke;
    int drugsOkay;
    int hasPets;
    int partiesOkay;
    int canCook;
    int needsPrivateBedroom;
    int hasCar;
    String nativeLanguage;

    public UserSearchState() {
        set("",
                "",
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
                           String gender,
                           int age,
                           int maxBudget,
                           int doesSmoke,
                           int drugsOkay,
                           int hasPets,
                           int partiesOkay,
                           int canCook,
                           int needsPrivateBedroom,
                           int hasCar,
                           String nativeLanguage) {
        set(searchText,
                gender,
                age,
                maxBudget,
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

    public void set(String searchText, String gender, int age, int maxBudget, int doesSmoke, int drugsOkay, int hasPets, int partiesOkay, int canCook, int needsPrivateBedroom, int hasCar, String nativeLanguage) {
        this.searchText = searchText;
        this.gender = gender;
        this.age = age;
        this.maxBudget = maxBudget;
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
