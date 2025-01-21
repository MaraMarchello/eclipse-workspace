package exercicis;
import java.util.Scanner;

public class Modulo6Ex2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el número de personas: ");
        int numberOfPeople = sc.nextInt();

        if (numberOfPeople <= 0) {
            System.out.println("El número de personas debe ser mayor que cero.");
        } else {
            double averageAge = calculateAverageAge(numberOfPeople);
            System.out.printf("Edad media: %.2f años%n", averageAge);
        }
        
        sc.close();
    }

    public static double calculateAverageAge(int numberOfPeople) {
        Scanner sc = new Scanner(System.in);
        int totalAge = 0;

        for (int i = 1; i <= numberOfPeople; i++) {
            int age;
            while (true) {
                System.out.print("Ingrese la edad de la persona " + i + ": ");
                age = sc.nextInt();
                if (age >= 0 && age <= 120) {
                    break;
                } else {
                    System.out.println("Error: La edad debe estar entre 0 y 120 años. Intentar otra vez.");
                }
            }
            totalAge += age;
        }

        return (double) totalAge / numberOfPeople;
    }
}