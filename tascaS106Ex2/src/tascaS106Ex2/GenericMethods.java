package tascaS106Ex2;

public class GenericMethods {

	public <T1, T2, T3> void printThreeArguments(T1 arg1, T2 arg2, T3 arg3) {
		System.out.println("Argument 1: " + arg1 + " (Type: " + arg1.getClass().getSimpleName() + ")");
		System.out.println("Argument 2: " + arg2 + " (Type: " + arg2.getClass().getSimpleName() + ")");
		System.out.println("Argument 3: " + arg3 + " (Type: " + arg3.getClass().getSimpleName() + ")");
		System.out.println("--------------------");
	}
}
