package com.mycompany.icecreamshop;

class PlacedState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("Order placed.");
        order.setStatus("Placed");
    }
}