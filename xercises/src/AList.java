public class AList<T> {
    private T[] arr;
    private int size;

    public AList() {
        arr = (T[]) new Object[8];
        size = 0;
    }
    private void extendArr() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < size; ++i) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    private void halfArr() {
        T[] newArr = (T[]) new Object[arr.length / 2];
        for (int i = 0; i < size; ++i) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    public void addFirst(T item) {
        if (size >= arr.length) extendArr();
        arr[size++] = item;
    }
    public T removeFirst() {
        if (size == 0) return null;
        if (size <= arr.length * 0.25) halfArr();
        return arr[--size];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printList() {
        for (int i = 0; i < size; ++i) {
            System.out.println(arr[i]);
        }
    }
    public T get(int index) {
        return index < 0 || index >= size ? null : arr[index];
    }
}
