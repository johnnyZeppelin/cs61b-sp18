package ADT61B.Stack;

import DataStructure61B.List61B.Deque.ArrayDeque;

public class Stack<E> extends ArrayDeque<E> implements Stack61B<E> {
    @Override
    public void push(E x) {
        addLast(x);
    }

    @Override
    public E popup() {
        return removeLast();
    }
}
