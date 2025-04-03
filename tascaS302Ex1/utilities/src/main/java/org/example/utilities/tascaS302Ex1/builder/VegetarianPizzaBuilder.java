package org.example.utilities.tascaS302Ex1.builder;

import org.example.utilities.tascaS302Ex1.model.Pizza;

public class VegetarianPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public VegetarianPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public PizzaBuilder setSize(String size) {
        this.pizza.setSize(size);
        return this;
    }

    @Override
    public PizzaBuilder setDough(String dough) {
        this.pizza.setDough(dough);
        return this;
    }

    @Override
    public PizzaBuilder addTopping(String topping) {
        this.pizza.addTopping(topping);
        return this;
    }

    @Override
    public Pizza build() {
        return this.pizza;
    }
    
    public void reset() {
        this.pizza = new Pizza();
        this.pizza.addTopping("Mushrooms");
        this.pizza.addTopping("Bell Peppers");
        this.pizza.addTopping("Onions");
        this.pizza.addTopping("Olives");
    }
} 