import static org.junit.Assert.*;
import org.junit.Test;
import LinkedList.*;

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
    public void testAList() {
        AList<String> aList = new AList<String>();
        aList.addFirst("Ar");
        aList.addFirst("Bee");
        aList.addFirst("Ceed");
        aList.addLast("Farm");
        aList.addFirst("Delta");
        aList.addLast("Epsilon");

        assertEquals("Delta", aList.removeFirst());
        assertEquals(5, aList.size());//5
        assertFalse(aList.isEmpty());
        assertEquals("Ceed", aList.get(0));//0
        assertEquals("Epsilon", aList.removeLast());
        assertEquals(4, aList.size());
        aList.printList();//cbaf
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

        AList<String> b = new AList<String>();
        b.addLast("asd");
        b.addFirst("asdfghjj");
        b.addLast("asdfghjk");
        b.addFirst("asdfgh");
        assertEquals("asdfghjj", WordUtils.longest(b));
    }
}
