package Miscellany.Plaza;

import edu.princeton.cs.algs4.*;

import java.lang.reflect.Method;
import java.util.*;

public class Exercise0 {
    /**
     * Puts every word in the file named <tt>inputFileName</tt> into a list.
     * @param inputFileName the file name
     * @return the list holding words
     */
    public static java.util.List<String> getWords(String inputFileName) {
        java.util.List<String> stringList = new java.util.ArrayList<>();
        In in = new In(inputFileName);
        while (!in.isEmpty()) stringList.add(in.readString());
        return stringList;
    }

    /**
     * Takes in a <tt>List<String></tt> and counts
     * how many words whose number of letters is odd there are in the file.
     * @param strings the <tt>List<String></tt>
     * @return how many we want
     */
    public static int countOddWords(List<String> strings) {
        int count = 0;
        for (String str : strings) count += str.length() % 2 == 0 ? 0 : 1;
        return count;
    }

    public static int countUniqueWords(List<String> strings) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for (String s : strings)
            set.add(s);
        /*for (Object s : set) {
            System.out.println(s);
        }*/
        return set.size();
    }

    /**
     * Write a method collectWordCount that takes in
     * a List<String> targets and a <tt>List<String></tt> words
     * and finds the number of times each target word appears
     * in the word list.
     * @param words the collection where we look for targets and count
     * @return the number of each word in targets found in words
     */
    public static Map<String, Integer> collectWordCount(List<String> words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String t : words) counts.put(t, 0);
        for (String w : words) counts.put(w, counts.get(w) + 1);
        return counts;
    }

    public static Map<String, Integer> collectWordCount(List<String> target, List<String> words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String t : target) counts.put(t, 0);
        for (String w : words) {
            if (counts.containsKey(w))
                counts.put(w, counts.get(w) + 1);
        }
        return counts;
    }

    public static void main(String[] args) {
        String file = "d:/ztemp/z3/skeleton-sp18/xercises/data/asd.txt";
        String file1 = "d:/ztemp/z3/skeleton-sp18/xercises/data/target.txt";
        //System.out.println(getWords(file).get(3));
       // System.out.println(countUniqueWords(getWords(file)));
        System.out.println(collectWordCount(getWords(file1), getWords(file)));

        Method[] methods = Collection.class.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        Class aclass = Collection.class;
        Class[] interfaces = aclass.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c.getName());
        }
    }
}
