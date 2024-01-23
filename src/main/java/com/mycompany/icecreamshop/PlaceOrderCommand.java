package com.mycompany.icecreamshop;

class PlaceOrderCommand implements Command {

    private final Order order;

    public PlaceOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println("Placing order...");
        order.setStatus("Placed");
    }
}