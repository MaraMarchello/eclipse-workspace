package exercicis;

import java.util.Scanner;

public class Modulo3Ex2 {
private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {	
		
		System.out.print("Introduce primer numero: ");
        int numero1 = sc.nextInt();
        System.out.print("Introduce segundo numero: ");
        int numero2 = sc.nextInt();
        int sum = numero1 + numero2;
        int difference = numero1 - numero2;
        int product = numero1 * numero2;
        String divisionResult;
        if (numero2 != 0) {
            double division = (double) numero1 / numero2;
            divisionResult = String.valueOf(division);
        } else {
            divisionResult = "¡No se puede dividir por cero!";
        }

        System.out.println("El resultado de la suma es: " + sum);
        System.out.println("El resultado del resto es: " + difference);
        System.out.println("El resultado de la multiplicación es: " + product);
        System.out.println("El resultado de la división es: " + divisionResult);       
        
        sc.close();
	}
	}


