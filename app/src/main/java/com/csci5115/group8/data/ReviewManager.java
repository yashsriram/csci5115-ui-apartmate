package com.csci5115.group8.data;

import com.csci5115.group8.data.apartment.Apartment;
import com.csci5115.group8.data.user.User;

import java.util.ArrayList;
import java.util.List;

public class ReviewManager {
    public List<Review> allReviews = new ArrayList<>();

    public boolean setReview(int apartmentId, String userEmail, float rating) {
        for (Review review : allReviews) {
            if (review.apartment.id == apartmentId && review.user.email.equals(userEmail)) {
                review.rating = rating;
                return true;
            }
        }
        Apartment apartment = DataManager.getApartment(apartmentId);
        User user = DataManager.getUser(userEmail);
        if (apartment != null && user != null) {
            allReviews.add(new Review(user, apartment, rating));
            return true;
        }

        return false;
    }

    public float getReview(int apartmentId, String userEmail) {
        for (Review review : allReviews) {
            if (review.apartment.id == apartmentId && review.user.email.equals(userEmail)) {
                return review.rating;
            }
        }
        return 0f;
    }

    public List<Review> getReviews(int apartmentId) {
        List<Review> reviews = new ArrayList<>();
        for (Review review : allReviews) {
            if (review.apartment.id == apartmentId) {
                reviews.add(review);
            }
        }
        return reviews;
    }

}
