public class LinkedListDeque<T> {
    /**
     * The class of nodes of type {@code T} on which the deque is based.
     */
    private class TNode {
        public TNode prev;
        public T item;
        public TNode next;

        /**
         * <B>Constructor 1</B>
         * <p>
         *     To construct an empty TNode.
         * </p>
         */
        public TNode() {
            prev = null;
            item = null;
            next = null;
        }

        /**
         * <B>Constructor 2</B>
         * <p>
         *     To construct a TNode with previous, next nodes and the item.
         * </p>
         * @param p the previous node
         * @param i the item, stored in this node
         * @param n the next node
         */
        public TNode(TNode p, T i, TNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /**
     * The fields.
     */
    private final TNode sentinelFore; //the front sentinel
    private final TNode sentinelHind; //the back sentinel
    private int size; //the size of the deque

    /**
     * <B>
     *     <p>Constructor 1</p>
     * </B>
     * To create an empty linked list deque.
     */
    public LinkedListDeque() {
        sentinelFore = new TNode();
        sentinelHind = new TNode();
        sentinelFore.next = sentinelHind;
        sentinelHind.prev = sentinelFore;
        size = 0;
    }

    /**
     * <B>
     *     <p>Constructor 2</p>
     * </B>
     * To create a deep copy of other.
     * <p>
     *     Creating a deep copy means that you create an entirely new LinkedListDeque,
     *     with the exact same items as other. However, they should be different objects,
     *     i.e. if you change other, the new LinkedListDeque you created should not change as well.
     * </p>
     *
     * @param other the object to create a deep copy of
     */
    public LinkedListDeque(LinkedListDeque other) {
        /* TO BE IMPLEMENTED */
        sentinelFore = new TNode();
        sentinelHind = new TNode();
        sentinelFore.next = sentinelHind;
        sentinelHind.prev = sentinelFore;
        size = 0;
        for (int i = 0; i < other.size; ++i) {
            this.addLast((T) other.get(i));
        }
    }

    /**
     * To add an item of type {@code T} to the front of the deque.
     * @param item the item of type {@code T} to add
     */
    public void addFirst(T item) {
        TNode node = new TNode(sentinelFore, item, sentinelFore.next);
        sentinelFore.next.prev = node;
        sentinelFore.next = node;
        ++size;
        /* ATTENTION!:
        This works for both cases when you walk through the deque in two directions respectively but may create two different nodes to realize.
        sentinelFore.next = new TNode(new TNode(sentinelFore, item, sentinelFore.next), sentinelFore.next.item, sentinelFore.next.next);
        sentinelFore = new TNode(null, sentinelFore.item, new TNode(sentinelFore, item, sentinelFore.next));
         */
    }

    /**
     * To add an item of type {@code T} to the back of the deque.
     * @param item the item of type {@code T} to add
     */
    public void addLast(T item) {
        TNode node = new TNode(sentinelHind.prev, item, sentinelHind);
        sentinelHind.prev.next = node;
        sentinelHind.prev = node;
        ++size;
    }

    /**
     * To check if deque is empty.
     * @return {@code true} if deque is empty;
     * {@code false} otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * To give the size of the deque.
     * @return the size of the deque
     */
    public int size() {
        return size;
    }

    /**
     * <p>To print the items in the deque from first to last, separated by space. </p>
     * <p>Once all the items have been printed, print out a new line. </p>
     */
    public void printDeque() {
        TNode p = sentinelFore;
        for (int i = 0; i < size - 1; ++i) {
            p = p.next;
            System.out.print(p.item + " ");
        }
        p = p.next;
        System.out.println(p.item);
    }

    /**
     * To remove and return the item at the front of the deque.
     * If no such item exists, it returns null.
     * <p>
     *     <i>*
     *     Basically, the remove methods are the reason why we prefer the circular approach.
     *     We have to check the size of the deque since the two sentinels do not make a ring.
     *     </i>
     * </p>
     * @return The item at the front of the deque.
     * <p>If no such item exists, it returns null.</p>
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T i = sentinelFore.next.item;
            sentinelFore.next = sentinelFore.next.next;
            sentinelFore.next.prev = sentinelFore;
            --size;
            return i;
        }
    }

    /**
     * To remove and return the item at the back of the deque.
     * If no such item exists, returns null.
     * @return The item at the back of the deque.
     * <p>If no such item exists, it returns null.</p>
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T i = sentinelHind.prev.item;
            sentinelHind.prev = sentinelHind.prev.prev;
            sentinelHind.prev.next = sentinelHind;
            --size;
            return i;
        }
    }

    /**
     * To get the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. This method uses iteration instead of recursion.
     * Must not alter the deque!
     * <p>
     *     <i>*
     *     This is another point comparing to the circular approach,
     *     which shows that we cannot get the index greater than the size of the deque
     *     while we can get it as the modulo result of the size in circular way if necessary.
     *     </i>
     * </p>
     * @param index the position of the item
     * @return The item at the given index.
     * <p>If no such item exists, return null.</p>
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            TNode p = sentinelFore;
            for (int i = 0; i < index + 1; ++i) {
                p = p.next;
            }
            return p.item;
        }
    }

    /**
     * Same as get, but uses recursion.
     * @param index the position of the item
     * @return The item at the given index.
     * <p>If no such item exists, return null. </p>
     */
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            return pointerAt(index).item;
        }
    }

    /**
     * To help implement getRecursive in recursive way.
     * @param index the position the pointer should move to
     * @return the pointer in the target position
     */
    private TNode pointerAt(int index) {
        /* but the getRecursive has already make sure index can only be from 0 to size - 1 here.
        if (index < 0 || index >= size) {
            return null;
        }*/
        if (index == 0) {
            return sentinelFore.next;
        } else {
            return pointerAt(index - 1).next;
        }
    }
}
