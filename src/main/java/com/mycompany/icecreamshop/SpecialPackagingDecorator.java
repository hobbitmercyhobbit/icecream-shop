package com.mycompany.icecreamshop;

class SpecialPackagingDecorator extends OrderDecorator {

    public SpecialPackagingDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Special Packaging";
    }

    @Override
    public double calculateTotal() {
        return super.calculateTotal() + 1.5;
    }
}