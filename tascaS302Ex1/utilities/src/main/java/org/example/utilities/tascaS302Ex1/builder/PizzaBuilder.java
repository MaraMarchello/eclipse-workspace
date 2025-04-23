package org.example.utilities.tascaS302Ex1.builder;

import org.example.utilities.tascaS302Ex1.model.DoughType;
import org.example.utilities.tascaS302Ex1.model.Pizza;
import org.example.utilities.tascaS302Ex1.model.PizzaSize;

public interface PizzaBuilder {

	PizzaBuilder setSize(PizzaSize size);

	PizzaBuilder setDough(DoughType dough);

	PizzaBuilder addTopping(String topping);

	Pizza build();

	PizzaBuilder reset();
}