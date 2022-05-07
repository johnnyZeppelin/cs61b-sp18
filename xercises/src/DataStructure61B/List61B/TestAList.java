package DataStructure61B.List61B;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestAList {
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
    public void testAList1() {
        List61B<String> list61B = new AList<>();
        List61B<String> list61B1 = new AList<>();
        String[] strings = new String[]{
                "London", "Paris", "Brisbane", "Sydney", "LA", "Milan"
        };
        for (String s : strings) {
            list61B.addLast(s);
        }
        assertEquals(6, list61B.size());
        list61B1 = AList.of(strings);
        List61B<String> list61B2 = new AList<>();
        System.out.println(list61B2);
        list61B2.addLast("adf");
        System.out.println(list61B2);
        list61B2.removeFirst();
        for (String s : (AList<String>) list61B) {
            list61B2.addLast(s);
        }
        assertEquals(list61B1, list61B);
        assertTrue(list61B1.equals(list61B2));

        System.out.println(list61B2);
    }
}
