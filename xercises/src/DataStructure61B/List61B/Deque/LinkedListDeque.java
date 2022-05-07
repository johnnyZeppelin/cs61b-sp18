package DataStructure61B.List61B.Deque;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.util.Iterator;

public class LinkedListDeque<T> implements
        DataStructure61B.List61B.List61B<T>, Iterable<T> {
    private class DTNode {
        DTNode prev;
        T item;
        DTNode next;

        public DTNode() {
            prev = null;
            item = null;
            next = null;
        }

        public DTNode(DTNode p, T i, DTNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    DTNode front, back;
    int size;

    public LinkedListDeque() {
        size = 0;
        front = new DTNode();
        back = new DTNode(front, null, front);
        front.next = front.prev = back;
    }

    public LinkedListDeque(LinkedListDeque other) {
        size = 0;
        front = new DTNode();
        back = new DTNode(front, null, front);
        front.next = front.prev = back;
        DTNode helper = other.front;
        for (int i = 0; i < other.size; ++i) {
            helper = helper.next;
            addLast((T) helper.item);
        }
    }

    @Override
    public void addFirst(T item) {
        front.next = front.next.prev = new DTNode(front, item, front.next);
        ++size;
    }

    @Override
    public void addLast(T item) {
        back.prev = back.prev.next = new DTNode(back.prev, item, back);
        ++size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        T res = front.next.item;
        front.next = front.next.next;
        front.next.prev = front;
        --size;
        return res;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        T res = back.prev.item;
        back.prev = back.prev.prev;
        back.prev.next = back;
        --size;
        return res;
    }

    @Override
    public boolean printList() {
        DTNode helper = front;
        for (int i = 0; i < size; ++i) {
            helper = helper.next;
            System.out.println(helper.item);
        }
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        DTNode helper;
        if (index < size / 2) {
            helper = front;
            for (int i = 0; i <= index; ++i) {
                helper = helper.next;
            }
        } else {
            helper = back;
            for (int i = size - 1; i >= index; --i) {
                helper = helper.prev;
            }
        }
        return helper.item;
    }

    @Override
    public int size() {
        return size;
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private transient DTNode wizPos;
        private transient int pos;

        public LinkedListDequeIterator() {
            wizPos = front;
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public T next() {
            wizPos = wizPos.next;
            ++pos;
            return wizPos.item;
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    public static <T> LinkedListDeque<T> of(T... load) {
        LinkedListDeque<T> listDeque = new LinkedListDeque<>();
        for (T i : load) listDeque.addLast(i);
        return listDeque;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;

        LinkedListDeque<T> o = (LinkedListDeque<T>) obj;
        if (o.size != size) return false;
        for (int i = 0; i < size; ++i) {
            if (!get(i).equals(o.get(i))) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder rSB = new StringBuilder("(");
        if (size != 0) {
            DTNode p = front;
            for (int i = 0; i < size - 1; ++i) {
                p = p.next;
                rSB.append(p.item.toString());
                rSB.append(", ");
            }
            rSB.append(back.prev.item.toString());
        }
        return rSB.append(')').toString();
    }
}
