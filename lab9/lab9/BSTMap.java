package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Your name here
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Returns the value mapped to by KEY in the subtree rooted in P.
     * or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        //throw new UnsupportedOperationException();
        if (p == null) return null;
        int cmp = key.compareTo(p.key);
        if (cmp < 0) return getHelper(key, p.left);
        else if (cmp > 0) return getHelper(key, p.right);
        else return p.value;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        //throw new UnsupportedOperationException();
        return getHelper(key, root);
    }

    /**
     * Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
     * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        //throw new UnsupportedOperationException();
        if (p == null) {
            p = new Node(key, value);
            ++size;
        }
        int cmp = key.compareTo(p.key);
        if (cmp < 0) p.left = putHelper(key, value, p.left);
        else if (cmp > 0) p.right = putHelper(key, value, p.right);
        else p.value = value;
        return p;
    }

    /**
     * Inserts the key KEY
     * If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        //throw new UnsupportedOperationException();
        root = putHelper(key, value, root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        //throw new UnsupportedOperationException();
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    private void keySetHelper(Set<K> set, Node node) {
        if (node == null) return;
        keySetHelper(set, node.left);
        set.add(node.key);
        keySetHelper(set, node.right);
    }

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        //throw new UnsupportedOperationException();
        Set<K> res = new HashSet<>();
        keySetHelper(res, root);
        return res;
    }

    private void exc(Node p1, Node p2) {
        K k = p1.key;
        V v = p1.value;
        p1.key = p2.key;
        p1.value = p2.value;
        p2.key = k;
        p2.value = v;
    }

    private V dltMin(Node p) {
        if (p == null || p.left == null) throw new IllegalArgumentException();
        V r = p.value;
        if (p.left.right == null) {
            exc(p, p.left);
            p.left = p.left.left;
        } else {
            Node tp = p.left, ttp = tp;
            while (tp.right != null) {
                ttp = tp;
                tp = tp.right;
            }
            exc(p, tp);
            ttp.right = null;
        }
        return r;
    }

    private V dltMax(Node p) {
        if (p == null || p.right == null) throw new IllegalArgumentException();
        V r = p.value;
        if (p.right.left == null) {
            exc(p, p.right);
            p.right = p.right.right;
        } else {
            Node tp = p, ttp = tp;
            while (tp.left != null) {
                ttp = tp;
                tp = tp.left;
            }
            exc(p, tp);
            ttp.left = null;
        }
        return r;
    }

    private V dltNode(Node p) {
        if (p.left == null && p.right == null) {
            p.key = null;
            p.value = null;
            return null;
        } else if (p.left != null) {
            return dltMin(p);
        } else {
            return dltMax(p);
        }
    }

    private V removeHelper(K key, Node p) {
        if (p == null) return null;
        int cmp = key.compareTo(p.key);
        if (cmp < 0) return removeHelper(key, p.left);
        else if (cmp > 0) return removeHelper(key, p.right);
        else return dltNode(p);
    }

    /**
     * Removes KEY from the tree if present
     * returns VALUE removed,
     * null on failed removal.
     */
    @Override
    public V remove(K key) {
        //throw new UnsupportedOperationException();
        if (key == null || get(key) == null) return null;
        --size;
        return removeHelper(key, root);
    }

    /**
     * Removes the key-value entry for the specified key only if it is
     * currently mapped to the specified value.  Returns the VALUE removed,
     * null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        //throw new UnsupportedOperationException();
        if (key == null || get(key) != value) return null;
        remove(key);
        return value;
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
