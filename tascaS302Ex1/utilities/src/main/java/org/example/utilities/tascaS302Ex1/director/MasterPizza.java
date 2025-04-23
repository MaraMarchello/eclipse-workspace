package org.example.utilities.tascaS302Ex1.director;

import org.example.utilities.tascaS302Ex1.builder.PizzaBuilder;
import org.example.utilities.tascaS302Ex1.model.DoughType;
import org.example.utilities.tascaS302Ex1.model.Pizza;
import org.example.utilities.tascaS302Ex1.model.PizzaSize;

public class MasterPizza {
	private PizzaBuilder pizzaBuilder;

	public MasterPizza(PizzaBuilder pizzaBuilder) {
		this.pizzaBuilder = pizzaBuilder;
	}

	public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
		this.pizzaBuilder = pizzaBuilder;
	}

	public Pizza buildSmallPizza() {
		return pizzaBuilder.reset().setSize(PizzaSize.SMALL).setDough(DoughType.THIN).build();
	}

	public Pizza buildMediumPizza() {
		return pizzaBuilder.reset().setSize(PizzaSize.MEDIUM).setDough(DoughType.REGULAR).build();
	}

	public Pizza buildLargePizza() {
		return pizzaBuilder.reset().setSize(PizzaSize.LARGE).setDough(DoughType.THICK).build();
	}

	public Pizza buildCustomPizza(PizzaSize size, DoughType dough, String[] toppings) {
		pizzaBuilder.reset().setSize(size).setDough(dough);

		for (String topping : toppings) {
			pizzaBuilder.addTopping(topping);
		}

		return pizzaBuilder.build();
	}

	public Pizza buildSignaturePizza(PizzaSize size, DoughType dough) {
		pizzaBuilder.reset().setSize(size).setDough(dough);

		try {
			pizzaBuilder.getClass().getMethod("addDefaultToppings").invoke(pizzaBuilder);
		} catch (Exception e) {

		}

		return pizzaBuilder.build();
	}
}