package exercicis;
import java.util.*;

public class Modulo6Ex1 {

	public static double sum(double a, double b) {
        return a + b;
	}
        public static double substract(double a, double b) {
        	return a - b;
        }
        public static double multiply(double a, double b) {
            return a * b;
        }
        public static double divide(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("Error: División por cero!");
            }
            return a / b;
        }
        public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Ingrese el primer número: ");
		double num1 = sc.nextDouble();

		System.out.print("Ingrese el segundo número: ");
		double num2 = sc.nextDouble();

		System.out.print("Ingrese el operador (+, -, *, /): ");
		char operator = sc.next().charAt(0);

		double result = 0;

		switch (operator) {
		case '+':
			result = sum(num1, num2);
			System.out.println("Resultado: " + result);
			break;
		case '-':
			result = substract(num1, num2);
			System.out.println("Resultado: " + result);
			break;
		case '*':
			result = multiply(num1, num2);
			System.out.println("Resultado: " + result);
			break;
		case '/':
			try {
                result = divide(num1, num2);
                System.out.println("Resultado: " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
			break;
		default:
			System.out.println("Operador no válido.");
			break;
		}
		System.out.println("El resultado de " + num1 + " " + operator + " " + num2 + " = " + result);
		sc.close();
	}
}