package Miscellany.Plaza;

import DataStructure61B.List61B.AList;
import DataStructure61B.List61B.List61B;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise1 {
    public static void main(String[] args) {
        List61B<Integer> list61B = new AList<>();
        for (int i = 0; i < 6; i++) { list61B.addLast(i + 1); }
        list61B.printList();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) { list.add(2 * i); }
        System.out.println(list);

        Set<String> cities = new HashSet<>();
        cities.add("Paris"); cities.add("London"); cities.add("Rome");
        cities.add("Brisbane"); cities.add("Milan");
        System.out.println(cities.contains("Tokyo") +
                " " + cities.contains("London"));
        Set<String> a = new HashSet<>();
        a.add("London"); a.add("Pairis");
        System.out.println(cities.containsAll(a));
    }
}
