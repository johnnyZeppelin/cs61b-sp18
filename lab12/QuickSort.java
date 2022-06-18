import edu.princeton.cs.algs4.Queue;

public class QuickSort {
    /**
     * Returns a new queue that contains the given queues catenated together.
     * <p>
     * The items in q2 will be catenated after all of the items in q1.
     */
    private static <Item extends Comparable> Queue<Item> catenate(Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> catenated = new Queue<Item>();
        for (Item item : q1) {
            catenated.enqueue(item);
        }
        for (Item item : q2) {
            catenated.enqueue(item);
        }
        return catenated;
    }

    /**
     * Returns a random item from the given queue.
     */
    private static <Item extends Comparable> Item getRandomItem(Queue<Item> items) {
        int pivotIndex = (int) (Math.random() * items.size());
        Item pivot = null;
        // Walk through the queue to find the item at the given index.
        for (Item item : items) {
            if (pivotIndex == 0) {
                pivot = item;
                break;
            }
            pivotIndex--;
        }
        return pivot;
    }

    /**
     * Partitions the given unsorted queue by pivoting on the given item.
     *
     * @param unsorted A Queue of unsorted items
     * @param pivot    The item to pivot on
     * @param less     An empty Queue. When the function completes, this queue will contain
     *                 all of the items in unsorted that are less than the given pivot.
     * @param equal    An empty Queue. When the function completes, this queue will contain
     *                 all of the items in unsorted that are equal to the given pivot.
     * @param greater  An empty Queue. When the function completes, this queue will contain
     *                 all of the items in unsorted that are greater than the given pivot.
     */
    private static <Item extends Comparable> void partition(
            Queue<Item> unsorted, Item pivot,
            Queue<Item> less, Queue<Item> equal, Queue<Item> greater) {
        // Your code here!
        for (Item item : unsorted) {
            int cmp = pivot.compareTo(item);
            if (cmp < 0) greater.enqueue(item);
            else if (cmp == 0) equal.enqueue(item);
            else less.enqueue(item);
        }
    }

    /**
     * Returns a Queue that contains the given items sorted from least to greatest.
     */
    public static <Item extends Comparable> Queue<Item> quickSort(
            Queue<Item> items) {
        // Your code here! (DONE)
        if (items.size() < 2) return items;
        Queue<Item> less = new Queue<>(), equal = new Queue<>(), greater = new Queue<>();
        Item pivot = getRandomItem(items);
        partition(items, pivot, less, equal, greater);
        return catenate(catenate(quickSort(less), equal), quickSort(greater));
    }

    private static <Item extends Comparable> void printQueue(Queue<Item> items) {
        if (items == null) {
            System.out.println();
            return;
        }
        for (Item item : items) {
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> toSort = new Queue<>();
        toSort.enqueue(72);
        toSort.enqueue(13);
        toSort.enqueue(196);
        toSort.enqueue(3);
        toSort.enqueue(0);
        toSort.enqueue(-14);
        toSort.enqueue(16);
        toSort.enqueue(3);
        toSort.enqueue(49);
        toSort.enqueue(82);

        printQueue(toSort);

        System.out.println("Result:");

        System.out.print("s: ");
        printQueue(QuickSort.quickSort(toSort));
        System.out.print("o: ");
        printQueue(toSort);
    }
}
