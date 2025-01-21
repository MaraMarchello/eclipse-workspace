package exercicis;

import java.util.ArrayList;
import java.util.List;

class BuildingManager {
    private List<Edificios> buildings;

    public BuildingManager() {
        buildings = new ArrayList<>();
    }

    public void addBuilding(Edificios building) {
        buildings.add(building);
    }

    public void showBuildings() {
        for (Edificios building : buildings) {
            building.showDetails();
            System.out.println("--------------------------------");
        }
    }

    public void removeBuilding(Edificios building) {
        buildings.remove(building);
    }
}
public class Main8Ex4 {
    public static void main(String[] args) {
        BuildingManager manager = new BuildingManager();

        manager.addBuilding(hotel);
        manager.addBuilding(hospital);
        manager.addBuilding(cinema);

        manager.showBuildings();

        // Пример использования метода кинотеатра
        cinema.projectSession(250, 10.0);

        // Удаление здания (например, отеля)
        manager.removeBuilding(hotel);
        System.out.println("После удаления отеля:");
        manager.showBuildings();
    }
}