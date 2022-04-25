public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    default boolean isEmpty() {
      return size() == 0;
    }
    int size();
    void printDeque();
    T get(int index);
    T getRecursive(int index);
    void insertAt(int index, T item);
}

class LinkedListDeque<T> implements Deque {
    private class ListNode {
        ListNode prev;
        T item;
        ListNode next;

        public ListNode() {
            prev = null;
            item = null;
            next = null;
        }

        public ListNode(ListNode prev, T item, ListNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private ListNode front, back;
    private int size;

    public LinkedListDeque() {
        front = new ListNode();
        back = new ListNode(front, null, front);
        front.prev = back;
        front.next = back;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {
        front = new ListNode();
        back = new ListNode(front, null, front);
        front.prev = back;
        front.next = back;
        size = 0;
        ListNode p = other.front;
        for (int i = 0; i < other.size; ++i) {
            p = p.next;
            this.addLast(p.item);
        }
    }

    @Override
    public void addFirst(Object item) {
        ListNode p = new ListNode(front, (T) item, front.next);
        p.next.prev = p;
        p.prev.next = p;
        ++size;
    }

    @Override
    public void addLast(Object item) {
        ListNode p = new ListNode(back.prev, (T) item, back);
        p.next.prev = p;
        p.prev.next = p;
        ++size;
    }

    @Override
    public Object removeFirst() {
        T res = front.next.item;
        front.next = front.next.next;
        front.next.prev = front;
        --size;
        return res;
    }

    @Override
    public Object removeLast() {
        T res = back.prev.item;
        back.prev = back.prev.prev;
        back.prev.next = back;
        --size;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        ListNode p = front;
        for (int i = 0; i < size - 1; ++i) {
            p = p.next;
            System.out.print(p.item + " ");
        }
        p = p.next;
        System.out.println(p.item);
    }

    @Override
    public Object get(int index) {
        ListNode p = front;
        for (int i = -1; i < index; ++i) {
            p = p.next;
        }
        return p.item;
    }

    private ListNode getRecursiveHelper(int index) {
        if (index == 0) {
            ListNode p = front.next;
            return p;
        } else {
            return getRecursiveHelper(index - 1).next;
        }
    }
    @Override
    public Object getRecursive(int index) {
        return getRecursiveHelper(index).item;
    }

    @Override
    public void insertAt(int index, Object item) {
        ListNode p = front;
        for (int i = -1; i < index - 1; ++i) {
            p = p.next;
        }
        ListNode q = new ListNode(p, (T) item, p.next);
        p.next.prev = q;
        p.next = q;
        ++size;
    }
}

class ArrayDeque<T> implements Deque {
    private T[] arr = (T[]) new Object[8];
    private int size;
    private int front, back;

    public ArrayDeque() {
        size = 0;
        front = back = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        arr = (T[]) new Object[other.arr.length];
        size = other.size;
        front = other.front;
        back = other.back;
        for (int i = front; i < back; ++i) {
            arr[(arr.length + i) % arr.length] = (T) other.arr[(arr.length + i) % arr.length];
        }
    }

    private void updateArr(int newSize) {
        if (newSize < 1) return;
        T[] newArr = (T[]) new Object[newSize];
        for (int i = front; i < back; ++i) {
            newArr[(newSize + i) % newSize] = arr[(arr.length + i) % arr.length];
        }
        arr = newArr;
    }

    @Override
    public void addFirst(Object item) {
        if (++size > arr.length) {
            updateArr(2 * arr.length);
        }
        arr[(--front + arr.length) % arr.length] = (T) item;
    }

    @Override
    public void addLast(Object item) {
        if (++size > arr.length) {
            updateArr(2 * arr.length);
        }
        arr[(arr.length + back++) % arr.length] = (T) item;
    }

    @Override
    public Object removeFirst() {
        if (size == 0) return null;
        if (--size < 0.25 * arr.length) {
            updateArr(arr.length / 2);
        }
        T res = arr[(arr.length + front) % arr.length];
        arr[(arr.length + front++) % arr.length] = null;
        return res;
    }

    @Override
    public Object removeLast() {
        if (size == 0) return null;
        if (--size < 0.25 * arr.length) {
            updateArr(arr.length / 2);
        }
        T res = arr[(arr.length + back - 1) % arr.length];
        arr[(--back + arr.length) % arr.length] = null;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = front; i < back - 1; ++i) {
            System.out.print(arr[(arr.length + i) % arr.length] + " ");
        }
        System.out.println(arr[(arr.length + back - 1) % arr.length]);
    }

    @Override
    public Object get(int index) {
        return arr[((front + index) % arr.length + arr.length) % arr.length];
    }

    private int getRecursiveHelper(int index) {
        //This is in fact not recursive.
        return ((front + index) % arr.length + arr.length) % arr.length;
    }
    @Override
    public Object getRecursive(int index) {
        return arr[getRecursiveHelper(index)];
    }

    @Override
    public void insertAt(int index, Object item) {
        if (++size > arr.length) {
            updateArr(2 * arr.length);
        }
        int pos = ((front + index) % arr.length + arr.length) % arr.length;
        int end = (arr.length + back++) % arr.length;
        for (int i = end; i > pos; --i) {
            arr[i] = arr[i-1];
        }
        arr[pos] = (T) item;
    }
}
