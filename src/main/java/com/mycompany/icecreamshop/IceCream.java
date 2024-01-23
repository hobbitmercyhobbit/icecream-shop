package com.mycompany.icecreamshop;

import java.util.List;

interface IceCream {

    String getDescription();

    double cost();

    String getFlavour();

    List<String> getToppings();
    
    List<String> getSyrups();

    void setFlavour(String flavour);

    void setToppings(List<String> toppings);

    void setSyrups(List<String> syrups);
}