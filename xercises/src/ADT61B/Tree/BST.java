package ADT61B.Tree;

import ADT61B.Queue.Queue;
import ADT61B.Stack.Stack;
import DataStructure61B.List61B.Deque.ArrayDeque;
import DataStructure61B.List61B.List61B;

public class BST<E extends Comparable<E>> implements Tree61B<E> {
    private Entry<E> root;
    private int size;

    public BST(Entry<E> root) {
        this.root = root;
        this.size = 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E x) {
        if (contains(x)) return;
        Entry<E> p = root;
        Entry<E> pre = p;
        boolean loadLeft = root.value.compareTo(x) > 0;
        while (p != null || p != null) {
            pre = p;
            if (p.value.compareTo(x) > 0) {
                p = p.leftChild;
                if (p == null) break;
            } else {
                p = p.rightChild;
                if (p == null) {
                    loadLeft = false;
                    break;
                }
            }
        }
        if (loadLeft) pre.leftChild = new Entry<>(x);
        else pre.rightChild = new Entry<>(x);
    }

    @Override
    public Entry<E> get(E x) {
        if (!contains(x)) return null;
        Entry<E> p = root;
        while (p.leftChild != null || p.rightChild != null) {
            if (root.value.compareTo(x) > 0) {
                p = p.leftChild;
            } else if (
                    root.value.compareTo(x) < 0
            ) {
                p = p.rightChild;
            } else {
                break;
            }
            if (p == null) return null;
        }
        return p;
    }

    @Override
    public boolean contains(E x) {
        Entry<E> p = root;
        boolean res = root.value.toString().equals(x.toString());
        while (p.leftChild != null || p.rightChild != null) {
            if (root.value.compareTo(x) > 0) {
                p = p.leftChild;
            } else if (
                    root.value.compareTo(x) < 0
            ) {
                p = p.rightChild;
            } else {
                return true;
            }
            if (p == null) return false;
        }
        return res;
    }

    @Override
    public E delete(E x) {
        return null;
    }

    private List61B<E>
    levelOrderTraversal(List61B<E> l, Queue<Entry<E>> q, Entry<E> en) {
        if (en == null) return l;
        l.addLast(en.value);
        if (en.leftChild != null) q.enqueue(en.leftChild);
        if (en.rightChild != null) q.enqueue(en.rightChild);
        if (q.isEmpty()) return l;
        return levelOrderTraversal(l, q, q.dequeue());
    }

    private List61B<E>
    preOrderTraversal(List61B<E> l, Entry<E> en) {
        if (en != null) {
            l.addLast(en.value);
            preOrderTraversal(l, en.leftChild);
            preOrderTraversal(l, en.rightChild);
        }
        return l;
    }

    private List61B<E>
    inOrderTraversal(List61B<E> l, Entry<E> en) {
        if (en != null) {
            inOrderTraversal(l, en.leftChild);
            l.addLast(en.value);
            inOrderTraversal(l, en.rightChild);
        }
        return l;
    }

    private List61B<E>
    inOrderTraversal(List61B<E> l, Stack<Entry<E>> s, Entry<E> en) {
        if (en == null) return l;
        Entry<E> p = en;
        while (p != null) {
            s.push(p);
            p = p.leftChild;
        }
        while (!s.isEmpty()) {
            p = s.popup();
            l.addLast(p.value);
            inOrderTraversal(l, new Stack<>(), p.rightChild);
        }
        return l;
    }

    private List61B<E>
    postOrderTraversal(List61B<E> l, Entry<E> en) {
        if (en != null) {
            postOrderTraversal(l, en.leftChild);
            postOrderTraversal(l, en.rightChild);
            l.addLast(en.value);
        }
        return l;
    }

    private List61B<E> traversalStrategy(int x) {
        List61B<E> r = new ArrayDeque<>();
        switch (x) {
            case 0:
                return preOrderTraversal(r, root);
            case 1:
                /* Stack<Entry<E>> s = new Stack<>();
                return inOrderTraversal(r, s, root);
                 */
                return inOrderTraversal(r, root);
            case 2:
                return postOrderTraversal(r, root);
            default:
                Queue<Entry<E>> q = new Queue<>();
                return levelOrderTraversal(r, q, root);
        }
    }

    private List61B<E> traversal() {
        return traversalStrategy(2);
    }

    public void printTree() {
        List61B<E> result = traversal();
        if (result == null) result = new ArrayDeque<>();
        result.printList();
    }
}
