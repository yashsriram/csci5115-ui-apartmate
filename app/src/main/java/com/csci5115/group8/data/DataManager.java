package com.csci5115.group8.data;

import com.csci5115.group8.data.apartment.Apartment;
import com.csci5115.group8.data.apartment.ApartmentUnit;
import com.csci5115.group8.data.apartment.CommonAmenities;
import com.csci5115.group8.data.apartment.PerUnitAmenities;
import com.csci5115.group8.data.apartment.SecurityFeatures;
import com.csci5115.group8.data.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManager {

    // Add public data to access here

    public User currentUser = null;
    public List<Apartment> apartments = new ArrayList<>();
    public List<Thread> threads = new ArrayList<>();
    public Map<String, User> users = new HashMap<>();
    public List<Notification> notifications = new ArrayList<>();


    // end public accessible data


    private static DataManager soleInstance;

    private DataManager() {

        ////// START CREATE DEFAULT DATA

        createApartmentData();
        createUserData();
        createThreadData();
        createNotifications();


        ////// END CREATE DEFAULT DATA


        if (soleInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static DataManager getInstance() {
        if (soleInstance == null) { //if there is no instance available... create new one
            soleInstance = new DataManager();
        }

        return soleInstance;
    }

    public static Apartment getApartment(int apartmentId) {
        for (Apartment apt : DataManager.getInstance().apartments) {
            if (apt.id == apartmentId) {
                return apt;
            }
        }
        return null;
    }

    public static void updateApartment(int apartmentId, Apartment newApartment) {
        for (int i = 0; i < DataManager.getInstance().apartments.size(); ++i) {
            if (DataManager.getInstance().apartments.get(i).id == apartmentId) {
                DataManager.getInstance().apartments.set(i, newApartment);
            }
        }
    }

    public static List<User> getUsersList(Map<String, User> users) {
        List<User> usersList = new ArrayList<>();
        for (Map.Entry<String, User> entry: users.entrySet()) {
            usersList.add(entry.getValue());
        }
        return usersList;
    }

    public static List<User> getUserList() {
        return getUsersList(DataManager.getInstance().users);
    }

    public void generateNotification(String message) {
        this.notifications.add(new Notification(message));
    }

    public int getUnreadNotifications() {
        int num = 0;
        for (Notification n : notifications) {
            if (!n.read) num++;
        }
        return num;
    }

    private void createNotifications() {
        this.notifications.add(new Notification("First notification!"));
    }

    private void createApartmentData() {
        List<ApartmentUnit> oneUnit = new ArrayList<>();
        oneUnit.add(new ApartmentUnit(102, 2, 2, 75.5f, false));
        List<ApartmentUnit> twoUnits = new ArrayList<>();
        twoUnits.add(new ApartmentUnit(101, 3, 2, 100.1f, true));
        twoUnits.add(new ApartmentUnit(102, 2, 2, 75.5f, false));
        List<ApartmentUnit> threeUnits = new ArrayList<>();
        threeUnits.add(new ApartmentUnit(101, 3, 2, 100.1f, false));
        threeUnits.add(new ApartmentUnit(102, 2, 2, 75.5f, true));
        threeUnits.add(new ApartmentUnit(103, 4, 2, 150.5f, false));
        List<ApartmentUnit> manyUnits = new ArrayList<>();
        manyUnits.add(new ApartmentUnit(101, 3, 2, 100.1f, false));
        manyUnits.add(new ApartmentUnit(101, 2, 2, 75.5f, true));
        manyUnits.add(new ApartmentUnit(102, 2, 2, 75.5f, true));
        manyUnits.add(new ApartmentUnit(103, 2, 2, 75.5f, true));
        manyUnits.add(new ApartmentUnit(104, 2, 2, 75.5f, true));
        manyUnits.add(new ApartmentUnit(105, 2, 2, 75.5f, true));
        manyUnits.add(new ApartmentUnit(106, 2, 2, 75.5f, true));
        manyUnits.add(new ApartmentUnit(107, 2, 2, 75.5f, true));
        manyUnits.add(new ApartmentUnit(108, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(109, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(110, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(111, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(112, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(113, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(114, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(115, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(117, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(118, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(119, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(120, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(121, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(122, 4, 2, 150.5f, false));
        manyUnits.add(new ApartmentUnit(123, 4, 2, 150.5f, false));
        apartments.add(
                new Apartment(1, "LimeLight Apts", "811 4th St SE",
                        new PerUnitAmenities(true, true, true, true, true, true, true),
                        new CommonAmenities(true, true, true, true, true),
                        new SecurityFeatures(true, true, true, true),
                        twoUnits));
        apartments.add(
                new Apartment(2, "Bierman place", "1401 6th St SE, Minneapolis, MN 55414",
                        new PerUnitAmenities(true, true, false, true, true, true, true),
                        new CommonAmenities(true, false, true, true, true),
                        new SecurityFeatures(true, true, false, true),
                        manyUnits));
        apartments.add(
                new Apartment(3, "Elysian apts", "711 4th St SE, Minneapolis, MN 55414",
                        new PerUnitAmenities(true, true, true, true, false, true, true),
                        new CommonAmenities(true, true, true, true, false),
                        new SecurityFeatures(true, true, true, false),
                        twoUnits));
        apartments.add(
                new Apartment(4, "Solhaus", "2428 Delaware St SE, Minneapolis, MN 55414",
                        new PerUnitAmenities(true, false, true, true, false, true, true),
                        new CommonAmenities(false, true, false, true, false),
                        new SecurityFeatures(true, true, true, false),
                        threeUnits));
        apartments.add(
                new Apartment(5, "Wahu", "1016 Washington Ave SE, Minneapolis, MN 55414",
                        new PerUnitAmenities(true, false, true, true, false, true, true),
                        new CommonAmenities(false, true, false, true, false),
                        new SecurityFeatures(false, true, true, false),
                        twoUnits));
        apartments.add(
                new Apartment(6, "Quad on delaware", "2508 Delaware St SE, Minneapolis, MN 55414",
                        new PerUnitAmenities(true, false, true, true, false, false, true),
                        new CommonAmenities(false, true, false, true, true),
                        new SecurityFeatures(false, false, true, false),
                        oneUnit));
    }

    private void createUserData() {
        users.put("john@apartmate.com",
                new User("john@apartmate.com",
                        "pass",
                        "John",
                        "male",
                        20,
                        600,
                        false,
                        false,
                        true,
                        true,
                        true,
                        true,
                        "English",
                        false,
                        true
                )
        );
        users.put("kate@apartmate.com",
                new User("kate@apartmate.com",
                        "pass",
                        "Kate",
                        "female",
                        22,
                        620,
                        true,
                        false,
                        true,
                        true,
                        false,
                        true,
                        "English",
                        true,
                        true
                )
        );
        users.put("nate@apartmate.com",
                new User("nate@apartmate.com",
                        "pass",
                        "Nate",
                        "male",
                        24,
                        500,
                        false,
                        true,
                        true,
                        true,
                        true,
                        false,
                        "Spanish",
                        false,
                        false
                )
        );
    }

    private void createThreadData() {
        Thread thread1 = new Thread("Bob", "Dylan");
        thread1.addMessage("Hi hows it going, BOB", true);
        thread1.addMessage("not too bad", false);
        threads.add(thread1);

        Thread thread2 = new Thread("Jim", "Smith");
        thread2.addMessage("Hi hows it going, JIM", true);
        thread2.addMessage("pretty good yo", false);
        threads.add(thread2);
    }
}
