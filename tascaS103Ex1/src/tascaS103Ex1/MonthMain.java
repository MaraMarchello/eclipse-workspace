package tascaS103Ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MonthMain {
    private static List<Month> createMonthList() {
        ArrayList<Month> monthList = new ArrayList<>();
        monthList.add(new Month("January"));
        monthList.add(new Month("February"));
        monthList.add(new Month("March"));
        monthList.add(new Month("April"));
        monthList.add(new Month("May"));
        monthList.add(new Month("June"));
        monthList.add(new Month("July"));
        monthList.add(new Month("September"));
        monthList.add(new Month("October"));
        monthList.add(new Month("November"));
        monthList.add(new Month("December"));
        monthList.add(7, new Month("August"));
        return monthList;
    }

    private static void printCollection(String title, Iterable<Month> months) {
        System.out.println(title);
        for (Month month : months) {
            System.out.println(month);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        List<Month> monthList = createMonthList();
        printCollection("ArrayList contents:", monthList);

        
        HashSet<Month> monthSet = new HashSet<>(monthList);
        monthSet.add(new Month("January")); // Adding duplicate to demonstrate HashSet behavior
        printCollection("HashSet contents using for-each loop:", monthSet);

        
        System.out.println("HashSet contents using iterator:");
        Iterator<Month> iterator = monthSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
} 