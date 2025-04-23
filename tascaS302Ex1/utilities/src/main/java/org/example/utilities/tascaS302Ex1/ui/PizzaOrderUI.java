package org.example.utilities.tascaS302Ex1.ui;

import java.util.Scanner;

import org.example.utilities.tascaS302Ex1.builder.HawaiianPizzaBuilder;
import org.example.utilities.tascaS302Ex1.builder.MeatPizzaBuilder;
import org.example.utilities.tascaS302Ex1.builder.PizzaBuilder;
import org.example.utilities.tascaS302Ex1.builder.VegetarianPizzaBuilder;
import org.example.utilities.tascaS302Ex1.director.MasterPizza;
import org.example.utilities.tascaS302Ex1.exception.PizzaBuilderException;
import org.example.utilities.tascaS302Ex1.model.DoughType;
import org.example.utilities.tascaS302Ex1.model.Pizza;
import org.example.utilities.tascaS302Ex1.model.PizzaSize;


public class PizzaOrderUI {
    private Scanner scanner;
    private MasterPizza director;
    private PizzaBuilder currentBuilder;

    public PizzaOrderUI() {
        scanner = new Scanner(System.in);
        currentBuilder = new MeatPizzaBuilder(); 
        director = new MasterPizza(currentBuilder);
    }

    
    public void startOrdering() {
        boolean exit = false;

        System.out.println("=== Welcome to Pizza Builder System ===");

        while (!exit) {
            try {
                System.out.println("\nMenu Options:");
                System.out.println("1. Order predefined pizza");
                System.out.println("2. Build custom pizza");
                System.out.println("3. Exit");
                System.out.print("Select an option: ");

                int option = Integer.parseInt(scanner.nextLine().trim());

                switch (option) {
                    case 1:
                        orderPredefinedPizza();
                        break;
                    case 2:
                        buildCustomPizza();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (PizzaBuilderException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        System.out.println("Thank you for using Pizza Builder System!");
        scanner.close();
    }

    private void orderPredefinedPizza() {
        selectPizzaType();

        System.out.println("\nPredefined Pizza Options:");
        System.out.println("1. Small Thin Crust");
        System.out.println("2. Medium Regular Crust");
        System.out.println("3. Large Thick Crust");
        System.out.println("4. Signature Pizza (with default toppings)");
        System.out.print("Select an option: ");

        int option = Integer.parseInt(scanner.nextLine().trim());
        Pizza pizza = null;

        switch (option) {
            case 1:
                pizza = director.buildSmallPizza();
                break;
            case 2:
                pizza = director.buildMediumPizza();
                break;
            case 3:
                pizza = director.buildLargePizza();
                break;
            case 4:
                PizzaSize size = selectSize();
                DoughType dough = selectDough();
                pizza = director.buildSignaturePizza(size, dough);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                return;
        }

        displayOrder(pizza);
    }

    private void buildCustomPizza() {
        selectPizzaType();

        PizzaSize size = selectSize();
        DoughType dough = selectDough();
        String[] toppings = selectToppings();

        Pizza pizza = director.buildCustomPizza(size, dough, toppings);
        displayOrder(pizza);
    }

    private void selectPizzaType() {
        System.out.println("\nSelect Pizza Type:");
        System.out.println("1. Meat Pizza");
        System.out.println("2. Vegetarian Pizza");
        System.out.println("3. Hawaiian Pizza");
        System.out.print("Select an option: ");

        int option = Integer.parseInt(scanner.nextLine().trim());

        switch (option) {
            case 1:
                currentBuilder = new MeatPizzaBuilder();
                break;
            case 2:
                currentBuilder = new VegetarianPizzaBuilder();
                break;
            case 3:
                currentBuilder = new HawaiianPizzaBuilder();
                break;
            default:
                System.out.println("Invalid option. Using default Meat Pizza Builder.");
                currentBuilder = new MeatPizzaBuilder();
        }

        director.setPizzaBuilder(currentBuilder);
    }

    private PizzaSize selectSize() {
        System.out.println("\nSelect Pizza Size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        System.out.println("4. Extra Large");
        System.out.print("Select an option: ");

        int option = Integer.parseInt(scanner.nextLine().trim());

        switch (option) {
            case 1:
                return PizzaSize.SMALL;
            case 2:
                return PizzaSize.MEDIUM;
            case 3:
                return PizzaSize.LARGE;
            case 4:
                return PizzaSize.EXTRA_LARGE;
            default:
                System.out.println("Invalid option. Using Medium size as default.");
                return PizzaSize.MEDIUM;
        }
    }

    private DoughType selectDough() {
        System.out.println("\nSelect Dough Type:");
        System.out.println("1. Thin");
        System.out.println("2. Regular");
        System.out.println("3. Thick");
        System.out.println("4. Stuffed Crust");
        System.out.println("5. Whole Wheat");
        System.out.println("6. Gluten Free");
        System.out.print("Select an option: ");

        int option = Integer.parseInt(scanner.nextLine().trim());

        switch (option) {
            case 1:
                return DoughType.THIN;
            case 2:
                return DoughType.REGULAR;
            case 3:
                return DoughType.THICK;
            case 4:
                return DoughType.STUFFED_CRUST;
            case 5:
                return DoughType.WHOLE_WHEAT;
            case 6:
                return DoughType.GLUTEN_FREE;
            default:
                System.out.println("Invalid option. Using Regular dough as default.");
                return DoughType.REGULAR;
        }
    }

    private String[] selectToppings() {
        System.out.println("\nEnter toppings separated by commas (or leave empty to finish): ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            return new String[0];
        }

        return input.split("\\s*,\\s*");
    }

    private void displayOrder(Pizza pizza) {
        System.out.println("\n=== Your Pizza Order ===");
        System.out.println(pizza);
        System.out.println("======================");
    }
} 