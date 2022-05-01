package LinkedList;

public class RotatingSLList<T> extends SLList {
    public void rotateRight() {
        T res = (T) removeLast();
        addFirst(res);
    }
}
