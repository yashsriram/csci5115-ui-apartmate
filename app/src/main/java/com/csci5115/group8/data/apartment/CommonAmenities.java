package com.csci5115.group8.data.apartment;

import androidx.annotation.NonNull;

import java.util.List;



public class CommonAmenities {
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

    @NonNull
    @Override
    public String toString() {
        String str = "";
        if (laundryRoom) str += "Laundry Room, ";
        if (longue) str += "Longue, ";
        if (printingService) str += "Printing Service, ";
        if (reception) str += "Reception, ";
        if (parking) str += "Parking, ";
        return str;
    }
}


