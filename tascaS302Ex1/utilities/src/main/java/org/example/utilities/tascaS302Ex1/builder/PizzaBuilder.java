package org.example.utilities.tascaS302Ex1.builder;

import org.example.utilities.tascaS302Ex1.model.Pizza;

public interface PizzaBuilder {
    PizzaBuilder setSize(String size);
    PizzaBuilder setDough(String dough);
    PizzaBuilder addTopping(String topping);
    Pizza build();
} 