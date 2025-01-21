package exercicis;

abstract class Building {
	private String name;
	private int floors;
	private double area;

	public Building(String name, int floors, double area) {
		this.name = name;
		this.floors = floors;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public int getFloors() {
		return floors;
	}

	public double getArea() {
		return area;
	}

	public void clean() {
		double cleaningTime = area / 5;
		if (floors > 1) {
			cleaningTime += (floors - 1) * 0.5; // Подъем между этажами
		}
		double monthlyCost = cleaningTime * 30; // Ежемесячная стоимость
		System.out.printf("Уборка здания: %.2f минут, месячная стоимость: %.2f евро%n", cleaningTime, monthlyCost);
	}

	public abstract double calculateCostSurveillance();
}

class Hotel extends Building {
	private int roomCount;

	public Hotel(String name, int floors, double area, int roomCount) {
		super(name, floors, area);
		this.roomCount = roomCount;
	}

	@Override
	public double calculateCostSurveillance() {
		int guardsNeeded = (int) Math.ceil(getArea() / 1000);
		double guardCost = guardsNeeded * (1300 + 500); // Премия за опасность
		return guardCost;
	}

	public void roomService() {
		int staffNeeded = (int) Math.ceil((double) roomCount / 20);
		double staffCost = staffNeeded * 1000; // зарплата
		System.out.printf("Нужно %d сотрудника(ов) для обслуживания номеров. Общая зарплата: %.2f евро%n", staffNeeded,
				staffCost);
	}
}

class Hospital extends Building {
	private int patientCount;

	public Hospital(String name, int floors, double area, int patientCount) {
		super(name, floors, area);
		this.patientCount = patientCount;
	}

	@Override
	public double calculateCostSurveillance() {
		int guardsNeeded = (int) Math.ceil(getArea() / 1000);
		double guardCost = guardsNeeded * 1300; // Без премии
		return guardCost;
	}

	public void deliverLunch() {
		System.out.printf("%d пайки доставляются.%n", patientCount * 3);
	}

	public void setPatientCount(int patientCount) {
		this.patientCount = patientCount;
	}

	public int getPatientCount() {
		return patientCount;
	}
}

class Cinema extends Building {
	private int capacity;

	public Cinema(String name, int floors, double area, int capacity) {
		super(name, floors, area);
		this.capacity = capacity;
	}

	@Override
	public double calculateCostSurveillance() {
		int guardsNeeded = (int) Math.ceil(getArea() / 3000);
		return guardsNeeded * 1300; // зарплата охранника
	}

	public void projectSession(int attendees, double ticketPrice) {
		if (attendees > capacity) {
			attendees = capacity;
		}
		double totalIncome = attendees * ticketPrice;
		System.out.printf("%.2f евро собрано.%n", totalIncome);
	}
}
public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hilton", 5, 3000, 100); // 100 комнат
        hotel.clean();
        System.out.println("Стоимость охраны: " + hotel.calculateCostSurveillance() + " евро");
        hotel.roomService();

        Hospital hospital = new Hospital("City Hospital", 10, 5000, 50); // 50 пациентов
        hospital.clean();
        System.out.println("Стоимость охраны: " + hospital.calculateCostSurveillance() + " евро");
        hospital.deliverLunch();
        hospital.setPatientCount(60); // Изменяется количество пациентов
        hospital.deliverLunch();

        Cinema cinema = new Cinema("Grand Cinema", 3, 2000, 200); // Вместимость 200 человек
        cinema.clean();
        System.out.println("Стоимость охраны: " + cinema.calculateCostSurveillance() + " евро");
        cinema.projectSession(180, 10); // 180 участников, цена билета 10 евро
    }
}