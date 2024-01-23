package com.mycompany.icecreamshop;
// Strategy Pattern
interface LoyaltyProgram {

    void earnPoints(double amount);

    int getPoints();

    void redeemPoints(int points);
}