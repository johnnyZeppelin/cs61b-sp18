package DataStructure61B.List61B;

import java.util.Iterator;

public class AList<T> implements List61B, Iterable<T> {
    private T[] arr;
    private int size;

    public AList() {
        arr = (T[]) new Object[8];
        size = 0;
    }

    public AList(AList other) {
        arr = (T[]) new Object[other.arr.length];
        size = other.size;
        for (int i = 0; i < size; ++i) {
            arr[i] = (T) other.arr[i];
        }
    }

    private void extendArr() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < size; ++i) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    private void halfArr() {
        T[] newArr = (T[]) new Object[arr.length / 2];
        for (int i = 0; i < size; ++i) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public void addFirst(Object item) {
        if (size >= arr.length) extendArr();
        for (int i = size; i > 0; --i) {
            arr[i] = arr[i - 1];
        }
        arr[0] = (T) item;
        size++;
    }

    @Override
    public void addLast(Object item) {
        if (size >= arr.length) extendArr();
        arr[size++] = (T) item;
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        T res = arr[0];
        for (int i = 0; i < size - 1; ++i) {
            arr[i] = arr[i + 1];
        }
        size--;
        return res;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        if (size <= arr.length * 0.25) halfArr();
        return arr[--size];
    }

    @Override
    public boolean printList() {
        for (int i = 0; i < size; ++i) {
            System.out.println(arr[i]);
        }
        return true;
    }

    @Override
    public T get(int index) {
        return index < 0 || index >= size ? null : arr[index];
    }

    @Override
    public int size() {
        return size;
    }

    public static <T> AList<T> of(T... load) {
        AList<T> aList = new AList<>();
        for (T i : load) aList.addLast(i);
        return aList;
    }

    private class AListIterator implements Iterator<T> {
        private transient int wizPos;

        public AListIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            return arr[wizPos++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new AListIterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;

        AList<T> o = (AList<T>) obj;
        if (o.size != size) return false;
        for (int i = 0; i < size; ++i) {
            if (!arr[i].equals(o.arr[i])) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder rSB = new StringBuilder("(");
        if (size != 0) {
            for (int i = 0; i < size - 1; ++i) {
                rSB.append(arr[i].toString());
                rSB.append(", ");
            }
            rSB.append(arr[size - 1].toString());
        }
        return rSB.append(')').toString();
    }
}
