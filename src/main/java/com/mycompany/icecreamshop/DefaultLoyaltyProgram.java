package com.mycompany.icecreamshop;
// Strategy Pattern
class DefaultLoyaltyProgram implements LoyaltyProgram {

    private int loyaltyPoints;

    @Override
    public void earnPoints(double amount) {

        loyaltyPoints += (int) amount / 10;
    }

    @Override
    public int getPoints() {
        return loyaltyPoints;
    }

    @Override
    public void redeemPoints(int points) {

        System.out.println("Redeeming " + points + " points.");
    }
}