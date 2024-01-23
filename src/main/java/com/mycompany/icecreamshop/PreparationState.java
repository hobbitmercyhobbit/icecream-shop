package com.mycompany.icecreamshop;

class PreparationState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("Order is being prepared.");
        order.setStatus("In Preparation");
    }
}