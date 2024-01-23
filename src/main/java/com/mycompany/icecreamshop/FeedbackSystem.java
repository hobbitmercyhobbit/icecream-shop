package com.mycompany.icecreamshop;

import java.util.HashMap;
import java.util.Map;

abstract class FeedbackSystem implements RatingSystem {

    private final Map<Order, Integer> orderRatings;

    FeedbackSystem() {
        orderRatings = new HashMap<>();
    }

    @Override
    public void rateOrder(Order order, int rating) {
        orderRatings.put(order, rating);
    }

    @Override
    public double getRating(Order order) {
        return orderRatings.getOrDefault(order, 0);
    }
}
