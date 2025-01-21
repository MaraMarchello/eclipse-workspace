package exercicis;

import java.util.Scanner;

public class Modulo7Ex26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isPrime = false;

        while (!isPrime) {  
            System.out.println("Escoge un número: ");
            int n = sc.nextInt();

            if (n > 1) {
            	isPrime = isPrime(n);
                if (isPrime) {
                    System.out.println("Exacto, ¡el número " + n + " es primo!");
                }
            } else {
                System.out.println("Por favor, escoge un número mayor que 1.");
            }
        }

        sc.close(); 
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false; // Проверяем случай для n <= 1
        for (int i = 2; i <= Math.sqrt(n); i++) { // Проверяем до корня из n
            if (n % i == 0) {
                return false; // Если делится без остатка, не простое
            }
        }
        return true; // Если не нашли делителей, то простое
    }
}
