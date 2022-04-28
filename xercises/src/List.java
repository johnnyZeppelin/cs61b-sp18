public interface List<T> {
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    void printDeque();
    boolean isEmpty();
    T get(int index);
    default int size() {
        return size();
    }
}
