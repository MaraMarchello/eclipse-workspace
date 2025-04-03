package org.example.utilities.tascaS302Ex1;

import org.example.utilities.tascaS302Ex1.builder.MeatPizzaBuilder;
import org.example.utilities.tascaS302Ex1.builder.VegetarianPizzaBuilder;
import org.example.utilities.tascaS302Ex1.director.MasterPizza;
import org.example.utilities.tascaS302Ex1.model.Pizza;

public class Main {
	public static void main(String[] args) {

		MeatPizzaBuilder meatPizzaBuilder = new MeatPizzaBuilder();
		VegetarianPizzaBuilder vegetarianPizzaBuilder = new VegetarianPizzaBuilder();

		MasterPizza masterPizza = new MasterPizza(meatPizzaBuilder);

		meatPizzaBuilder.reset();
		Pizza smallMeatPizza = masterPizza.buildSmallPizza();
		System.out.println("Small Meat Pizza: " + smallMeatPizza);

		meatPizzaBuilder.reset();
		Pizza mediumMeatPizza = masterPizza.buildMediumPizza();
		System.out.println("Medium Meat Pizza: " + mediumMeatPizza);

		masterPizza.setPizzaBuilder(vegetarianPizzaBuilder);

		vegetarianPizzaBuilder.reset();
		Pizza largeVegetarianPizza = masterPizza.buildLargePizza();
		System.out.println("Large Vegetarian Pizza: " + largeVegetarianPizza);

		vegetarianPizzaBuilder.reset();
		Pizza customVegetarianPizza = masterPizza.buildCustomPizza("Medium", "Whole Wheat",
				new String[] { "Tomatoes", "Spinach", "Feta Cheese" });
		System.out.println("Custom Vegetarian Pizza: " + customVegetarianPizza);

		Pizza customPizza = new MeatPizzaBuilder().setSize("Extra Large").setDough("Stuffed Crust")
				.addTopping("Extra Cheese").addTopping("Sausage").addTopping("Ground Beef").build();
		System.out.println("Custom Pizza built directly: " + customPizza);
	}
}