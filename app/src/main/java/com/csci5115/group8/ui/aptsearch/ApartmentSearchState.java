package com.csci5115.group8.ui.aptsearch;

public class ApartmentSearchState {
    public String searchText;
    public int refrigerator;
    public int oven;
    public int microwave;
    public int dishwasher;
    public int washingMachine;
    public int heating;
    public int cooling;

    public int laundryRoom;
    public int longue;
    public int printingService;
    public int reception;
    public int parking;

    public int securityCameras;
    public int smokeDetectors;
    public int sprinklers;
    public int buildingLock;

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
