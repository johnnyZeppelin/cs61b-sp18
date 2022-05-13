package Miscellany.Plaza;

public class Exercise2 {
    public static int[] mergeArray(int[] a, int[] b) {
        int i = 0, j = 0, size = 0;
        int[] res = new int[a.length + b.length];
        while (i != a.length) {
            if (a[i] == b[j]) {
                res[size++] = a[i++];j++;
            } else if (a[i] < b[j]) {
                res[size++] = a[i++];
            } else {
                res[size++] = b[j++];
            }
        }
        while (j != b.length) {
            res[size++] = b[j++];
        }
        int[] r = new int[size];
        for (int k = 0; k < size; ++k) {
            r[k] = res[k];
        }
        return r;
    }

    public static void printIntArray(int[] a) {
        System.out.printf("[");
        for (int i = 0; i < a.length - 1; ++i) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("%d]", a[a.length - 1]);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 7};
        int[] b = new int[]{3, 4, 5, 6};
        printIntArray(mergeArray(a, b));
    }
}
