package examenFinal;

import java.util.ArrayList;

public class Course {
	private String name;
	private ArrayList<Student> students;

	public Course(String name) {
		this.name = name;
		this.students = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre del curso no puede estar vacío");
		}
		this.name = name.trim();
	}

	public ArrayList<Student> getStudents() {
		return new ArrayList<>(students);
	}

	public void addStudent(Student student) {
		if (student == null) {
			throw new IllegalArgumentException("El estudiante no puede ser null");
		}

		boolean duplicateId = students.stream().anyMatch(s -> s.getId() == student.getId());

		if (duplicateId) {
			throw new IllegalArgumentException("Ya existe un estudiante con ID: " + student.getId());
		}

		students.add(student);
	}

	public void removeStudent(int id) {
		boolean removed = students.removeIf(s -> s.getId() == id);
		if (!removed) {
			throw new IllegalArgumentException("Estudiante con ID " + id + " no encontrado");
		}
	}

	public void showStudentNames() {
		if (students.isEmpty()) {
			System.out.println("\nNo hay estudiantes en el curso " + name);
			return;
		}

		System.out.println("\nEstudiantes del curso " + name + ":");
		students.forEach(s -> System.out.println("- " + s.getName()));
	}

	public int getStudentCount() {
		return students.size();
	}

	public Student findStudent(int id) {
		return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
	}

	public double getAverageGrade() {
		if (students.isEmpty()) {
			return 0.0;
		}

		return students.stream().mapToDouble(Student::calculateFinalGrade).average().orElse(0.0);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Curso: ").append(name).append("\nNúmero de estudiantes: ").append(students.size())
				.append("\nPromedio general: ").append(String.format("%.2f", getAverageGrade()));

		return sb.toString();
	}
}