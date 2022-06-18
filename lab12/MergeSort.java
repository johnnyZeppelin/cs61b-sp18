import edu.princeton.cs.algs4.Queue;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     * <p>
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param q1 A Queue in sorted order from least to greatest.
     * @param q2 A Queue in sorted order from least to greatest.
     * @return The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /**
     * Returns a queue of queues that each contain one item from items.
     */
    private static <Item extends Comparable> Queue<Queue<Item>>
    makeSingleItemQueues(Queue<Item> items) {
        // Your code here!
        Queue<Queue<Item>> qOq = new Queue<>();
        for (Item item : items) {
            Queue<Item> q = new Queue<>();
            q.enqueue(item);
            qOq.enqueue(q);
        }
        return qOq;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     * <p>
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param q1 A Queue in sorted order from least to greatest.
     * @param q2 A Queue in sorted order from least to greatest.
     * @return A Queue containing all of the q1 and q2 in sorted order, from least to
     * greatest.
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(
            Queue<Item> q1, Queue<Item> q2) {
        // Your code here!
        Queue<Item> qqq = new Queue<>();
        while (!(q1.isEmpty() && q2.isEmpty())) {
            qqq.enqueue(getMin(q1, q2));
        }
        return qqq;
    }

    /**
     * Returns a Queue that contains the given items sorted from least to greatest.
     */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        // Your code here! (DONE)
        if (items.size() < 2) return items;
        Queue<Item> q1 = new Queue<>(), q2 = new Queue<>();
        for (Item x : items) q2.enqueue(x);
        for (int i = 0; i < q2.size() / 2; ++i) q1.enqueue(q2.dequeue());
        return mergeSortedQueues(mergeSort(q1), mergeSort(q2));
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
        toSort.enqueue(16);
        toSort.enqueue(72);
        toSort.enqueue(-97);
        toSort.enqueue(3);
        toSort.enqueue(196);
        toSort.enqueue(52);
        toSort.enqueue(3);
        toSort.enqueue(0);
        toSort.enqueue(49);

        printQueue(toSort);

        System.out.println("Result:");

        System.out.print("s: ");
        printQueue(MergeSort.mergeSort(toSort));
        System.out.print("o: ");
        printQueue(toSort);
    }
}
