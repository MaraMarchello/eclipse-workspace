package examenFinal;

public class NationalStudent extends Student {
	private String dni;

	public NationalStudent(int id, String name, String dni) {
		super(id, name);
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public double calculateFinalGrade() {
		if (grades.isEmpty())
			return 0;

		double sum = 0;
		for (int grade : grades) {
			sum += (grade >= 5) ? grade / 2.0 : grade;
		}
		return sum / grades.size();
	}

	@Override
	public String present() {
		return String.format("Me llamo %s y soy el estudiante número %d con pasaporte %s y una media de %.2f", name, id,
				dni, calculateFinalGrade());
	}
}
