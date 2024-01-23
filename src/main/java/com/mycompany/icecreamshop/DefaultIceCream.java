package com.mycompany.icecreamshop;

import java.util.ArrayList;
import java.util.List;

class DefaultIceCream implements IceCream {

    private String flavor;
    private final List<String> toppings = new ArrayList<>();
    private final List<String> syrups = new ArrayList<>();

    @Override
    public List<String> getSyrups() {
        return syrups;
    }

    @Override
    public String getDescription() {
        return "Default Ice Cream";
    }

    @Override
    public double cost() {
        return 2.0;
    }

    @Override
    public String getFlavor() {
        return flavor;
    }

    @Override
    public List<String> getToppings() {
        return toppings;
    }

    @Override
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public void setToppings(List<String> toppings) {
        this.toppings.clear();
        this.toppings.addAll(toppings);
    }

    @Override
    public void setSyrups(List<String> syrups) {
        this.syrups.clear();
        this.syrups.addAll(syrups);
    }
}