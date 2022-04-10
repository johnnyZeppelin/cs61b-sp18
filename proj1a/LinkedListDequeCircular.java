public class LinkedListDequeCircular<T> {
    private class TNode {
        public TNode prev;
        public T item;
        public TNode next;

        public TNode() {
            prev = null;
            item = null;
            next = null;
        }

        public TNode(TNode p, T i, TNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private final TNode front;
    private final TNode back;
    private int size;

    public LinkedListDequeCircular() {
        front = new TNode();
        back = new TNode();
        front.prev = back;
        front.next = back;
        back.prev = front;
        back.next = front;
        size = 0;
    }

    public LinkedListDequeCircular(LinkedListDequeCircular other) {
        front = new TNode();
        back = new TNode();
        front.prev = back;
        front.next = back;
        back.prev = front;
        back.next = front;
        size = 0;
        for (int i = 0; i < other.size; ++i) {
            addLast((T) other.get(i));
        }
    }

    public void addFirst(T item) {
        TNode p =new TNode(front, item, front.next);
        front.next.prev = p;
        front.next = p;
        ++size;
    }
    public void addLast(T item) {
        TNode p = new TNode(back.prev, item, back);
        back.prev.next = p;
        back.prev = p;
        ++size;
    }
    public T removeFirst() {
        T i = front.next.item;
        front.next = front.next.next;
        front.next.prev = front;
        --size;
        return i;
    }
    public T removeLast() {
        T i = back.prev.item;
        back.prev = back.prev.prev;
        back.prev.next = back;
        --size;
        return i;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        TNode p = front;
        for (int i = 0; i < size - 1; ++i) {
            p = p.next;
            System.out.print(p.item + " ");
        }
        p = p.next;
        System.out.println(p.item);
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public T get(int index) {
        TNode p = front;
        for (int i = 0; i < index % size + 1; ++i) {
            p = p.next;
        }
        return p.item;
    }

    public TNode getPointer(int index) {
        int i = index % size;
        if (i == 0) {
            return front.next;
        } else {
            return getPointer(i - 1).next;
        }
    }
    public T getRecursive(int index) {
        return getPointer(index).item;
    }

    public void insert(T item, int index) {
        int i = index % size;
        TNode p = front;
        for (int k = 0; k < i - 1; ++k) {
            p = p.next;
        }
        TNode insertNode = new TNode(p, item, p.next);
        p.next.prev = insertNode;
        p.next = insertNode;
        ++size;
    }

}


