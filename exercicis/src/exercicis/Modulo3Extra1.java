package exercicis;

import java.util.Scanner;

public class Modulo3Extra1 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	
		System.out.print("Introduce un numero: "); 
        int number = sc.nextInt(); 

        int doubled = number * 2; 
        int tripled = number * 3; 

        System.out.println("El doble: " + doubled);
        System.out.println("El triple: " + tripled);
        
        sc.close(); 
    }
}	

