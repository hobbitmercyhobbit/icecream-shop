package com.mycompany.icecreamshop;

import java.util.HashMap;
import java.util.Map;

class PromotionManager {

    private final Map<String, Promotion> promotions;

    PromotionManager() {
        promotions = new HashMap<>();
        // Initialize seasonal promotions
        promotions.put("Summer", amount -> amount * 0.9); // 10% off for summer
    }

    double applyPromotion(Order order) {
        // Logic to apply seasonal promotion based on the current season
        Promotion promotion = promotions.get("Summer"); // Get the current season's promotion
        return promotion != null ? promotion.applyPromotion(order.calculateTotal()) : order.calculateTotal();
    }
}