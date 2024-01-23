package com.mycompany.icecreamshop;

class ToppingHandler implements IceCreamHandler {

    private IceCreamHandler next;

    @Override
    public void setNext(IceCreamHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(IceCream iceCream) {
        if (iceCream.getToppings().isEmpty()) {
            System.out.println("Select at least one topping.");
        } else if (next != null) {
            next.handleRequest(iceCream);
        }
    }
}