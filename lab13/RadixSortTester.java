import static org.junit.Assert.*;

import org.junit.Test;

public class RadixSortTester {

    /**
     * Array that will cause CountingSort.naiveCountingSort to fail, but
     * CountingSort.betterCountingSort can handle.
     **/
    private static String[] someAsciiStrings = {
            "Juventus", "Inter", "Milano", "Real Madrid", "Barcelona",
            "Bayern Munich", "Liverpool", "Manchester United"};

    public static void assertIsSorted(String[] a) {
        String pre = "" + (char) 0;
        for (String x : a) {
            int cmp = x.compareTo(pre);
            assertTrue(cmp >= 0);
            pre = x;
        }
    }

    @Test
    public void testLSD() {
        String[] sorted = RadixSort.sort(someAsciiStrings); // LSD
        assertIsSorted(sorted);
    }

    @Test
    public void testMSD() {
        String[] sorted = RadixSort.MSD(someAsciiStrings);
        assertIsSorted(sorted);
    }
}
