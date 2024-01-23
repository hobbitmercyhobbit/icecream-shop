package com.mycompany.icecreamshop;

import java.util.ArrayList;
import java.util.List;
class Order {
    private String status;
    private int quantity;
    private final List<IceCream> items = new ArrayList<>();
    private final List<OrderObserver> observers = new ArrayList<>();
    private String deliveryAddress;
    private String customerName;
    private String feedback;
    private String mobile;

    private String deliveryMethod;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public void addItem(IceCream item) {
        items.add(item);
    }

    public void removeItem(IceCream item) {
        items.remove(item);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(IceCream::cost).sum();
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    String getDescription() {
        // Logic to generate order description
        StringBuilder description = new StringBuilder("Order with ");
        for (IceCream item : items) {
            description.append(item.getDescription()).append(", ");
        }
        return description.toString();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
