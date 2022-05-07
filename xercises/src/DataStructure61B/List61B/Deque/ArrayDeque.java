package DataStructure61B.List61B.Deque;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class ArrayDeque<T> implements
        DataStructure61B.List61B.List61B<T>, Iterable<T> {
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

    private int ri(int i, int p) {
        return (i % p + p) % p;
    }

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
        if (size == 0) return null;
        if (--size < 0.25 * arr.length) halfArray();
        return arr[ri(front++, arr.length)];
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
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

    private class ArrayDequeIterator implements Iterator<T> {
        private transient int wizPos;

        public ArrayDequeIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            return arr[ri(front + wizPos++, arr.length)];
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    public static <T> ArrayDeque<T> of(T... load) {
        ArrayDeque<T> arrayDeque = new ArrayDeque<>();
        for (T i : load) arrayDeque.addLast(i);
        return arrayDeque;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;

        ArrayDeque<T> o = (ArrayDeque<T>) obj;
        for (int i = 0; i < size; ++i) {
            if (!get(i).equals(o.get(i))) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder rSB = new StringBuilder("(");
        if (size != 0) {
            for (int i = front; i < back - 1; ++i) {
                rSB.append(arr[ri(i, arr.length)].toString());
                rSB.append(", ");
            }
            rSB.append(arr[ri(back - 1, arr.length)].toString());
        }
        return rSB.append(')').toString();
    }
}
