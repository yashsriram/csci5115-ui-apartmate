package com.csci5115.group8.data.apartment;

public class ApartmentUnit {
    public int unitNumber;
    public int numBathrooms;
    public int numBedrooms;
    public float areaInSqFt;
    public boolean isLeased;

    public ApartmentUnit(int unitNumber, int numBedrooms, int numBathrooms, float areaInSqFt, boolean isLeased) {
        assert (unitNumber > 0);
        assert (numBathrooms > 0);
        assert (numBedrooms > 0);
        assert (areaInSqFt > 0);
        this.unitNumber = unitNumber;
        this.numBathrooms = numBathrooms;
        this.numBedrooms = numBedrooms;
        this.areaInSqFt = areaInSqFt;
        this.isLeased = isLeased;
    }
}
