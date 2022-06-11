package ADT61B.Queue;

import DataStructure61B.List61B.Deque.ArrayDeque;

public class Queue<E> extends ArrayDeque<E> implements Queue61B<E> {
    @Override
    public void enqueue(E x) {
        addLast(x);
    }

    @Override
    public E dequeue() {
        return removeFirst();
    }
}
