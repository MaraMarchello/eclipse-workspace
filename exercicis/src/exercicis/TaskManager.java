package exercicis;

import java.util.*;

public class TaskManager {

	private ArrayList<String> tasks;

	public TaskManager() {
        tasks = new ArrayList<>(); 
    }

	public void displayMenu() {
		System.out.println("Menú de tareas:");
		System.out.println("1. Añadir una tarea");
		System.out.println("2. Mostrar tareas");
		System.out.println("3. Eliminar tarea");
		System.out.println("4. Salir de app");
		System.out.print("Seleccione una acción: ");
	}

	public void addTask(String task) {
		tasks.add(task);
		System.out.println("Tarea añadida: " + task);
	}

	public void displayTasks() {
		if (tasks.isEmpty()) {
			System.out.println("La lista de tareas está vacía.");
		} else {
			System.out.println("Lista de tareas:");
			for (int i = 0; i < tasks.size(); i++) {
				System.out.println((i + 1) + ". " + tasks.get(i));
			}
		}
	}

	public void removeTask(int index) {
		if (index < 0 || index >= tasks.size()) {
			System.out.println("Número de tarea incorrecto.");
		} else {
			String removedTask = tasks.remove(index);
			System.out.println("Tarea eliminada: " + removedTask);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TaskManager taskManager = new TaskManager();
		boolean running = true;

		while (running) {
			taskManager.displayMenu();
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Introduzca la tarea: ");
				String task = sc.nextLine();
				taskManager.addTask(task);
				break;
			case 2:
				taskManager.displayTasks();
				break;
			case 3:
				System.out.print("Introduzca el número de tarea que desea eliminar: ");
				int taskNumber = sc.nextInt();
				taskManager.removeTask(taskNumber - 1);
				break;
			case 4:
				running = false;
				System.out.println("Salir de app");
				break;
			default:
				System.out.println("Elección incorrecta. Por favor inténtalo de nuevo.");
			}
		}

		sc.close();
	}
}
