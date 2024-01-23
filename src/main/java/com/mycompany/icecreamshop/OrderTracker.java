package com.mycompany.icecreamshop;
// Strategy Pattern
class OrderTracker {

    void trackOrderStatus(Order order) {
        System.out.println("Current order status - " + order.getStatus());
    }
}