package com.mycompany.icecreamshop;

class SyrupHandler implements IceCreamHandler {

    private IceCreamHandler next;

    @Override
    public void setNext(IceCreamHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(IceCream iceCream) {
        if (iceCream.getSyrups().isEmpty()) {
            System.out.println("Select a syrup.");
        } else if (next != null) {
            next.handleRequest(iceCream);
        }
    }
}