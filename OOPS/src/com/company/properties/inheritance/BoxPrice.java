package com.company.properties.inheritance;

public class BoxPrice extends boxWeight{

    double cost;

    BoxPrice() {
        super();
        this.cost = -1;
    }

    BoxPrice(BoxPrice other) {
        super(other);

    }

    public BoxPrice(double side, double weight, double cost) {
        super(side,weight );
        this.cost = cost;
    }
}
