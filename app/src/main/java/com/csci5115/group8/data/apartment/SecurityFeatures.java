package com.csci5115.group8.data.apartment;

public class SecurityFeatures {
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

