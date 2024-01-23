package com.mycompany.icecreamshop;

// Observer Pattern
import java.util.Arrays;

public class IceCreamShop {
    public static void main(String[] args) {

        IceCream basicIceCream = new DefaultIceCream();
        basicIceCream.setFlavour("Chocolate");
        basicIceCream.setToppings(Arrays.asList("Marshmallows", "Chocolate chips"));
        basicIceCream.setSyrups(Arrays.asList("Sprinkles", "Mint Syrup"));
        
        System.out.println("***");
        System.out.println("Selected Flavour '" + basicIceCream.getFlavour() + "'");
        System.out.println("Selected Toppings '" + basicIceCream.getToppings() + "'");
        System.out.println("Selected Syrups '" + basicIceCream.getSyrups() + "'");
        System.out.println("***");

        // builder pattern
        OrderBuilder orderBuilder = new OrderBuilder();
        orderBuilder.addItem(basicIceCream);

        // observer pattern
        OrderObserver customerOrderObserver = new CustomerOrderObserver("Karunai");
        orderBuilder.addObserver(customerOrderObserver);

        orderBuilder.setDeliveryAddress("Palaya Kadai, Colombo la than")
                .setMobileNumber("0777123456")
                .setQuantity(2)
                .chooseDelivery("Normal Delivery");

        Order order = orderBuilder.reviewOrder();

        double totalCost = order.calculateTotal();
        System.out.println("Order Total : Rs " + totalCost);

        order.setStatus("in-progress");
        // command pattern
        Command placeOrderCommand = new PlaceOrderCommand(order);
        placeOrderCommand.execute();

        Command provideFeedbackCommand = new GiveFeedbackCommand("Nalla thunnen, nalaikkum varuven");
        provideFeedbackCommand.execute();

        // decorator pattern
        Order decoratedOrder = new GiftDecorator(order);
        double decoratedTotalCost = decoratedOrder.calculateTotal();
        System.out.println("Decorated Order Total : Rs " + decoratedTotalCost);

        decoratedOrder = new SpecialPackagingDecorator(decoratedOrder);
        double specialPackagingTotalCost = decoratedOrder.calculateTotal();
        System.out.println("Order with Special Packaging Total : Rs " + specialPackagingTotalCost);

        // state pattern
        OrderState placedState = new PlacedState();
        placedState.processOrder(order);

        // Change the order state using the State pattern to PreparationState
        OrderState preparationState = new PreparationState();
        preparationState.processOrder(order);

        // Change the order state using the State pattern to DeliveryDetailes
        OrderState deliveryState = new DeliveryDetailes();
        deliveryState.processOrder(order);

        // chain of responsibility pattern
        IceCreamHandler flavourHandler = new FlavourHandler();
        IceCreamHandler toppingHandler = new ToppingHandler();
        IceCreamHandler syrupHandler = new SyrupHandler();
        flavourHandler.setNext(toppingHandler);
        toppingHandler.setNext(syrupHandler);

        IceCream flavourlessIceCream = new DefaultIceCream();
        flavourHandler.handleRequest(flavourlessIceCream);

        IceCream toppinglessIceCream = new DefaultIceCream();
        toppinglessIceCream.setFlavour("Vera Chocolate");
        flavourHandler.handleRequest(toppinglessIceCream);

        // strategypPattern
        PaymentMethord creditCardPayment = new CardPayment();
        creditCardPayment.pay(totalCost);

        LoyaltyProgram loyaltyProgram = new DefaultLoyaltyProgram();
        loyaltyProgram.earnPoints(totalCost);
        int loyaltyPoints = loyaltyProgram.getPoints();
        System.out.println("You go " + loyaltyPoints + " points.");

        loyaltyProgram.redeemPoints(13);

        // observer pattern
        OrderTracker orderTracker = new OrderTracker();
        orderTracker.trackOrderStatus(order);

    }
}
