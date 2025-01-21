package examenFinal;

public class CourseManagement {
	public static void main(String[] args) {
		try {
			
			Course course = new Course("Fundamentals of Programming");
			
			NationalStudent marc = new NationalStudent(1, "Marc", "12345678A");
			NationalStudent laia = new NationalStudent(2, "Laia", "98765432B");
			InternationalStudent peter = new InternationalStudent(3, "Peter", "ABC123456");
			InternationalStudent kate = new InternationalStudent(4, "Kate", "DEF654321");
			
			course.addStudent(marc);
			course.addStudent(laia);
			course.addStudent(peter);
			course.addStudent(kate);
			
			course.showStudentNames();
			
			int[] marcGrades = { 1, 3, 5, 7, 9 };
			int[] laiaGrades = { 2, 4, 6, 8, 10 };
			int[] peterGrades = { 1, 2, 5, 6, 9, 10 };
			int[] kateGrades = { 3, 4, 7, 8 };

			for (int grade : marcGrades)
				marc.addGrade(grade);
			for (int grade : laiaGrades)
				laia.addGrade(grade);
			for (int grade : peterGrades)
				peter.addGrade(grade);
			for (int grade : kateGrades)
				kate.addGrade(grade);
			
			System.out.println("\nPresentaciones de los alumnos y notas finales:");
			course.getStudents().forEach(s -> System.out.println(s.present()));
		
			course.removeStudent(1);
			
			peter.setName("Jason");
		
			course.showStudentNames();

		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
