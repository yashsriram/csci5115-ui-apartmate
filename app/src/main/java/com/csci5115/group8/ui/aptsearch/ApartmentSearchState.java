package com.csci5115.group8.ui.aptsearch;

public class ApartmentSearchState {
    String searchText;
    int refrigerator;
    int oven;
    int microwave;
    int dishwasher;
    int washingMachine;
    int heating;
    int cooling;

    int laundryRoom;
    int longue;
    int printingService;
    int reception;
    int parking;

    int securityCameras;
    int smokeDetectors;
    int sprinklers;
    int buildingLock;

    public ApartmentSearchState() {
        set("",
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
        );
    }

    public ApartmentSearchState(String searchText,
                                // Per unit amenities
                                int refrigerator,
                                int oven,
                                int microwave,
                                int dishwasher,
                                int washingMachine,
                                int heating,
                                int cooling,
                                // Common amenities
                                int laundryRoom,
                                int longue,
                                int printingService,
                                int reception,
                                int parking,
                                // Security features
                                int securityCameras,
                                int smokeDetectors,
                                int sprinklers,
                                int buildingLock) {
        set(searchText,
                refrigerator,
                oven,
                microwave,
                dishwasher,
                washingMachine,
                heating,
                cooling,
                laundryRoom,
                longue,
                printingService,
                reception,
                parking,
                securityCameras,
                smokeDetectors,
                sprinklers,
                buildingLock
        );
    }

    public void set(String searchText,
                    // Per unit amenities
                    int refrigerator,
                    int oven,
                    int microwave,
                    int dishwasher,
                    int washingMachine,
                    int heating,
                    int cooling,
                    // Common amenities
                    int laundryRoom,
                    int longue,
                    int printingService,
                    int reception,
                    int parking,
                    // Security features
                    int securityCameras,
                    int smokeDetectors,
                    int sprinklers,
                    int buildingLock) {
        this.searchText = searchText;
        this.refrigerator = refrigerator;
        this.oven = oven;
        this.microwave = microwave;
        this.dishwasher = dishwasher;
        this.washingMachine = washingMachine;
        this.heating = heating;
        this.cooling = cooling;
        this.laundryRoom = laundryRoom;
        this.longue = longue;
        this.printingService = printingService;
        this.reception = reception;
        this.parking = parking;
        this.securityCameras = securityCameras;
        this.smokeDetectors = smokeDetectors;
        this.sprinklers = sprinklers;
        this.buildingLock = buildingLock;
    }
}
