package DataStructure61B.List61B.Deque;

import DataStructure61B.List61B.Deque.ArrayDeque;
import DataStructure61B.List61B.Deque.LinkedListDeque;
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
}
