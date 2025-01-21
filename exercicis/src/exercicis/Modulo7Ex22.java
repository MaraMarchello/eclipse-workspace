package exercicis;

import java.util.*;

public class Modulo7Ex22 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de líneas: ");
        int lines = sc.nextInt();

        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
                if (j < i) {
                    System.out.print(" "); 
            }
            System.out.println(); 
        
        sc.close();
    }
}
	}
}