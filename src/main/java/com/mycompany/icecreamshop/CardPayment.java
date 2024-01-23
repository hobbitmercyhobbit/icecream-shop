package com.mycompany.icecreamshop;

class CardPayment implements PaymentMethord {

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs " + amount + " with a credit card.");
    }
}