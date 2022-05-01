package LinkedList;
public class SLList<T> implements List61B {
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
    public void printList() {
        TNode p = front;
        while (p.next != null) {
            p = p.next;
            System.out.println(p.item);
        }
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
}
