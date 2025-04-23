package org.example.utilities.tascaS302Ex1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.utilities.tascaS302Ex1.exception.PizzaBuilderException;

public class Pizza {
	private PizzaSize size;
	private DoughType dough;
	private final List<String> toppings;
	private double price;

	public Pizza() {
		this.toppings = new ArrayList<>();
		this.price = 10.0;
	}

	public PizzaSize getSize() {
		return size;
	}

	public void setSize(PizzaSize size) {
		if (size == null) {
			throw new PizzaBuilderException("Pizza size cannot be null");
		}
		this.size = size;
		calculatePrice();
	}

	public DoughType getDough() {
		return dough;
	}

	public void setDough(DoughType dough) {
		if (dough == null) {
			throw new PizzaBuilderException("Dough type cannot be null");
		}
		this.dough = dough;
	}

	public List<String> getToppings() {
		return Collections.unmodifiableList(toppings);
	}

	public void addTopping(String topping) {
		if (topping == null || topping.trim().isEmpty()) {
			throw new PizzaBuilderException("Topping cannot be null or empty");
		}
		this.toppings.add(topping);
		calculatePrice();
	}

	public void setToppings(List<String> toppings) {
		if (toppings == null) {
			throw new PizzaBuilderException("Toppings list cannot be null");
		}
		this.toppings.clear();
		for (String topping : toppings) {
			addTopping(topping);
		}
	}

	public double getPrice() {
		return price;
	}

	private void calculatePrice() {

		double basePrice = 10.0;

		if (size != null) {
			switch (size) {
			case SMALL:
				basePrice += 0.0;
				break;
			case MEDIUM:
				basePrice += 2.0;
				break;
			case LARGE:
				basePrice += 4.0;
				break;
			case EXTRA_LARGE:
				basePrice += 6.0;
				break;
			}
		}

		basePrice += toppings.size() * 1.0;

		this.price = basePrice;
	}

	@Override
	public String toString() {
		return "Pizza [size=" + (size != null ? size.getDisplayName() : "not set") + ", dough="
				+ (dough != null ? dough.getDisplayName() : "not set") + ", toppings=" + toppings + ", price=$"
				+ String.format("%.2f", price) + "]";
	}
}