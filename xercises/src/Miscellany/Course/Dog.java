package Miscellany.Course;

import javafx.util.Pair;

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
        return this.size - o.size;
    }
}
