import static org.junit.Assert.*;
import org.junit.Test;

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
}
