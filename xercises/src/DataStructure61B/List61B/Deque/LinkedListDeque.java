package DataStructure61B.List61B.Deque;

public class LinkedListDeque<T> implements DataStructure61B.List61B.List61B<T> {
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
        T res = front.next.item;
        front.next = front.next.next;
        front.next.prev = front;
        --size;
        return res;
    }

    @Override
    public T removeLast() {
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
}
