package DataStructure61B.List61B;

import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSLList {
    SLList<String> stringSLList = new SLList<String>();

    @Test
    public void testAddFirst() {
        stringSLList.addFirst("Alpha");
        stringSLList.addFirst("Beta");
        stringSLList.addFirst("Gamma");
        assertTrue(stringSLList.size() == 3);
        assertTrue("Beta".equals(stringSLList.get(1)));
    }

    @Test
    public void testRemoveFirst() {
        stringSLList.addFirst("Alpha");
        stringSLList.addFirst("Beta");
        stringSLList.addFirst("Gamma");
        assertTrue(stringSLList.removeFirst().equals("Gamma"));
        assertFalse(stringSLList.isEmpty());
        assertTrue(stringSLList.size() == 2);
    }

    @Test
    public void testSize() {
        stringSLList.addFirst("Alpha");
        stringSLList.addFirst("Beta");
        stringSLList.addFirst("Gamma");
        assertTrue(stringSLList.size() == 3);
    }

    @Test
    public void testIsEmpty() {
        stringSLList.addFirst("Alpha");
        stringSLList.addFirst("Beta");
        stringSLList.addFirst("Gamma");
        assertFalse(stringSLList.isEmpty());
    }

    @Test
    public void testPrintList() {
        stringSLList.addFirst("Alpha");
        stringSLList.addFirst("Beta");
        stringSLList.addFirst("Gamma");
        stringSLList.printList();
    }

    @Test
    public void testGet() {
        stringSLList.addFirst("Alpha");
        stringSLList.addFirst("Beta");
        stringSLList.addFirst("Gamma");
        assertTrue(stringSLList.get(1).equals("Beta"));
        assertFalse(stringSLList.get(0).equals("Alpha"));
    }

    @Test
    public void testRotatingSLList() {
        RotatingSLList<java.lang.Integer> aka = new RotatingSLList<>();
        aka.addLast(5);
        aka.addLast(9);
        aka.addLast(15);
        aka.addLast(22);
        aka.rotateRight();
        aka.printList();
    }

    @Test
    public void testWordUtils() {
        SLList<String> a = new SLList<String>();
        a.addFirst("asd");
        a.addFirst("asdfghjj");
        a.addFirst("asdfghjk");
        a.addFirst("asdfgh");
        assertEquals("asdfghjk", WordUtils.longest(a));

        for (String s : a) {
            System.out.println(s);
        }

        AList<String> b = new AList<String>();
        b.addLast("asd");
        b.addFirst("asdfghjj");
        b.addLast("asdfghjk");
        b.addFirst("asdfgh");
        assertEquals("asdfghjj", WordUtils.longest(b));
    }

    @Test
    public void testToStrEqlOf() {
        List61B<Pair<String, Double>> list61B = new SLList<>();
        Pair<String, Double>[] backup = new Pair[10];
        for (int i = 0; i < 10; ++i) {
            list61B.addLast(new Pair<>("Hello: ", i + 1.2));
            backup[i] = new Pair<>("Hello: ", i + 1.2);
        }

        List61B<Pair<String, Double>> list61B1 = SLList.of(backup);
        assertTrue(list61B1.equals(list61B));
        System.out.println(list61B1);
    }

    @Test
    public void testSpecial() {
        List61B<String> list61B = new SLList<>();
        System.out.println(list61B);
        list61B.removeLast();list61B.removeLast();
        System.out.println(list61B.size());
    }
}
