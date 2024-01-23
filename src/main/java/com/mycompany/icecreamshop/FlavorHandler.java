package com.mycompany.icecreamshop;

class FlavorHandler implements IceCreamHandler {

    private IceCreamHandler next;

    @Override
    public void setNext(IceCreamHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(IceCream iceCream) {
        if (iceCream.getFlavor() == null) {
            System.out.println("Select a flavor.");
        } else if (next != null) {
            next.handleRequest(iceCream);
        }
    }
}