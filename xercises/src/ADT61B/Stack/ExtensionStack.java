package ADT61B.Stack;

import java.util.LinkedList;

public class ExtensionStack<E> extends LinkedList<E> {
    public void push(E x) {
        add(x);
    }
}
