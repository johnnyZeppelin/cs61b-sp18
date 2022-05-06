package DataStructure61B.List61B;

public class VengefulSLList<T> extends SLList<T> {
    private SLList<T> deletedItems;
    public VengefulSLList() {
        super();
        deletedItems = new SLList<>();
    }

    public void printLostItems() {
        deletedItems.printList();
    }

    @Override
    public T removeLast() {
        T res = super.removeLast();
        deletedItems.addLast(res);
        return res;
    }
}
