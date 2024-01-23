package com.mycompany.icecreamshop;

import java.util.List;

interface IceCream {

    String getDescription();

    double cost();

    String getFlavor();

    List<String> getToppings();
    
    List<String> getSyrups();

    void setFlavor(String flavor);

    void setToppings(List<String> toppings);

    void setSyrups(List<String> syrups);
}