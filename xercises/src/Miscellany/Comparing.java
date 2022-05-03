package Miscellany;

import edu.princeton.cs.algs4.In;

public class Comparing implements Compare {
    @Override
    public boolean biggerThan(long x, long y) {
        return x > y;
    }

    public static String biggerOne(Compare c, long x, long y) {
        if (c.biggerThan(x, y)) {
            return "" + (char) x;
        } else {
            return ((Long) y).toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(biggerOne(new Comparing(), 2147483646, 24));
    }
}
