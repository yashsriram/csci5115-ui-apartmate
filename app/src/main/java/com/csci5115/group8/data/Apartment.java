package com.csci5115.group8.data;

import java.util.Date;
import java.util.List;

class Unit {
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
    public boolean microwave;
    public boolean dishwasher;
    public boolean washingMachine;
    public boolean heating;
    public boolean cooling;

    public PerUnitAmenities(boolean refrigerator, boolean microwave, boolean dishwasher, boolean washingMachine, boolean heating, boolean cooling) {
        this.refrigerator = refrigerator;
        this.microwave = microwave;
        this.dishwasher = dishwasher;
        this.washingMachine = washingMachine;
        this.heating = heating;
        this.cooling = cooling;
    }
}

class CommonAmenities {
    public boolean laundryRoom;
    public boolean commonArea;
    public boolean printingService;
    public boolean reception;
    public boolean parking;

    public CommonAmenities(boolean laundryRoom, boolean commonArea, boolean printingService, boolean reception) {
        this.laundryRoom = laundryRoom;
        this.commonArea = commonArea;
        this.printingService = printingService;
        this.reception = reception;
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
    public List<Unit> units;
    public PerUnitAmenities perUnitAmenities;
    public CommonAmenities commonAmenities;
    public SecurityFeatures securityFeatures;
    public Date leasingDate;
}
