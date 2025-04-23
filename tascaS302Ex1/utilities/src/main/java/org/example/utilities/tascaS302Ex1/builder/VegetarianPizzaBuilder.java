package org.example.utilities.tascaS302Ex1.builder;

import org.example.utilities.tascaS302Ex1.model.DoughType;
import org.example.utilities.tascaS302Ex1.model.Pizza;
import org.example.utilities.tascaS302Ex1.model.PizzaSize;

public class VegetarianPizzaBuilder implements PizzaBuilder {
	private Pizza pizza;

	public VegetarianPizzaBuilder() {
		reset();
	}

	@Override
	public PizzaBuilder setSize(PizzaSize size) {
		this.pizza.setSize(size);
		return this;
	}

	@Override
	public PizzaBuilder setDough(DoughType dough) {
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
		Pizza result = this.pizza;
		reset();
		return result;
	}

	@Override
	public PizzaBuilder reset() {
		this.pizza = new Pizza();
		return this;
	}

	public PizzaBuilder addDefaultToppings() {
		this.addTopping("Mushrooms");
		this.addTopping("Bell Peppers");
		this.addTopping("Onions");
		this.addTopping("Olives");
		return this;
	}
}