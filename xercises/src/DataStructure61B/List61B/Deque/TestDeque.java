package DataStructure61B.List61B.Deque;

import DataStructure61B.List61B.List61B;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDeque {
    @Test
    public void testLinkedListDeque() {
        LinkedListDeque<Integer> listDeque = new LinkedListDeque();
        listDeque.addFirst(1);
        listDeque.addLast(2);
        listDeque.addLast(3);
        listDeque.addFirst(4);
        listDeque.addFirst(5);
        listDeque.addLast(6);
        //541236
        assertTrue(5 == listDeque.get(0));
        assertTrue(null == listDeque.get(listDeque.size()));
        assertTrue(6 == listDeque.removeLast());//54123
        assertTrue(5 == listDeque.removeFirst());//4123

        LinkedListDeque<Integer> l2 = new LinkedListDeque<>(listDeque);

        assertTrue(3 == listDeque.removeLast()); //412
        assertEquals(3, listDeque.size());
        assertTrue(1 == listDeque.get(1));
        assertFalse(listDeque.isEmpty());
        for (int i = 0; i < 3; ++i) { listDeque.removeLast(); }
        assertTrue(listDeque.isEmpty());
        assertFalse(l2.isEmpty());
        assertEquals(4, l2.size());
        assertTrue(1 == l2.get(1));
    }

    @Test
    public void testArrayDeque() {

        ArrayDeque<Integer> listDeque = new ArrayDeque<>();
        listDeque.addFirst(167);
        listDeque.addLast(2);
        listDeque.addLast(3);
        listDeque.addFirst(4);
        listDeque.addFirst(5);
        listDeque.addLast(6);
        assertTrue(5 == listDeque.get(0));
        assertTrue(null == listDeque.get(listDeque.size()));
        assertTrue(6 == listDeque.removeLast());
        assertTrue(5 == listDeque.removeFirst());

        ArrayDeque<Integer> l2 = new ArrayDeque<>(listDeque);

        assertTrue(3 == listDeque.removeLast());
        assertEquals(3, listDeque.size());
        assertTrue(167 == listDeque.get(1));
        assertFalse(listDeque.isEmpty());
        for (int i = 0; i < 3; ++i) { listDeque.removeLast(); }
        assertTrue(listDeque.isEmpty());
        assertFalse(l2.isEmpty());
        assertEquals(4, l2.size());
        assertTrue(167 == l2.get(1));
    }

    @Test
    public void testLLD1() {
        List61B<String> list61B = new LinkedListDeque<>();
        System.out.println(list61B);
        list61B.removeLast();
        System.out.println(list61B.size());

        String[] backup = new String[10];
        for (int i = 0; i < 5; ++i) {
            list61B.addFirst("This is " + ((Character) (char) (i + 60)));
            list61B.addLast("This is " + ((Character) (char) (80 - i)));
        }
        assertEquals(10, list61B.size());

        for (int i = 0; i < 10; ++i) backup[i] = list61B.get(i);

        for (String s : (LinkedListDeque<String>) list61B) {
            System.out.printf("%s\n", s);
        }

        //List61B<char[]> list61B1 = LinkedListDeque.of(backup);
        List61B<String> list61B1 = LinkedListDeque.of(backup);

        assertTrue(list61B1.equals(list61B));

        System.out.println(list61B);
    }

    @Test
    public void testAD1() {
        List61B<Double> list61B = new ArrayDeque<>();
        list61B.removeLast();
        System.out.println(list61B);
        Double[] backup = new Double[10];
        for (int i = 0; i < 5; ++i) {
            list61B.addFirst(i * 3.89);
            list61B.addLast(93.4 / i);
        }
        assertEquals(10, list61B.size());

        for (int i = 0; i < 10; ++i) backup[i] = list61B.get(i);

        for (double d : (ArrayDeque<Double>) list61B) System.out.printf("%fl\n", d);

        List61B<Double> list61B1 = ArrayDeque.of(backup);

        assertTrue(list61B.equals(list61B1));

        System.out.println(list61B1);
    }
}
