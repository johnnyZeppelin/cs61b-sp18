package DataStructure61B.Set61B;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestArraySet {
    @Test
    public void testArraySet() {
        ArraySet<Integer> set = new ArraySet<>();
        for (int i = 0; i < 99999; ++i) {
            set.add(i);
        }
        assert !set.contains(99999);
        assert set.contains(3);

        /*
        Iterator<Integer> setIterator = set.iterator();
        while (setIterator.hasNext()) {
            System.out.println(setIterator.next());
        }

        for (Integer integer : set) {
            System.out.print(integer + "; ");
        }*/
        System.out.println();
        long timee = System.currentTimeMillis();

        long time0 = System.currentTimeMillis();
        //System.out.println(set.toString1());
        //System.out.println(set.toString2());
        //System.out.println(set.toString3());
        System.out.println(set);
        long time1 = System.currentTimeMillis();
        //for (Integer i : set) System.out.printf("%d, ", i);
        //System.out.println(set);
        System.out.println(set.toString3());
        //System.out.println(set.toString2());
        long time2 = System.currentTimeMillis();


        System.out.println();
        //System.out.println("1-Direct String: " + (time1 - time0));
        System.out.println("StringBuffer: " + (time1 - time0));
        //System.out.println("3-String.join: " + (time1 - time0));

        System.out.println("3-String.join: " + (time2 - time1));
        //System.out.println("2-StringBuilder: " + (time2 - time1));
    }

    @Test
    public void testArraySetEquals() {
        ArraySet<Integer> set1 = new ArraySet<>();
        System.out.println(set1);
        ArraySet<Character> set2 = new ArraySet<>();
        ArraySet<Integer> set3, set4;
        set3 = new ArraySet<>(); set4 = new ArraySet<>();
        for (int i = 0; i < 15; i++) {
            set1.add(14 - i);
            set3.add(i); set4.add(i - 1 + 1);
            set2.add((char) i);
        }

        System.out.println(set1.equals(set2));
        assertFalse(set1.equals(set2));
        assertFalse(set1.equals(null));
        assertFalse(set1.equals(new ArraySet<String>()));
        assertFalse(set1.equals(new ArraySet<Integer>()));
        assertTrue(set2.equals(set2)); // reflexive
        assertTrue(set1.equals(set2) == set2.equals(set1)); // symmetric

        assertTrue(set1.equals(set4));assertTrue(set4.equals(set3));
        assertTrue(set3.equals(set1)); // transitive

        set4.add(123);
        assertFalse(set4.equals(set1));

        assertTrue((new ArraySet<Integer>()).equals(new ArraySet<Integer>()));
        assertTrue((new ArraySet<String>()).equals(new ArraySet<Integer>()));
        assertFalse(new ArraySet<In>().equals(null));

        System.out.println(set1);
    }

    @Test
    public void testOf() {
        ArraySet<String> strings = ArraySet.of(new String[]{"London", "Paris"});
        ArraySet<Integer> integers = ArraySet.of(new Integer[]{1,2,3,4,5});
        System.out.println(strings + "\n" + integers);
    }
}
