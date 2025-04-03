package org.example.utilities.tascaS302Ex1.director;

import org.example.utilities.tascaS302Ex1.builder.PizzaBuilder;
import org.example.utilities.tascaS302Ex1.model.Pizza;

public class MasterPizza {
    private PizzaBuilder pizzaBuilder;

    public MasterPizza(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza buildSmallPizza() {
        return pizzaBuilder
                .setSize("Small")
                .setDough("Thin")
                .build();
    }

    public Pizza buildMediumPizza() {
        return pizzaBuilder
                .setSize("Medium")
                .setDough("Regular")
                .build();
    }

    public Pizza buildLargePizza() {
        return pizzaBuilder
                .setSize("Large")
                .setDough("Thick")
                .build();
    }

    public Pizza buildCustomPizza(String size, String dough, String[] toppings) {
        pizzaBuilder.setSize(size).setDough(dough);
        
        for (String topping : toppings) {
            pizzaBuilder.addTopping(topping);
        }
        
        return pizzaBuilder.build();
    }
} 