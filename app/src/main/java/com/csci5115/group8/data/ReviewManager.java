package com.csci5115.group8.data;

import com.csci5115.group8.data.apartment.Apartment;
import com.csci5115.group8.data.user.User;

import java.util.List;

public class ReviewManager {
    public List<Review> reviews;

    public boolean setReview(int apartmentId, String userEmail, float rating) {
        for (Review review : reviews) {
            if (review.apartment.id == apartmentId && review.user.email.equals(userEmail)) {
                review.rating = rating;
                return true;
            }
        }
        Apartment apartment = DataManager.getApartment(apartmentId);
        User user = DataManager.getInstance().users.get(userEmail);
        if (apartment != null && user != null) {
            reviews.add(new Review(user, apartment, rating));
            return true;
        }

        return false;
    }
}
