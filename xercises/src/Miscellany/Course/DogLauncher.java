package Miscellany.Course;

import java.util.Comparator;

public class DogLauncher {
    public static void main(String[] args) {
        Dog d1 = new Dog("Malamute", 99),
                d2 = new Dog("Husky", 90),
                d3 = new Dog("Poodle", 35);
        Dog[] dogs = new Dog[]{d1, d2, d3};
        System.out.println(((Dog) Maximizer.max(dogs)).show());
        System.out.println(((Dog) Maximizer.maxName(dogs)).show());
    }
}
