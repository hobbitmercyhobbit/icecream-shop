package com.mycompany.icecreamshop;

// Observer Pattern
import java.util.Arrays;

public class IceCreamShop {
    public static void main(String[] args) {
        // Builder Pattern
        
        // Create basic ice cream with flavor and toppings
        IceCream basicIceCream = new DefaultIceCream();
        basicIceCream.setFlavor("Chocolate");
        basicIceCream.setToppings(Arrays.asList("Sprinkles", "Nuts"));
        basicIceCream.setToppings(Arrays.asList("Marshmallows", "Chocolate chips"));
        System.out.println("Toppings set " + basicIceCream.getToppings());
        
        
        
        // Add items to the order
        OrderBuilder orderBuilder = new OrderBuilder();
        orderBuilder.addItem(basicIceCream);
        
        // Add customer observer with a specific name
        OrderObserver customerOrderObserver = new CustomerOrderObserver("Mercy");
        orderBuilder.addObserver(customerOrderObserver);

        // Set delivery address, customer mobile number, quantity, and delivery method
        orderBuilder.setDeliveryAddress("Melsiripura, Kurunegala")
                .setMobileNumber("0777123456")
                .setQuantity(2)
                .chooseDelivery("Home Delivery");

        // Build the order
        Order order = orderBuilder.reviewOrder();

        // Remove an item from the order
        order.removeItem(basicIceCream);

        // Display the total cost of the order
        double totalCost = order.calculateTotal();
        System.out.println("Total Order Cost: $" + totalCost);

        // Set the order status
        order.setStatus("In Progress");

        // Execute a command to place the order
        Command placeOrderCommand = new PlaceOrderCommand(order);
        placeOrderCommand.execute();

        // Execute a command to provide feedback
        Command provideFeedbackCommand = new GiveFeedbackCommand("Excellent service!");
        provideFeedbackCommand.execute();

        // Decorate the order with gift wrapping
        Order decoratedOrder = new GiftDecorator(order);
        System.out.println("Decorated Order Description: " + decoratedOrder.getDescription());
        double decoratedTotalCost = decoratedOrder.calculateTotal();
        System.out.println("Decorated Order Total Cost: $" + decoratedTotalCost);

        // Decorate the order with special packaging
        decoratedOrder = new SpecialPackagingDecorator(decoratedOrder);
        System.out.println("Order with Special Packaging Description: " + decoratedOrder.getDescription());
        double specialPackagingTotalCost = decoratedOrder.calculateTotal();
        System.out.println("Order with Special Packaging Total Cost: $" + specialPackagingTotalCost);

        // Change the order state using the State pattern
        OrderState placedState = new PlacedState();
        placedState.processOrder(order);

        // Change the order state using the State pattern to PreparationState
        OrderState preparationState = new PreparationState();
        preparationState.processOrder(order);

        // Change the order state using the State pattern to DeliveryDetailes
        OrderState deliveryState = new DeliveryDetailes();
        deliveryState.processOrder(order);

        // Chain of Responsibility: Check the flavor and toppings
        IceCreamHandler flavorHandler = new FlavorHandler();
        IceCreamHandler toppingHandler = new ToppingHandler();
        flavorHandler.setNext(toppingHandler);

        // Create an ice cream without flavor
        IceCream iceCreamWithoutFlavor = new DefaultIceCream();
        flavorHandler.handleRequest(iceCreamWithoutFlavor);

        // Create an ice cream without toppings
        IceCream iceCreamWithoutToppings = new DefaultIceCream();
        iceCreamWithoutToppings.setFlavor("Chocolate");
        flavorHandler.handleRequest(iceCreamWithoutToppings);

        // Create an ice cream with both flavor and toppings
        IceCream iceCreamWithFlavorAndToppings = new DefaultIceCream();
        iceCreamWithFlavorAndToppings.setFlavor("Mango");
        iceCreamWithFlavorAndToppings.setToppings(Arrays.asList("Choco chips", "Caramel"));
        flavorHandler.handleRequest(iceCreamWithFlavorAndToppings);

        // Strategy Pattern: Payment using Credit Card
        PaymentMethord creditCardPayment = new CardPayment();
        creditCardPayment.pay(totalCost);

        // Strategy Pattern: Payment using Cash
        PaymentMethord cashPayment = new CashPayment();
        cashPayment.pay(decoratedTotalCost);

        // Strategy Pattern: Loyalty Program
        LoyaltyProgram loyaltyProgram = new DefaultLoyaltyProgram();
        loyaltyProgram.earnPoints(totalCost);
        int loyaltyPoints = loyaltyProgram.getPoints();
        System.out.println("Earned " + loyaltyPoints + " loyalty points.");

        // Strategy Pattern: Redeem Loyalty Points
        loyaltyProgram.redeemPoints(50);

        // Strategy Pattern: Seasonal Promotion
        PromotionManager promotionManager = new PromotionManager();
        double discountedAmount = promotionManager.applyPromotion(order);
        System.out.println("Discounted Amount after Seasonal Promotion: $" + discountedAmount);

        // Observer Pattern: Real-time order tracking
        OrderTracker orderTracker = new OrderTracker();
        orderTracker.trackOrderStatus(order);

        // Observer Pattern: Rating System
        RatingSystem ratingSystem = new FeedbackSystem() {
            @Override
            public void rateOrder(Order order, int rating) {
                super.rateOrder(order, rating);
                System.out.println("Rated order with " + rating + " stars.");
            }
        };

        // Rate the order using the Observer Pattern
        ratingSystem.rateOrder(order, 4);
        double averageRating = ratingSystem.getRating(order);
        System.out.println("Average Rating for the Order: " + averageRating + " stars");

        // Observer Pattern: Customer loyalty program update
        if (loyaltyPoints > 100) {
            System.out.println("Congratulations! You've achieved Gold status in our loyalty program.");
        }

        // Observer Pattern: Customer feedback and improvement notification
        if (averageRating < 3) {
            System.out.println("We appreciate your feedback. We'll work on improving our service.");
        } else {
            System.out.println("Thank you for your positive feedback. We're glad you enjoyed our service!");
        }
    }
}
