package com.mycompany.icecreamshop;

interface IceCreamHandler {

    void handleRequest(IceCream iceCream);

    void setNext(IceCreamHandler iceCreamHandler);
}