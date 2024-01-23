package com.mycompany.icecreamshop;

class GiftDecorator extends OrderDecorator {
    private final double decorationRate = 5.0;

    public GiftDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Gift Wrapping";
    }

    @Override
    public double calculateTotal() {
        return super.calculateTotal() + decorationRate;
    }
}