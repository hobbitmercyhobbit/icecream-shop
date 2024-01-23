package com.mycompany.icecreamshop;

abstract class OrderDecorator extends Order {

    protected Order decoratedOrder;

    public OrderDecorator(Order decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription();
    }

    @Override
    public double calculateTotal() {
        return decoratedOrder.calculateTotal();
    }
}