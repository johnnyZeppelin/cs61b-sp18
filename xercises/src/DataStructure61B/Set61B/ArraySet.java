package DataStructure61B.Set61B;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraySet<T> implements Iterable<T> {
    private transient T[] data;
    private int size;

    public ArraySet() {
        data = (T[]) new Object[64];
        size = 0;
    }

    private void resize() {
        T[] newData = (T[]) new Object[2 * data.length];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public static <Glerp> ArraySet<Glerp> of(Glerp... load) {
        ArraySet<Glerp> returnSet = new ArraySet<>();
        for (Glerp i : load) returnSet.add(i);
        return returnSet;
    }

    /**
     * Adds the value to the set if not already present.
     * In <tt>contains(T value)</tt> it will throw an error if the value is null.
     *
     * @param value the value to add
     */
    public void add(/*@NotNull */T value) {
        if (size == data.length) resize();
        if (contains(value)) return;
        data[size++] = value;
    }

    /**
     * Checks to see if ArraySet contains the key.
     * Throws an error if <tt>value</tt> is null.
     *
     * @param value the key value
     * @return true if it contains;
     * false otherwise
     */
    public boolean contains(T value) {
        if (value == null) throw new IllegalArgumentException("elements MUST NOT be null!");
        for (int i = 0; i < size; ++i) if (value.equals(data[i])) return true;
        return false;
    }

    /**
     * Returns the number of values in the ArraySet.
     *
     * @return the number of values in the ArraySet
     */
    public int size() {
        return size;
    }

    private class ArraySetIterator implements Iterator {
        private transient int wizPos = 0;

        public ArraySetIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            return data[wizPos++];
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    public String toString1() {
        String s = "{";
        for (int i = 0; i < size - 1; ++i) s += data[i].toString() + ", ";
        s += size < 1 ? "" : data[size - 1].toString();
        return s + "}";
    }

    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");
        if (size != 0) {
            for (int i = 0; i < size - 1; i++) {
                returnSB.append(data[i].toString());
                returnSB.append(", ");
            }
            returnSB.append(data[size - 1].toString());
        }
        return returnSB.append("}").toString();
    }

    public String toString3() {
        List<String> listOfItems = new ArrayList<>();
        for (T i : this) listOfItems.add(i.toString());
        return "{" + String.join(", ", listOfItems) + "}";
    }

    public String toString2() {
        StringBuffer buffer = new StringBuffer("{");
        for (int i = 0; i < size - 1; ++i) {
            buffer.append(data[i].toString());
            buffer.append(", ");
        }
        buffer.append(data[size - 1].toString());
        return buffer.append("}").toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != getClass()) return false;

        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size != size) return false;
        for (T e : this) if (!o.contains(e)) return false;
        return true;
    }
}
