public class SLList<T> {
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

    public void addFirst(T item) {
        front.next = new TNode(item, front.next);
        size++;
    }
    public T removeFirst() {
        if (size == 0) return null;
        T res = front.next.item;
        size--;
        front.next = size == 1 ? null : front.next.next;
        return res;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void printList() {
        TNode p = front;
        while (p.next != null) {
            p = p.next;
            System.out.println(p.item);
        }
    }
    public T get(int index) {
        if (index < 0 || index > size - 1) return null;
        TNode p = front;
        for (int i = 0; i <= index; ++i) {
            p = p.next;
        }
        return p.item;
    }
}
