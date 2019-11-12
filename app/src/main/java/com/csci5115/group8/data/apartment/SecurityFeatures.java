package com.csci5115.group8.data.apartment;

import androidx.annotation.NonNull;

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

    @NonNull
    @Override
    public String toString() {
        String str = "";
        if (securityCameras) str += "Security Cameras, ";
        if (smokeDetectors) str += "Smoke Detectors, ";
        if (sprinklers) str += "Sprinklers, ";
        if (buildingLock) str += "Building Lock, ";
        return str;
    }
}

