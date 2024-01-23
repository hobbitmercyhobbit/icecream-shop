package com.mycompany.icecreamshop;

// Observer Pattern
interface RatingSystem {

    void rateOrder(Order order, int rating);

    double getRating(Order order);
}
