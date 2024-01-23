package com.mycompany.icecreamshop;

class OrderBuilder {

    private final Order order = new Order();

    public OrderBuilder addItem(IceCream item) {
        order.addItem(item);
        return this;
    }

    public OrderBuilder addObserver(OrderObserver observer) {
        order.addObserver(observer);
        return this;
    }

    public OrderBuilder setDeliveryAddress(String deliveryAddress) {
        order.setDeliveryAddress(deliveryAddress);
        System.out.println("Delivery addess set " + deliveryAddress);
        return this;
    }

    public OrderBuilder setMobileNumber(String customerMobileNumber) {
        order.setMobile(customerMobileNumber);
        System.out.println("Customer Mobile Number set " + customerMobileNumber);
        return this;
    }

    public OrderBuilder setQuantity(int quantity) {
        order.setQuantity(quantity);
        System.out.println("Quantity : " + quantity);
        return this;
    }

    public OrderBuilder choosePickup() {
        order.setDeliveryMethod("Pickup");
        return this;
    }

    public OrderBuilder chooseDelivery(String deliveryAddress) {
        order.setDeliveryMethod("Delivery");
        order.setDeliveryAddress(deliveryAddress);
        return this;

    }

    public Order reviewOrder() {
        return order;
    }
}