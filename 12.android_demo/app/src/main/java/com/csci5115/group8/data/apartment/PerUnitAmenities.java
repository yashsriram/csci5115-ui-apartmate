package com.csci5115.group8.data.apartment;

import androidx.annotation.NonNull;

import java.util.List;


public class PerUnitAmenities {
    public boolean refrigerator;
    public boolean oven;
    public boolean microwave;
    public boolean dishwasher;
    public boolean washingMachine;
    public boolean heating;
    public boolean cooling;

    public PerUnitAmenities(boolean refrigerator, boolean oven, boolean microwave, boolean dishwasher, boolean washingMachine, boolean heating, boolean cooling) {
        this.refrigerator = refrigerator;
        this.oven = oven;
        this.microwave = microwave;
        this.dishwasher = dishwasher;
        this.washingMachine = washingMachine;
        this.heating = heating;
        this.cooling = cooling;
    }

    @NonNull
    @Override
    public String toString() {
        String str = "";
        if (refrigerator) str += "Refrigerator, ";
        if (oven) str += "Oven, ";
        if (microwave) str += "Microwave, ";
        if (dishwasher) str += "Dishwasher, ";
        if (washingMachine) str += "Washing Machine, ";
        if (heating) str += "Heating, ";
        if (cooling) str += "Cooling, ";
        return str;
    }
}
