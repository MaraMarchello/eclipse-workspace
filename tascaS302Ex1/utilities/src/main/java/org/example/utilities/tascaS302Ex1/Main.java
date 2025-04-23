package org.example.utilities.tascaS302Ex1;

import org.example.utilities.tascaS302Ex1.builder.HawaiianPizzaBuilder;
import org.example.utilities.tascaS302Ex1.builder.MeatPizzaBuilder;
import org.example.utilities.tascaS302Ex1.builder.VegetarianPizzaBuilder;
import org.example.utilities.tascaS302Ex1.director.MasterPizza;
import org.example.utilities.tascaS302Ex1.model.DoughType;
import org.example.utilities.tascaS302Ex1.model.Pizza;
import org.example.utilities.tascaS302Ex1.model.PizzaSize;
import org.example.utilities.tascaS302Ex1.ui.PizzaOrderUI;

public class Main {
	public static void main(String[] args) {

		useInteractiveUI();

		demonstrateBuilderPattern();
	}

	private static void demonstrateBuilderPattern() {
		System.out.println("=== Pizza Builder Pattern Demonstration ===\n");

		MeatPizzaBuilder meatPizzaBuilder = new MeatPizzaBuilder();
		VegetarianPizzaBuilder vegetarianPizzaBuilder = new VegetarianPizzaBuilder();
		HawaiianPizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();

		MasterPizza masterPizza = new MasterPizza(meatPizzaBuilder);

		Pizza smallMeatPizza = masterPizza.buildSmallPizza();
		meatPizzaBuilder.addDefaultToppings();
		System.out.println("Small Meat Pizza: " + smallMeatPizza);

		Pizza mediumMeatPizza = masterPizza.buildMediumPizza();
		meatPizzaBuilder.addDefaultToppings();
		System.out.println("Medium Meat Pizza: " + mediumMeatPizza);

		masterPizza.setPizzaBuilder(vegetarianPizzaBuilder);

		Pizza largeVegetarianPizza = masterPizza.buildSignaturePizza(PizzaSize.LARGE, DoughType.THICK);
		System.out.println("Large Vegetarian Pizza (with signature toppings): " + largeVegetarianPizza);

		Pizza customVegetarianPizza = masterPizza.buildCustomPizza(PizzaSize.MEDIUM, DoughType.WHOLE_WHEAT,
				new String[] { "Tomatoes", "Spinach", "Feta Cheese" });
		System.out.println("Custom Vegetarian Pizza: " + customVegetarianPizza);

		masterPizza.setPizzaBuilder(hawaiianPizzaBuilder);

		Pizza hawaiianPizza = masterPizza.buildSignaturePizza(PizzaSize.LARGE, DoughType.THIN);
		System.out.println("Hawaiian Pizza (with signature toppings): " + hawaiianPizza);

		Pizza customPizza = new MeatPizzaBuilder().setSize(PizzaSize.EXTRA_LARGE).setDough(DoughType.STUFFED_CRUST)
				.addTopping("Extra Cheese").addTopping("Sausage").addTopping("Ground Beef").build();
		System.out.println("Custom Pizza built directly: " + customPizza);
	}

	private static void useInteractiveUI() {
		PizzaOrderUI ui = new PizzaOrderUI();
		ui.startOrdering();
	}
}