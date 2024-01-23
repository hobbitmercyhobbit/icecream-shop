package com.mycompany.icecreamshop;

class DeliveryDetailes implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("Your order is out for delivery.");
        order.setStatus("Out for Delivery");
    }
}