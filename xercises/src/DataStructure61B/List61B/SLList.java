package DataStructure61B.List61B;

import org.jetbrains.annotations.NotNull;
import sun.font.CreatedFontTracker;

import java.util.Iterator;

public class SLList<T> implements List61B, Iterable<T> {
    private class TNode {
        T item;
        TNode next;

        public TNode(T i, TNode n) {
            item = i;
            next = n;
        }
    }

    private TNode front;
    private int size;

    public SLList() {
        front = new TNode(null, null);
        size = 0;
    }

    public SLList(SLList<T> other) {
        front = new TNode(null, null);
        size = 0;
        TNode p = other.front;
        while (p.next != null) {
            p = p.next;
            addLast(p.item);
        }
    }

    @Override
    public void addFirst(Object item) {
        front.next = new TNode((T) item, front.next);
        size++;
    }

    @Override
    public void addLast(Object item) {
        TNode p = front;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new TNode((T) item, null);
        size++;
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        T res = front.next.item;
        front.next = (size == 1 ? null : front.next.next);
        size--;
        return res;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        TNode p = front;
        if (size > 1) {
            while (p.next.next != null) {
                p = p.next;
            }
        }
        T res = p.next.item;
        p.next = null;
        size--;
        return res;
    }

    @Override
    public boolean printList() {
        TNode p = front;
        while (p.next != null) {
            p = p.next;
            System.out.println(p.item);
        }
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) return null;
        TNode p = front;
        for (int i = 0; i <= index; ++i) {
            p = p.next;
        }
        return p.item;
    }

    @Override
    public int size() {
        return size;
    }

    private class SLListIterator implements Iterator<T> {
        private TNode wizPos = front;

        @Override
        public boolean hasNext() {
            return wizPos.next != null;
        }

        @Override
        public T next() {
            wizPos = wizPos.next;
            return wizPos.item;
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new SLListIterator();
    }

    public static <T> SLList<T> of(T... load) {
        SLList returnList = new SLList();
        for (T i : load) {
            returnList.addLast(i);
        }
        return returnList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;

        SLList<T> o = (SLList<T>) obj;
        if (o.size != size) return false;
        for (int i = 0; i < size; ++i) {
            if (!get(i).equals(o.get(i))) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder reSB = new StringBuilder("(");
        if (size != 0) {
            TNode p;
            for (p = front.next; p.next != null; p = p.next) {
                reSB.append(p.item.toString());
                reSB.append(", ");
            }
            reSB.append(p.item.toString());
        }
        return reSB.append(')').toString();
    }
}
