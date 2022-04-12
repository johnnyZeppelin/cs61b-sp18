public class ArrayDeque<T> {
    /**
     * Fields
     */
    private T[] baseArray;
    private int size;
    private int front;
    private int back;

    /**
     * <b>Constructor 1</b>
     * <p>
     * To construct the deque with an empty array based.
     * </p>
     */
    public ArrayDeque() {
        baseArray = (T[]) new Object[8];
        size = 0;
        front = back = 0;
    }

    /**
     * <b>Constructor 2</b>
     * <p>
     * To deep copy an ArrayDeque to this, which means that no change to other will affect this.
     * </p>
     *
     * @param other the ArrayDeque to deep copy
     */
    public ArrayDeque(ArrayDeque other) {
        baseArray = (T[]) new Object[other.baseArray.length];
        size = other.size;
        front = other.front;
        back = other.back;
        for (int i = front; i < back; ++i) {
            baseArray[(baseArray.length + i) % baseArray.length] =(T) other.baseArray[(baseArray.length + i) % baseArray.length];
        }
    }

    /**
     * To add item at the logical front of the deque.
     * @param item the item to add
     */
    public void addFirst(T item) {
        if (++size > baseArray.length) {
            T[] newArray = (T[]) new Object[2 * baseArray.length];
            for (int i = front; i < back; ++i) {
                newArray[(newArray.length + i) % newArray.length] = baseArray[(baseArray.length + i) % baseArray.length];
            }
            baseArray = newArray;
        }
        baseArray[(--front + baseArray.length) % baseArray.length] = item;
    }

    /**
     * To add item at the logical back of the deque.
     * @param item the item to add
     */
    public void addLast(T item) {
        if (++size > baseArray.length) {
            T[] newArray = (T[]) new Object[2 * baseArray.length];
            for (int i = front; i < back; ++i) {
                newArray[(newArray.length + i) % newArray.length] = baseArray[(baseArray.length + i) % baseArray.length];
            }
            baseArray = newArray;
        }
        baseArray[(baseArray.length + back++) % baseArray.length] = item;
    }

    /**
     * To remove the logically first item.
     * @return the item removed
     */
    public T removeFirst() {
        if (--size < 0.25 * baseArray.length) {
            T[] newArray = (T[]) new Object[baseArray.length / 2];
            for (int i = front; i < back; ++i) {
                newArray[(newArray.length + i) % newArray.length] = baseArray[(baseArray.length + i) % baseArray.length];
            }
            baseArray = newArray;
        }
        return baseArray[(baseArray.length + front++) % baseArray.length];
    }

    /**
     * To remove the logically last item.
     * @return the item removed
     */
    public T removeLast() {
        if (--size < baseArray.length) {
            T[] newArray = (T[]) new Object[baseArray.length / 2];
            for (int i = front; i < back; ++i) {
                newArray[(newArray.length + i) % newArray.length] = baseArray[(baseArray.length + i) % baseArray.length];
            }
            baseArray = newArray;
        }
        return baseArray[(--back + baseArray.length) % baseArray.length];
    }

    /**
     * To check if the deque is empty.
     * @return true if the deque is empty;
     * false if not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Prints the deque.
     */
    public void printDeque() {
        for (int i = front; i < back -1; ++i) {
            System.out.print(baseArray[(baseArray.length + i) % baseArray.length] + " ");
        }
        System.out.println(baseArray[(back - 1 + baseArray.length) % baseArray.length]);
    }

    /**
     * Gets the size of the deque i.e. how many items are there in the deque.
     * @return the size of the deque
     */
    public int size() {
        return size;
    }

    /**
     * Gets the item at the logical place of index in the deque.
     * @param index the index of the logical place
     * @return the item at the index place
     */
    public T get(int index) {
        return baseArray[(baseArray.length + front + index) % baseArray.length];
    }
}
