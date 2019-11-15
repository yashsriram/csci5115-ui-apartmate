package com.csci5115.group8.data;

import android.util.Pair;

import com.csci5115.group8.data.apartment.Apartment;
import com.csci5115.group8.data.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewManager {
    public List<Review> allReviews = new ArrayList<>();

    public boolean setReview(int apartmentId, String userEmail, int rating) {
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

    public Map<Integer, Integer> getStarCountHistogram(int apartmentId) {
        Map<Integer, Integer> starCountHistogram = new HashMap<>();
        for (Review review : allReviews) {
            if (review.apartment.id == apartmentId) {
                Integer count = starCountHistogram.get(review.rating);
                if (count == null) {
                    starCountHistogram.put(review.rating, 1);
                } else {
                    starCountHistogram.put(review.rating, count + 1);
                }
            }
        }
        // Ensure 1 - 5 ratings exist
        for (int rating = 1; rating < 6; rating++) {
            Integer count = starCountHistogram.get(rating);
            if (count == null) {
                starCountHistogram.put(rating, 0);
            }
        }
        return starCountHistogram;
    }

    public Pair<Integer, Float> getAverageRatingAndTotalReviews(int apartmentId) {
        Map<Integer, Integer> starCountHistogram = getStarCountHistogram(apartmentId);
        int total = 0;
        float weightedRating = 0;
        for (int rating = 1; rating < 6; rating++) {
            total += starCountHistogram.get(rating);
            weightedRating += rating * starCountHistogram.get(rating);
        }
        return total == 0 ? null : new Pair<>(total, weightedRating / total);
    }

}
