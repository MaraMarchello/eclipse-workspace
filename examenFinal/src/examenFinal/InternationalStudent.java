package examenFinal;

public class InternationalStudent extends Student {
	private String passport;

	public InternationalStudent(int id, String name, String passport) {
		super(id, name);
		this.passport = passport;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	@Override
	public double calculateFinalGrade() {
		if (grades.isEmpty())
			return 0;

		double sum = 0;
		for (int grade : grades) {
			sum += (grade % 2 == 0) ? grade * 2 : grade / 2.0;
		}
		return sum / grades.size();
	}

	@Override
	public String present() {
		return String.format("Me llamo %s y soy el estudiante número %d con pasaporte %s y una media de %.2f", name, id,
				passport, calculateFinalGrade());
	}
}
