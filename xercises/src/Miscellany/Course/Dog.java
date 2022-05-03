package Miscellany.Course;

import javafx.util.Pair;

import java.util.Comparator;

//public class Dog implements OurComparable {
public class Dog implements Comparable<Dog> {
    private String name;
    private int size;
    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public Pair<String, Integer> show() {
        return new Pair<>(this.name, this.size);
    }

    @Override
    public int compareTo(Dog o) {
        return this.size - o.size; //aka natural ordering
    }

    private static class NameComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog o1, Dog o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
}
