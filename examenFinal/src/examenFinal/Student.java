package examenFinal;

import java.util.ArrayList;

public abstract class Student {
	protected int id;
	protected String name;
	protected ArrayList<Integer> grades;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
		this.grades = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getGrades() {
		return grades;
	}

	public void addGrade(int grade) {
		if (grade >= 0 && grade <= 10) {
			grades.add(grade);
		} else {
			throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
		}
	}

	public abstract double calculateFinalGrade();

	public abstract String present();
		
	}

