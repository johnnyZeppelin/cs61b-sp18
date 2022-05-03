package Miscellany.Course;

import paramount.alphabet.D;

import java.util.Comparator;

public class Maximizer {
    public static Comparable max(Comparable[] items) {
        int maxDex = 0;
        for (int i = 0; i < items.length; ++i) {
            if (items[i].compareTo(items[maxDex]) > 0) maxDex = i;
        }
        return items[maxDex];
    }

    public static Comparable maxName(Comparable[] items) {
        Comparator<Dog> NameComparator = Dog.getNameComparator();
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            if (NameComparator.compare((Dog) items[i], (Dog) items[maxDex]) > 0) maxDex = i;
        }
        return items[maxDex];
    }
}
