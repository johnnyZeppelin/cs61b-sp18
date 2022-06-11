package ADT61B.Tree;

public interface Tree61B<E> {
    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    void add(E x);

    Entry<E> get(E x);

    boolean contains(E x);

    E delete(E x);

    default void adjust() {
        return;
    }
}
