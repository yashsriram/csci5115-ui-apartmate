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

    // Apartment
    public static Apartment getApartment(int apartmentId) {
        for (Apartment apt : DataManager.apartments) {
            if (apt.id == apartmentId) {
                return apt;
            }
        }
        return null;
    }

    public static Apartment getApartment(String apartmentAddress) {
        for (Apartment apt : DataManager.apartments) {
            if (apt.address.equals(apartmentAddress)) {
                return apt;
            }
        }
        return null;
    }

    public static int getNumAparments() {
        return apartments.size();
    }

    public static void createApartment(Apartment newApartment) {
        if (DataManager.currentUser != null) {
            DataManager.currentUser.level += 2;
        }
        DataManager.apartments.add(newApartment);
    }

    public static void updateApartment(int apartmentId, Apartment newApartment) {
        if (DataManager.currentUser != null) {
            DataManager.currentUser.level += 1;
        }
        for (int i = 0; i < DataManager.apartments.size(); ++i) {
            if (DataManager.apartments.get(i).id == apartmentId) {
                DataManager.apartments.set(i, newApartment);
            }
        }
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
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/vKF6vjxkWvU\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, true, true, true, true, true),
                        new CommonAmenities(true, true, true, true, true),
                        new SecurityFeatures(true, true, true, true),
                        twoUnits));
        apartments.add(
                new Apartment(2, "Bierman Place", "1401 6th St SE, Minneapolis, MN 55414",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/3Wy4G924V2I\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, false, true, true, true, true),
                        new CommonAmenities(true, false, true, true, true),
                        new SecurityFeatures(true, true, false, true),
                        manyUnits));
        apartments.add(
                new Apartment(3, "Elysian Apts", "711 4th St SE, Minneapolis, MN 55414",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/p_SaeH1qpng\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, true, true, false, true, true),
                        new CommonAmenities(true, true, true, true, false),
                        new SecurityFeatures(true, true, true, false),
                        twoUnits));
        apartments.add(
                new Apartment(4, "Solhaus", "2428 Delaware St SE, Minneapolis, MN 55414",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/nFu7zE9DnRA\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, false, true, true),
                        new CommonAmenities(false, true, false, true, false),
                        new SecurityFeatures(true, true, true, false),
                        threeUnits));
        apartments.add(
                new Apartment(5, "Wahu", "1016 Washington Ave SE, Minneapolis, MN 55414",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/zaf6StO4gy4\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, false, true, true),
                        new CommonAmenities(false, true, false, true, false),
                        new SecurityFeatures(false, true, true, false),
                        twoUnits));
        apartments.add(
                new Apartment(6, "Quad on Delaware", "2508 Delaware St SE, Minneapolis, MN 55414",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/DluFoF_qvOg\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, false, false, true),
                        new CommonAmenities(false, true, false, true, true),
                        new SecurityFeatures(false, false, true, false),
                        oneUnit));
        apartments.add(
                new Apartment(7, "44 North", "2701 4th St SE, Minneapolis, MN 55414",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/uyIVi9is7Dk\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, true, true, true, false, false),
                        new CommonAmenities(true, true, false, true, true),
                        new SecurityFeatures(true, true, false, true),
                        twoUnits));
        apartments.add(
                new Apartment(8, "4th Street Co-op", "1227 4th St SE, Minneapolis, MN 55414",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/2K5Sq_sKPGA\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, false, false, true, true),
                        new CommonAmenities(false, false, false, true, true),
                        new SecurityFeatures(false, false, true, false),
                        manyUnits));
        apartments.add(
                new Apartment(9, "Chateau", "425 13th Ave SE, Minneapolis, MN 55414",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/udAsbaQDPII\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, false, false, true),
                        new CommonAmenities(true, true, true, false, true),
                        new SecurityFeatures(true, false, false, false),
                        threeUnits));
        apartments.add(
                new Apartment(10, "FloCo Fusion", "1000 University Ave SE, Minneapolis, MN 55414",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/IYaFOWxw1Eg\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, false, false, true, true, false),
                        new CommonAmenities(false, true, false, true, true),
                        new SecurityFeatures(true, true, true, false),
                        twoUnits));
        apartments.add(
                new Apartment(11, "Dinnaken", "900 Washington Ave SE, Minneapolis, MN 55414",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/ED847h71QDs\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, false, false, true, true),
                        new CommonAmenities(true, false, false, false, true),
                        new SecurityFeatures(true, true, true, false),
                        oneUnit));
        apartments.add(
                new Apartment(12, "The Pavilion", "5441 East River Rd NE, Chicago, IL 60656",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/qSsajCHJH5k\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, false, false, true),
                        new CommonAmenities(true, true, false, true, true),
                        new SecurityFeatures(false, true, true, true),
                        twoUnits));
        apartments.add(
                new Apartment(13, "200 Squared", "210 Wells St N, Chicago, IL 60606",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/L15P58c-pQk\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, true, true, false, false, true),
                        new CommonAmenities(true, true, true, true, false),
                        new SecurityFeatures(false, true, true, false),
                        threeUnits));
        apartments.add(
                new Apartment(14, "Park View Apts", "1936 Clark St N, Chicago, IL 60614",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/0y4rXoWrJlw\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, false, true, true, false, true),
                        new CommonAmenities(false, false, false, true, true),
                        new SecurityFeatures(false, true, true, true),
                        oneUnit));
        apartments.add(
                new Apartment(15, "Lofts at River East", "401 Illinois St E, Chicago, IL 60611",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/OhPTNCVMznY\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, true, true, false, true, true),
                        new CommonAmenities(false, true, true, true, true),
                        new SecurityFeatures(true, false, true, false),
                        manyUnits));
        apartments.add(
                new Apartment(16, "Aurelien", "833 Clark St N, Chicago, IL 60610",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/siBj-vWuSOU\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, false, true, false, false, false),
                        new CommonAmenities(true, false, false, false, true),
                        new SecurityFeatures(true, true, true, false),
                        oneUnit));
        apartments.add(
                new Apartment(17, "Tanner Flats", "2004 Jefferson St SW, Portland, OR 97201",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/siBj-vWuSOU\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(false, false, false, true, false, true, true),
                        new CommonAmenities(false, true, true, true, false),
                        new SecurityFeatures(true, false, true, true),
                        threeUnits));
        apartments.add(
                new Apartment(18, "The Cordelia", "777 19th Ave NW, Portland, OR 97209",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/iJw5Ug49SBg\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, true, true, false, false, false),
                        new CommonAmenities(true, false, false, true, false),
                        new SecurityFeatures(true, true, true, false),
                        twoUnits));
        apartments.add(
                new Apartment(19, "Harrison Tower", "222 Harrison St SW, Portland, OR 97201",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/4B7vs7tPRpQ\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, true, true, false, false, true),
                        new CommonAmenities(false, true, false, false, false),
                        new SecurityFeatures(false, true, true, true),
                        oneUnit));
        apartments.add(
                new Apartment(20, "Northwood", "8338 Interstate Ave N, Portland, OR 97217",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/oGt3t6crCMY\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, false, true, false, true, true),
                        new CommonAmenities(false, true, false, true, true),
                        new SecurityFeatures(true, false, true, false),
                        manyUnits));
        apartments.add(
                new Apartment(21, "Tower 12", "2015 2nd Ave, Seattle, WA 98121",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/3BKpGtLjTsY\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, true, false, false, false, true),
                        new CommonAmenities(true, true, false, true, true),
                        new SecurityFeatures(false, true, true, false),
                        oneUnit));
        apartments.add(
                new Apartment(22, "Via 6", "2121 6th Ave, Seattle, WA 98121",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/QYxXksVUVIw\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, false, false, false, false),
                        new CommonAmenities(false, true, true, true, true),
                        new SecurityFeatures(false, true, true, false),
                        twoUnits));
        apartments.add(
                new Apartment(23, "Stratus", "820 Lenora St, Seattle, WA 98121",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/nU9v22xv44E\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, true, true, false, false, false),
                        new CommonAmenities(false, true, false, true, false),
                        new SecurityFeatures(false, true, false, true),
                        threeUnits));
        apartments.add(
                new Apartment(24, "Guinevere Apts", "522 85th St N, Seattle, WA 98103",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/-yMqgyYkNyc\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(false, false, true, false, true, true, true),
                        new CommonAmenities(false, true, false, true, true),
                        new SecurityFeatures(false, false, true, false),
                        twoUnits));
        apartments.add(
                new Apartment(25, "Helios", "1600 2nd Ave, Seattle, WA, 98101",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/lLuiDUMKoFI\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, false, true, false, true, true),
                        new CommonAmenities(true, true, false, true, false),
                        new SecurityFeatures(true, true, false, false),
                        threeUnits));
        apartments.add(
                new Apartment(26, "SoMa Square", "1 Saint Francis Pl, San Francisco, CA 94107",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/z_mt1CQyJ-I\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, true, true, false, true, false),
                        new CommonAmenities(true, false, false, false, true),
                        new SecurityFeatures(false, false, true, true),
                        twoUnits));
        apartments.add(
                new Apartment(27, "The Paramount", "680 Mission St, San Francisco, CA 94105",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/iPnDBbGQnqY\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(false, true, false, true, true, false, true),
                        new CommonAmenities(false, true, true, false, true),
                        new SecurityFeatures(false, true, true, true),
                        threeUnits));
        apartments.add(
                new Apartment(28, "L Seven Apts", "1222 Harrison St, San Francisco, CA 94103",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/FA_JZL1iUJw\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, false, true, false, true, true),
                        new CommonAmenities(false, true, false, false, true),
                        new SecurityFeatures(true, false, true, false),
                        manyUnits));
        apartments.add(
                new Apartment(29, "Edgewater", "355 Berry St, San Francisco, CA 94158",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/sYRQwIik0oA\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, false, true, true),
                        new CommonAmenities(false, true, false, true, false),
                        new SecurityFeatures(false, false, true, true),
                        twoUnits));
        apartments.add(
                new Apartment(30, "Presidio Residences", "222 Holleck St, San Francisco, CA 94129",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/KtAfaik7NKY\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, true, false, true),
                        new CommonAmenities(false, true, true, true, true),
                        new SecurityFeatures(false, true, true, false),
                        manyUnits));
        apartments.add(
                new Apartment(31, "East Vue Ranch Apts", "460 Bastrop Hwy SE, Austin, TX 78741",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/uTybaFjhcsI\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, false, true, false, false, true),
                        new CommonAmenities(true, true, true, true, true),
                        new SecurityFeatures(true, true, true, false),
                        oneUnit));
        apartments.add(
                new Apartment(32, "Urbana", "9005 Alderman Dr, Austin, TX 78747",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/RocQ8p6Z2XA\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(false, false, true, true, true, true, true),
                        new CommonAmenities(false, true, false, true, false),
                        new SecurityFeatures(false, true, true, true),
                        manyUnits));
        apartments.add(
                new Apartment(33, "The Hendrix", "9811 Copper Crk, Austin, TX 78729",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/mC_hO9ku24g\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, false, true, true, true),
                        new CommonAmenities(false, true, true, false, true),
                        new SecurityFeatures(false, true, false, true),
                        twoUnits));
        apartments.add(
                new Apartment(34, "Lamar Union", "1100 Lamar Blvd S, Austin, TX 78704",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/an78l92eHjY\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, false, true, false, true, true),
                        new CommonAmenities(false, true, false, true, false),
                        new SecurityFeatures(false, true, true, true),
                        manyUnits));
        apartments.add(
                new Apartment(35, "Mosaic at Mueller", "4600 Mueller Blvd, Austin, TX 78738",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/Qg3QQZ5L0FU\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, true, false, true),
                        new CommonAmenities(true, true, true, true, true),
                        new SecurityFeatures(false, false, true, false),
                        oneUnit));
        apartments.add(
                new Apartment(36, "Stuyvesant Town", "409 14th St E, New York, NY 10009",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/tJebDDFr4Ug\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, false, false, false, true),
                        new CommonAmenities(true, false, false, true, false),
                        new SecurityFeatures(false, true, true, true),
                        oneUnit));
        apartments.add(
                new Apartment(37, "Peter Cooper Village", "360 1st Ave, New York, NY 10009",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/_TQqHac2cu8\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, true, true, true, true, true, true),
                        new CommonAmenities(false, false, true, false, false),
                        new SecurityFeatures(false, false, true, false),
                        manyUnits));
        apartments.add(
                new Apartment(38, "The Helena", "601 57th St W, New York, NY 10019",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/-zHGSUM2KEs\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, false, true, true),
                        new CommonAmenities(false, true, false, true, false),
                        new SecurityFeatures(true, true, true, false),
                        twoUnits));
        apartments.add(
                new Apartment(39, "19 Dutch", "118 Fulton St, New York, NY 10038",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/UrbQvYt3zxw\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(false, false, true, true, true, true, true),
                        new CommonAmenities(false, true, true, false, true),
                        new SecurityFeatures(false, true, false, false),
                        manyUnits));
        apartments.add(
                new Apartment(40, "Avalon West Chelsea", "282 11th Ave, New York, NY 10001",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/lVjHJ1ICc8E\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, true, false, true),
                        new CommonAmenities(false, true, true, true, true),
                        new SecurityFeatures(false, true, true, false),
                        threeUnits));
        apartments.add(
                new Apartment(41, "Dunwoody Village", "2311 Dunwoody Xing, Atlanta, GA 30338",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/E4gL3_SrP-o\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, true, true, true),
                        new CommonAmenities(false, true, false, true, true),
                        new SecurityFeatures(false, true, false, false),
                        twoUnits));
        apartments.add(
                new Apartment(42, "Tower Hamlets", "12 Barnsley St, London, UK 25103",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/5BdBt7iQXeM\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, false, true, true, true),
                        new CommonAmenities(false, true, true, false, true),
                        new SecurityFeatures(false, true, false, false),
                        oneUnit));
        apartments.add(
                new Apartment(43, "Hardwicks Square", "259 Hardwicks Sq, London, UK 25126",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/D6aS2IE3mz8\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(false, true, true, true, true, false, true),
                        new CommonAmenities(true, false, false, true, true),
                        new SecurityFeatures(false, true, true, false),
                        twoUnits));
        apartments.add(
                new Apartment(44, "Finsbury Park Apts", "351 Holbrook Rd, London, UK 25127",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/OAxrOszJX28\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(false, false, true, true, true, false, true),
                        new CommonAmenities(false, true, true, true, true),
                        new SecurityFeatures(true, true, true, false),
                        manyUnits));
        apartments.add(
                new Apartment(45, "Prenzlauer Berg Apts", "15 Wilmersdorf St, Berlin, Germany 94129",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/FwGyeelBhDQ\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, false, false, true),
                        new CommonAmenities(true, true, true, false, false),
                        new SecurityFeatures(false, true, true, false),
                        oneUnit));
        apartments.add(
                new Apartment(46, "Kreuzberg", "1 Stresemannstabe, Berlin, Germany 94129",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/rIhfdVJ8mnQ\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(false, false, false, false, true, false, true),
                        new CommonAmenities(false, true, false, true, true),
                        new SecurityFeatures(false, false, true, false),
                        twoUnits));
        apartments.add(
                new Apartment(47, "Akasaka Hinemachi Tower", "9-4-1 Akasaka Minato-ku, Tokyo, Japan 100-0014",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/G7jkFNUoNu8\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, true, false, true),
                        new CommonAmenities(true, true, true, true, true),
                        new SecurityFeatures(false, false, true, false),
                        manyUnits));
        apartments.add(
                new Apartment(48, "Park Cube Atagoyama Tower", "3-17-7 Nishi-Shinbashi Minato-Ku, Tokyo, Japan 100-0013",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/rFkcwg84XMo\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(false, false, true, false, true, false, true),
                        new CommonAmenities(false, true, false, false, true),
                        new SecurityFeatures(false, true, true, true),
                        twoUnits));
        apartments.add(
                new Apartment(49, "Ubora Tower", "15 Marasi Dr, Dubai, UAE 00000",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/pe8X1Zgg-vk\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, false, true, true),
                        new CommonAmenities(false, false, true, true, true),
                        new SecurityFeatures(true, true, true, false),
                        oneUnit));
        apartments.add(
                new Apartment(50, "Tifolia/Callia", "East Pulo Gadung, Jakarta, Indonesia 10110",
                        "<iframe width=\"400\" height=\"300\" src=\"https://www.youtube.com/embed/BmFMj0mpg8E\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                        new PerUnitAmenities(true, false, true, true, true, true, true),
                        new CommonAmenities(false, true, false, true, false),
                        new SecurityFeatures(false, false, true, false),
                        twoUnits));

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

    // User
    public static User getUser(String userEmail) {
        for (User user : DataManager.users) {
            if (user.email.equals(userEmail)) {
                return user;
            }
        }
        return null;
    }

    private static boolean checkGender(String gender,int gender_male,int gender_female,int gender_other){
        if(gender.equals("male")){
            if(gender_male==0) return false;
        }else if(gender.equals("female")){
            if(gender_female==0) return false;
        }else {
            if(gender_other==0)
                return false;
        }
        return  true;
    }
    private static boolean checkMaxBudget(int m0,int m1,int m2){
        if(m1==-1&&m2==-1){return true;}
        if(m2==-1){m2=999999999;}
        if(m0>m1&&m0<m2){return true;}
        return  false;
    }
    private static boolean checkAge(int a0,int a1,int a2){
        if(a1==-1&&a2==-1){return true;}
        if(a2==-1){a2=999;}
        if(a0>a1&&a0<a2){return true;}
        return  false;
    }

    public static boolean first_initalized=false;
    public static List<User> searchUsers(UserSearchState state) {
        //System.out.println("state ==============================================="+userSearchState.age+"  "+userSearchState.doesSmoke);
        String regexString = ".*" + state.searchText + ".*";
        Pattern pattern = Pattern.compile(regexString, Pattern.CASE_INSENSITIVE);
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
                    && checkMaxBudget(user.maxBudget,state.maxBudget,state.maxBudget2)
                    && checkGender(user.gender,state.gender_male,state.gender_female,state.gender_other)
                    && pattern3.matcher(user.nativeLanguage).matches()
                    && checkAge(user.age,state.age,state.age2)
                    && !user.email.equals(currentUser.email)
            ) {
                results.add(user);
            }
        }
        return results;
    }

    private static void createUserData() {
        users.add(new User("john@apartmate.com", "john", "John Doe", "male", 20, 600, "English", false,
                new UserPreferences(true, false, false, true, false, false, true),
                0)
        );
        users.add(new User("kate@apartmate.com", "kate", "Kate", "female", 23, 700, "Spanish", false,
                new UserPreferences(true, false, true, true, true, false, true),
                7)
        );
        users.add(new User("nate@apartmate.com", "nate", "Nate", "female", 22, 620, "English", true,
                new UserPreferences(true, true, false, true, true, true, true),
                3)
        );
        users.add(new User("julio@apartmate.com", "julio", "Julio", "male", 19, 850, "English", true,
                new UserPreferences(true, true, true, false, false, true, true),
                2)
        );
        users.add(new User("priya@apartmate.com", "priya", "Priya", "female", 24, 900, "Bengali", false,
                new UserPreferences(false, false, false, false, true, true, false),
                6)
        );
        users.add(new User("imran@apartmate.com", "imran", "Imran", "male", 18, 580, "Somali", true,
                new UserPreferences(true, true, false, true, true, false, true),
                10)
        );
        users.add(new User("ines@apartmate.com", "ines", "Ines", "nonbinary", 20, 700, "Spanish", true,
                new UserPreferences(false, true, true, true, true, false, false),
                8)
        );
        users.add(new User("tchalla@apartmate.com", "tchalla", "T'Challa", "male", 28, 1000, "Wakandan", true,
                new UserPreferences(true, false, false, true, false, true, true),
                11)
        );
        users.add(new User("eleanor@apartmate.com", "eleanor", "Eleanor", "female", 26, 500, "English", true,
                new UserPreferences(true, true, true, true, false, false, false),
                12)
        );
        users.add(new User("chidi@apartmate.com", "chidi", "Chidi", "male", 32, 650, "French", true,
                new UserPreferences(false, false, false, false, false, true, true),
                6)
        );
        users.add(new User("jason@apartmate.com", "jason", "Jason", "male", 23, 450, "Tagalog", false,
                new UserPreferences(true, true, false, false, false, false, true),
                1)
        );
        users.add(new User("tahani@apartmate.com", "tahani", "Tahani", "female", 29, 1200, "English", false,
                new UserPreferences(false, false, false, false, true, true, true),
                9)
        );
        users.add(new User("janet@apartmate.com", "janet", "Janet", "nonbinary", 30, 700, "English", true,
                new UserPreferences(false, false, true, true, true, true, false),
                17)
        );
        users.add(new User("michael@apartmate.com", "michael", "Michael", "male", 31, 570, "English", false,
                new UserPreferences(false, true, false, true, true, false, true),
                3)
        );
        users.add(new User("anya@apartmate.com", "anya", "Anya", "female", 20, 750, "Russian", false,
                new UserPreferences(true, true, true, false, false, true, true),
                9)
        );
        users.add(new User("jamal@apartmate.com", "jamal", "Jamal", "male", 25, 650, "English", true,
                new UserPreferences(false, false, false, false, true, false, true),
                6)
        );
        users.add(new User("omar@apartmate.com", "omar", "Omar", "male", 24, 800, "Arabic", true,
                new UserPreferences(false, false, true, false, true, true, true),
                14)
        );
        users.add(new User("chris@apartmate.com", "chris", "Chris", "male", 19, 600, "English", true,
                new UserPreferences(false, true, true, false, false, false, true),
                13)
        );
        users.add(new User("stacy@apartmate.com", "stacy", "Stacy", "female", 27, 500, "English", false,
                new UserPreferences(true, false, true, false, true, true, false),
                8)
        );
        users.add(new User("jameela@apartmate.com", "jameela", "Jameela", "female", 21, 580, "Urdu", true,
                new UserPreferences(false, true, false, true, false, true, true),
                7)
        );
        users.add(new User("eduardo@apartmate.com", "eduardo", "Eduardo", "nonbinary", 22, 700, "Portuguese", false,
                new UserPreferences(false, false, true, false, false, true, false),
                4)
        );
        users.add(new User("dmitri@apartmate.com", "dmitri", "Dmitri", "male", 20, 300, "Greek", true,
                new UserPreferences(false, true, true, true, false, true, true),
                1)
        );
        users.add(new User("mohamed@apartmate.com", "mohamed", "Mohamed", "male", 26, 700, "Farsi", true,
                new UserPreferences(false, false, false, false, true, true, false),
                4)
        );
        users.add(new User("fatima@apartmate.com", "fatima", "Fatima", "female", 19, 600, "English", false,
                new UserPreferences(false, true, false, true, false, true, false),
                6)
        );
        users.add(new User("tom@apartmate.com", "tom", "Tom", "male", 28, 800, "English", true,
                new UserPreferences(false, true, true, true, true, true, true),
                7)
        );
        users.add(new User("yash@apartmate.com", "yash", "Yash", "male", 24, 700, "Hindi", true,
                new UserPreferences(false, true, false, false, true, true, false),
                8)
        );
        users.add(new User("tommy@apartmate.com", "tommy", "Tommy", "male", 23, 900, "Mandarin", false,
                new UserPreferences(false, false, false, true, false, false, false),
                6)
        );
        users.add(new User("salma@apartmate.com", "salma", "Salma", "female", 20, 700, "Arabic", true,
                new UserPreferences(false, false, false, false, true, true, false),
                6)
        );
        users.add(new User("miguel@apartmate.com", "miguel", "Miguel", "male", 21, 650, "English", true,
                new UserPreferences(false, false, true, true, true, false, true),
                10)
        );
        users.add(new User("liam@apartmate.com", "liam", "Liam", "male", 26, 380, "English", false,
                new UserPreferences(true, true, false, false, false, true, false),
                2)
        );
        users.add(new User("george@apartmate.com", "george", "George", "male", 22, 450, "English", false,
                new UserPreferences(false, true, false, true, true, true, true),
                5)
        );
        users.add(new User("adam@apartmate.com", "adam", "Adam", "nonbinary", 21, 500, "French", true,
                new UserPreferences(false, false, true, true, false, false, true),
                7)
        );
        users.add(new User("ren@apartmate.com", "ren", "Ren", "male", 18, 800, "Japanese", false,
                new UserPreferences(false, false, true, false, true, true, false),
                9)
        );
        users.add(new User("itsuki@apartmate.com", "itsuki", "Itsuki", "male", 19, 700, "Japanese", true,
                new UserPreferences(false, true, false, true, true, true, true),
                8)
        );
        users.add(new User("joowon@apartmate.com", "priya", "Julio", "male", 21, 900, "Korean", true,
                new UserPreferences(true, true, true, false, true, false, false),
                7)
        );
        users.add(new User("gabriel@apartmate.com", "priya", "Julio", "male", 25, 800, "Malay", false,
                new UserPreferences(true, true, false, false, false, true, false),
                11)
        );
        users.add(new User("neo@apartmate.com", "neo", "Neo", "nonbinary", 26, 670, "English", false,
                new UserPreferences(false, false, false, false, true, true, false),
                13)
        );
        users.add(new User("trinity@apartmate.com", "trinity", "Trinity", "female", 23, 1000, "English", true,
                new UserPreferences(false, false, true, false, false, true, true),
                15)
        );
        users.add(new User("mikhail@apartmate.com", "mikhail", "Mikhail", "male", 22, 900, "Polish", false,
                new UserPreferences(false, true, false, true, true, false, true),
                17)
        );
        users.add(new User("lucas@apartmate.com", "lucas", "Lucas", "male", 27, 680, "Italian", true,
                new UserPreferences(false, false, true, true, false, true, false),
                19)
        );
        users.add(new User("oliver@apartmate.com", "oliver", "Oliver", "male", 19, 800, "English", false,
                new UserPreferences(false, true, false, false, true, true, true),
                6)
        );
        users.add(new User("yusuf@apartmate.com", "yusuf", "Yusuf", "male", 18, 700, "Turkish", false,
                new UserPreferences(false, false, false, true, false, true, false),
                3)
        );
        users.add(new User("andrea@apartmate.com", "andrea", "Andrea", "female", 26, 450, "Spanish", true,
                new UserPreferences(false, true, true, false, true, true, true),
                2)
        );
        users.add(new User("leslie@apartmate.com", "leslie", "Leslie", "female", 19, 500, "English", false,
                new UserPreferences(false, true, false, true, true, true, false),
                21)
        );
        users.add(new User("ron@apartmate.com", "ron", "Ron", "male", 30, 800, "English", false,
                new UserPreferences(false, true, true, false, true, true, true),
                18)
        );
        users.add(new User("seoyun@apartmate.com", "seoyun", "Seo-yun", "female", 23, 1100, "Korean", true,
                new UserPreferences(true, true, false, true, false, true, false),
                23)
        );
        users.add(new User("donna@apartmate.com", "donna", "Donna", "female", 24, 800, "English", true,
                new UserPreferences(true, true, false, false, true, false, true),
                24)
        );
        users.add(new User("ann@apartmate.com", "ann", "Ann", "female", 23, 1000, "English", true,
                new UserPreferences(true, true, false, false, true, true, false),
                22)
        );
        users.add(new User("april@apartmate.com", "april", "April", "female", 22, 400, "Spanish", false,
                new UserPreferences(false, true, true, false, false, false, true),
                17)
        );
        users.add(new User("ben@apartmate.com", "ben", "Ben", "male", 26, 500, "English", false,
                new UserPreferences(false, true, false, false, false, false, false),
                5)
        );
        users.add(new User("andy@apartmate.com", "andy", "Andy", "male", 29, 300, "English", true,
                new UserPreferences(false, false, false, true, true, false, true),
                2)
        );
    }

    public static void updateUser(String email, String name, int age, int maxBudget, String gender, String nativeLanguage, UserPreferences preferences) {
        if (DataManager.currentUser != null) {
            DataManager.currentUser.email = email;
            DataManager.currentUser.name = name;
            DataManager.currentUser.age = age;
            DataManager.currentUser.maxBudget = maxBudget;
            DataManager.currentUser.gender = gender;
            DataManager.currentUser.nativeLanguage = nativeLanguage;
            DataManager.currentUser.preferences = preferences;
        }
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

    // Chat and notifications
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

    private static void createNotifications() {
        notifications.add(new Notification("First notification!"));
    }

    private static void createThreadData() {
        Thread thread1 = new Thread(users.get(0));
        thread1.addMessage("Hi hows it going, BOB", true);
        thread1.addMessage("not too bad", false);
        threads.add(thread1);

        Thread thread2 = new Thread(users.get(1));
        thread2.addMessage("Hi hows it going, JIM", true);
        thread2.addMessage("pretty good yo", false);
        threads.add(thread2);
    }
}
