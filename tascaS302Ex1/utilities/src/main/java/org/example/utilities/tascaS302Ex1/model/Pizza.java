package org.example.utilities.tascaS302Ex1.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String size;
    private String dough;
    private List<String> toppings;

    public Pizza() {
        this.toppings = new ArrayList<>();
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void addTopping(String topping) {
        this.toppings.add(topping);
    }

    public void setToppings(List<String> toppings) {
        this.toppings = new ArrayList<>(toppings);
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", dough=" + dough + ", toppings=" + toppings + "]";
    }
} 