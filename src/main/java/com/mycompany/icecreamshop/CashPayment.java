package com.mycompany.icecreamshop;

class CashPayment implements PaymentMethord {

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs" + amount + " using cash.");
    }
}