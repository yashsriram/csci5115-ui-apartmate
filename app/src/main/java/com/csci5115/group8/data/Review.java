package com.csci5115.group8.data;

import com.csci5115.group8.data.apartment.Apartment;
import com.csci5115.group8.data.user.User;

import java.util.HashMap;
import java.util.Map;

public class Review {
    public User user;
    public Apartment apartment;
    public int rating;

    public Review(User user, Apartment apartment, int rating) {
        this.user = user;
        this.apartment = apartment;
        this.rating = rating;
    }
}
