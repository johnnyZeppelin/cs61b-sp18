package ADT61B.Tree;

public class Entry<E extends Comparable<E>> {
    E value;
    Entry<E> leftChild, rightChild;

    public Entry(E value) {
        this.value = value;
        leftChild = rightChild = null;
    }

    public Entry(E v, Entry<E> l, Entry<E> r) {
        value = v;
        leftChild = l;
        rightChild = r;
    }
}