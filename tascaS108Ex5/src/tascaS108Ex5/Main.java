package tascaS108Ex5;

@FunctionalInterface
interface MathConstant {
	double getValue();

	default double getValue(int precision) {
		double value = getValue();
		double scale = Math.pow(10, precision);
		return Math.round(value * scale) / scale;
	}
}

public class Main {

	private static final double PI = Math.PI;

	public static void main(String[] args) {

		MathConstant pi = () -> PI;

		System.out.printf("Pi value (default): %.6f%n", pi.getValue());
		System.out.printf("Pi value (2 decimals): %.2f%n", pi.getValue(2));
		System.out.printf("Pi value (4 decimals): %.4f%n", pi.getValue(4));
	}
}