
public class CalculoDni {
    private static final String DNI_LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";

    public char calculateLetter(int dniNumber) {
        if (dniNumber < 0) {
            throw new IllegalArgumentException("DNI number cannot be negative");
        }
        int index = dniNumber % 23;
        return DNI_LETTERS.charAt(index);
    }

    public boolean validateDni(String completeDni) {
        if (completeDni == null || completeDni.length() != 9) {
            return false;
        }

        try {
            String numberPart = completeDni.substring(0, 8);
            char letterPart = completeDni.charAt(8);
            int dniNumber = Integer.parseInt(numberPart);
            return calculateLetter(dniNumber) == Character.toUpperCase(letterPart);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
