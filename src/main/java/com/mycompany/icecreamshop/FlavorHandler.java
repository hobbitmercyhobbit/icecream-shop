package com.mycompany.icecreamshop;

class FlavourHandler implements IceCreamHandler {

    private IceCreamHandler next;

    @Override
    public void setNext(IceCreamHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(IceCream iceCream) {
        if (iceCream.getFlavour() == null) {
            System.out.println("Select a flavour.");
        } else if (next != null) {
            next.handleRequest(iceCream);
        }
    }
}