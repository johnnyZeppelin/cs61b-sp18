package hw3.hash;

import DataStructure61B.List61B.Deque.ArrayDeque;
import DataStructure61B.List61B.Deque.LinkedListDeque;
import DataStructure61B.List61B.List61B;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


public class TestSimpleOomage {

    @Test
    public void testHashCodeDeterministic() {
        SimpleOomage so = SimpleOomage.randomSimpleOomage();
        int hashCode = so.hashCode();
        for (int i = 0; i < 100; i += 1) {
            assertEquals(hashCode, so.hashCode());
        }
    }

    @Test
    public void testHashCodePerfect() {
        /* TODO: Write a test that ensures the hashCode is perfect,
          meaning no two SimpleOomages should EVER have the same
          hashCode UNLESS they have the same red, blue, and green values!
         */
        List61B<SimpleOomage> sol61B = new ArrayDeque<>();
        for (int i = 0; i < 256; i += 5) {
            for (int j = 0; j < 256; j += 5) {
                for (int k = 0; k < 256; k += 5) {
                    sol61B.addLast(new SimpleOomage(i, j, k));
                }
            }
        }
        for (int i = 0; i < sol61B.size() - 1; ++i) {
            SimpleOomage noo = sol61B.get(i);
            for (int j = i + 1; j < sol61B.size(); ++j) {
                SimpleOomage noo1 = sol61B.get(j);
                assertEquals(false, noo.hashCode() == noo1.hashCode());
            }
            assertEquals(true, noo.hashCode() ==
                    (new SimpleOomage(noo.red, noo.green, noo.blue)).hashCode());
        }
        SimpleOomage lan = sol61B.get(sol61B.size() - 1);
        assertEquals(true, lan.hashCode() ==
                (new SimpleOomage(lan.red, lan.green, lan.blue)).hashCode());
    }

    @Test
    public void testEquals() {
        SimpleOomage ooA = new SimpleOomage(5, 10, 20);
        SimpleOomage ooA2 = new SimpleOomage(5, 10, 20);
        SimpleOomage ooB = new SimpleOomage(50, 50, 50);
        assertEquals(ooA, ooA2);
        assertNotEquals(ooA, ooB);
        assertNotEquals(ooA2, ooB);
        assertNotEquals(ooA, "ketchup");
    }

    @Test
    public void testHashCodeAndEqualsConsistency() {
        SimpleOomage ooA = new SimpleOomage(5, 10, 20);
        SimpleOomage ooA2 = new SimpleOomage(5, 10, 20);
        HashSet<SimpleOomage> hashSet = new HashSet<>();
        hashSet.add(ooA);
        assertTrue(hashSet.contains(ooA2));
    }

    /* TODO: Uncomment this test after you finish haveNiceHashCode Spread in OomageTestUtility */
    @Test
    public void testRandomOomagesHashCodeSpread() {
        List<Oomage> oomages = new ArrayList<>();
        int N = 10000;

        for (int i = 0; i < N; i += 1) {
            oomages.add(SimpleOomage.randomSimpleOomage());
        }

        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(oomages, 10));
    }

    /**
     * Calls tests for SimpleOomage.
     */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestSimpleOomage.class);
    }
}
