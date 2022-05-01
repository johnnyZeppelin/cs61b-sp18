package LinkedList;
public interface List61B<T> {
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    void printList();
    T get(int index);
    int size();
    default boolean isEmpty() { return size() == 0; }
}
