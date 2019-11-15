package com.csci5115.group8.data;

import com.csci5115.group8.data.apartment.Apartment;
import com.csci5115.group8.data.apartment.ApartmentUnit;
import com.csci5115.group8.data.apartment.CommonAmenities;
import com.csci5115.group8.data.apartment.PerUnitAmenities;
import com.csci5115.group8.data.apartment.SecurityFeatures;
import com.csci5115.group8.data.user.User;
import com.csci5115.group8.data.user.UserPreferences;
import com.csci5115.group8.ui.aptsearch.ApartmentSearchState;
import com.csci5115.group8.ui.usersearch.UserSearchState;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DataManager {

    // State
    public static User currentUser = null;
    public static UserSearchState userSearchState = new UserSearchState();
    public static ApartmentSearchState apartmentSearchState = new ApartmentSearchState();
    // Database
    public static List<Apartment> apartments = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static ReviewManager reviewManager = new ReviewManager();
    public static List<Thread> threads = new ArrayList<>();
    public static List<Notification> notifications = new ArrayList<>();

    static {
        createApartmentData();
        createUserData();
        createThreadData();
        createNotifications();

    }

    private DataManager() {
    }

    public static Apartment getApartment(int apartmentId) {
        for (Apartment apt : DataManager.apartments) {
            if (apt.id == apartmentId) {
                return apt;
            }
        }
        return null;
    }

    public static User getUser(String userEmail) {
        for (User user : DataManager.users) {
            if (user.email.equals(userEmail)) {
                return user;
            }
        }
        return null;
    }

    public static void updateApartment(int apartmentId, Apartment newApartment) {
        for (int i = 0; i < DataManager.apartments.size(); ++i) {
            if (DataManager.apartments.get(i).id == apartmentId) {
                DataManager.apartments.set(i, newApartment);
            }
        }
    }

    public static List<User> searchUsers(UserSearchState state) {
        String regexString = ".*" + state.searchText + ".*";
        Pattern pattern = Pattern.compile(regexString, Pattern.CASE_INSENSITIVE);
        Pattern pattern2 = Pattern.compile(".*" + state.gender + ".*", Pattern.CASE_INSENSITIVE);
        Pattern pattern3 = Pattern.compile(".*" + state.nativeLanguage + ".*", Pattern.CASE_INSENSITIVE);
        List<User> results = new ArrayList<>();
        for (User user : DataManager.users) {
            // If search matches name and all filters match then only add apt to search results
            if ((pattern.matcher(user.name).matches())
                    && filterMatch(state.doesSmoke, user.preferences.doesSmoke)
                    && filterMatch(state.drugsOkay, user.preferences.drugsOkay)
                    && filterMatch(state.hasPets, user.preferences.hasPets)
                    && filterMatch(state.partiesOkay, user.preferences.partiesOkay)
                    && filterMatch(state.canCook, user.preferences.canCook)
                    && filterMatch(state.needsPrivateBedroom, user.preferences.needsPrivateBedroom)
                    && filterMatch(state.hasCar, user.preferences.hasCar)
                    && (user.maxBudget == state.maxBudget || state.maxBudget == -1)
                    && pattern2.matcher(user.gender).matches()
                    && pattern3.matcher(user.nativeLanguage).matches()
                    && (state.age == user.age || state.age == -1)
            ) {
                results.add(user);
            }
        }
        return results;
    }

    public static List<Apartment> searchApartments(ApartmentSearchState state) {
        String regexString = ".*" + state.searchText + ".*";
        Pattern pattern = Pattern.compile(regexString, Pattern.CASE_INSENSITIVE);
        List<Apartment> results = new ArrayList<>();
        for (Apartment apt : DataManager.apartments) {
            // If search matches name or address and all filters match then only add apt to search results
            if ((pattern.matcher(apt.name).matches() || pattern.matcher(apt.address).matches())
                    && filterMatch(state.refrigerator, apt.perUnitAmenities.refrigerator)
                    && filterMatch(state.oven, apt.perUnitAmenities.oven)
                    && filterMatch(state.microwave, apt.perUnitAmenities.microwave)
                    && filterMatch(state.dishwasher, apt.perUnitAmenities.dishwasher)
                    && filterMatch(state.washingMachine, apt.perUnitAmenities.washingMachine)
                    && filterMatch(state.heating, apt.perUnitAmenities.heating)
                    && filterMatch(state.cooling, apt.perUnitAmenities.cooling)
                    && filterMatch(state.laundryRoom, apt.commonAmenities.laundryRoom)
                    && filterMatch(state.longue, apt.commonAmenities.longue)
                    && filterMatch(state.printingService, apt.commonAmenities.printingService)
                    && filterMatch(state.reception, apt.commonAmenities.reception)
                    && filterMatch(state.parking, apt.commonAmenities.parking)
                    && filterMatch(state.securityCameras, apt.securityFeatures.securityCameras)
                    && filterMatch(state.smokeDetectors, apt.securityFeatures.smokeDetectors)
                    && filterMatch(state.sprinklers, apt.securityFeatures.sprinklers)
                    && filterMatch(state.buildingLock, apt.securityFeatures.buildingLock)) {
                results.add(apt);
            }
        }
        return results;
    }

    public static void generateNotification(String message) {
        notifications.add(new Notification(message));
    }

    public static int getUnreadNotifications() {
        int num = 0;
        for (Notification n : notifications) {
            if (!n.read) num++;
        }
        return num;
    }

    private static boolean filterMatch(int filter, boolean field) {
        if (filter == 0) {
            return true;
        } else if (filter == 1) {
            return !field;
        } else {
            return field;
        }
    }

    private static void createNotifications() {
        notifications.add(new Notification("First notification!"));
    }

    private static void createApartmentData() {
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

    private static void createUserData() {
        users.add(new User("john@apartmate.com", "john", "John Doe", "male", 20, 600, "English", true,
                new UserPreferences(true, false, false, true, false, false, true))
        );
        users.add(new User("kate@apartmate.com", "kate", "Kate", "female", 23, 700, "Spanish", false,
                new UserPreferences(true, false, true, true, true, false, true))
        );
        users.add(new User("nate@apartmate.com", "nate", "Nate", "female", 22, 620, "English", true,
                new UserPreferences(true, true, false, true, true, true, true))
        );
    }

    private static void createThreadData() {
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
