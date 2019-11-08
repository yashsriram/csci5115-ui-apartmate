package com.csci5115.group8.data;

import java.util.List;

class Unit {
    public int number;
    public int numBathrooms;
    public int numBedrooms;
    public float areaInSqFt;
    public boolean isLeased;

    public Unit(int numBathrooms, int numBedrooms, float areaInSqFt, boolean isLeased) {
        assert (numBathrooms > 0);
        assert (numBedrooms > 0);
        assert (areaInSqFt > 0);
        this.numBathrooms = numBathrooms;
        this.numBedrooms = numBedrooms;
        this.areaInSqFt = areaInSqFt;
        this.isLeased = isLeased;
    }
}

class PerUnitAmenities {
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

class CommonAmenities {
    public boolean laundryRoom;
    public boolean longue;
    public boolean printingService;
    public boolean reception;
    public boolean parking;

    public CommonAmenities(boolean laundryRoom, boolean longue, boolean printingService, boolean reception, boolean parking) {
        this.laundryRoom = laundryRoom;
        this.longue = longue;
        this.printingService = printingService;
        this.reception = reception;
        this.parking = parking;
    }
}

class SecurityFeatures {
    public boolean securityCameras;
    public boolean smokeDetectors;
    public boolean sprinklers;
    public boolean buildingLock;

    public SecurityFeatures(boolean securityCameras, boolean smokeDetectors, boolean sprinklers, boolean buildingLock) {
        this.securityCameras = securityCameras;
        this.smokeDetectors = smokeDetectors;
        this.sprinklers = sprinklers;
        this.buildingLock = buildingLock;
    }
}

public class Apartment {
    public String name;
    public String address;
    public PerUnitAmenities perUnitAmenities;
    public CommonAmenities commonAmenities;
    public SecurityFeatures securityFeatures;
    public List<Unit> units;
}
