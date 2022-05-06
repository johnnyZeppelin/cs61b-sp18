package DataStructure61B.Set61B;

public class ArraySet<T>{
    private final transient T[] data;
    private int size;

    public ArraySet() {
        data = (T[]) new Object[64];
        size = 0;
    }

    /**
     * Adds the value to the set if not already present.
     * In <tt>contains(T value)</tt> it will throw an error if the value is null.
     * @param value the value to add
     */
    public void add(/*@NotNull */T value ) {
        if (contains(value)) return;
        data[size++] = value;
    }

    /**
     * Checks to see if ArraySet contains the key.
     * Throws an error if <tt>value</tt> is null.
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
     * @return the number of values in the ArraySet
     */
    public int size() {
        return size;
    }
}
