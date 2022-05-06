package DataStructure61B.List61B.Deque;

public class ArrayDeque<T> implements DataStructure61B.List61B.List61B<T> {
    private T[] arr;
    private int front, back, size;

    public ArrayDeque() {
        arr = (T[]) new Object[8];
        front = back = 0;
        size = 0;
    }
    public ArrayDeque(ArrayDeque other) {
        arr = (T[]) new Object[other.arr.length];
        front = other.front;
        back = other.back;
        size = other.size;
        for (int i = front; i < back; ++i) {
            arr[ri(i, arr.length)] = (T) other.arr[ri(i, other.arr.length)];
        }
    }

    private int ri(int i, int p) { return (i % p + p) % p; }
    private void doubleArray() {
        T[] newArr = (T[]) new Object[2 * arr.length];
        for (int i = front; i < back; ++i) {
            newArr[ri(i, newArr.length)] = arr[ri(i, arr.length)];
        }
        arr = newArr;
    }
    private void halfArray() {
        T[] newArr = (T[]) new Object[arr.length / 2];
        for (int i = front; i < back; ++i) {
            newArr[ri(i, newArr.length)] = arr[ri(i, arr.length)];
        }
        arr = newArr;
    }

    @Override
    public void addFirst(T item) {
        if (++size > arr.length) doubleArray();
        arr[ri(--front, arr.length)] = item;
    }

    @Override
    public void addLast(T item) {
        if (++size > arr.length) doubleArray();
        arr[ri(back++, arr.length)] = item;
    }

    @Override
    public T removeFirst() {
        if (--size < 0.25 * arr.length) halfArray();
        return arr[ri(front++, arr.length)];
    }

    @Override
    public T removeLast() {
        if (--size < 0.25 * arr.length) halfArray();
        return arr[ri(--back, arr.length)];
    }

    @Override
    public boolean printList() {
        for (int i = front; i < back; ++i) {
            System.out.println(arr[ri(i, arr.length)]);
        }
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        return arr[ri(front + index, arr.length)];
    }

    @Override
    public int size() {
        return size;
    }
}
