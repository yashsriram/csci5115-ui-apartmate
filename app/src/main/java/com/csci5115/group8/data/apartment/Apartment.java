package com.csci5115.group8.data.apartment;

import java.util.List;

public class Apartment {
    public String name;
    public String address;
    public PerUnitAmenities perUnitAmenities;
    public CommonAmenities commonAmenities;
    public SecurityFeatures securityFeatures;
    public List<ApartmentUnit> units;

    public Apartment(String name, String address, PerUnitAmenities perUnitAmenities, CommonAmenities commonAmenities, SecurityFeatures securityFeatures, List<ApartmentUnit> units) {
        this.name = name;
        this.address = address;
        this.perUnitAmenities = perUnitAmenities;
        this.commonAmenities = commonAmenities;
        this.securityFeatures = securityFeatures;
        this.units = units;
    }
}
