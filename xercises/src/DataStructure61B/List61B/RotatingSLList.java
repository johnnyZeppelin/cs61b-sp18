package DataStructure61B.List61B;

public class RotatingSLList<T> extends SLList {
    public void rotateRight() {
        T res = (T) removeLast();
        addFirst(res);
    }
}
