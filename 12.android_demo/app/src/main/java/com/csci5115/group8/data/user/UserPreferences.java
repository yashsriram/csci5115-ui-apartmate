package com.csci5115.group8.data.user;

public class UserPreferences {
    public boolean doesSmoke;
    public boolean drugsOkay;
    public boolean hasPets;
    public boolean partiesOkay;
    public boolean canCook;
    public boolean needsPrivateBedroom;
    public boolean hasCar;

    public UserPreferences(boolean doesSmoke, boolean drugsOkay, boolean hasPets, boolean partiesOkay,
                           boolean canCook, boolean needsPrivateBedroom, boolean hasCar) {
        this.doesSmoke = doesSmoke;
        this.drugsOkay = drugsOkay;
        this.hasPets = hasPets;
        this.partiesOkay = partiesOkay;
        this.canCook = canCook;
        this.needsPrivateBedroom = needsPrivateBedroom;
        this.hasCar = hasCar;
    }

}
