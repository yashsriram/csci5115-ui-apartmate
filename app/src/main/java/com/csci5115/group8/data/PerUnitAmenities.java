package com.csci5115.group8.data;

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
}
