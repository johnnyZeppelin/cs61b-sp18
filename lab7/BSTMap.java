import javafx.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BSTMap<K, V> implements Map61B<K, V> {
    private Entry<K, V> node;
    private int size;

    public BSTMap() {
        node = new Entry<>();
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(K key) {
        if (size == 0 || !containsKey(key)) {
            //System.out.println("No result");
            return null;
        }
        Entry<K, V> p = node;
        while (true) {
            if (p.key.equals(key)) return p.value;
            if (p.key.toString().compareTo(key.toString()) > 0) p = p.left;
            else p = p.right;
        }
    }

    @Override
    public boolean containsKey(K key) {
        if (size == 0) return false;
        Entry<K, V> p = node;
        while (true) {
            if (p.key.equals(key)) return true;
            if (p.key.toString().compareTo(key.toString()) > 0) {
                if (p.left == null) break;
                else p = p.left;
            } else {
                if (p.right == null) break;
                else p = p.right;
            }
        }
        return false;
    }

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            node = new Entry<>(key, value);
            ++size;
            return;
        }
        if (containsKey(key)) return;
        Entry<K, V> p = node;
        boolean isL;
        while (true) {
            if (p.key.toString().compareTo(key.toString()) > 0) {
                if (p.left == null) {
                    isL = true;
                    break;
                } else p = p.left;
            } else {
                if (p.right == null) {
                    isL = false;
                    break;
                } else p = p.right;
            }
        }
        if (isL) p.left = new Entry<>(key, value);
        else p.right = new Entry<>(key, value);
        ++size;
    }

    private void sendInEntries(Set<K> kSet, Entry<K, V> p) {
        if (p == null) return;
        kSet.add(p.key);
        sendInEntries(kSet, p.left);
        sendInEntries(kSet, p.right);
    }

    @Override
    public Set<K> keySet() {
        Set<K> ks = new TreeSet<>();
        sendInEntries(ks, node);
        return ks;
    }

    @Override
    public void clear() {
        node = null;
        size = 0;
    }

    @Override
    public V remove(K key) {
        if (size == 0 || !containsKey(key)) return null;
        Entry<K, V> p = node;
        Entry<K, V> subP = null;
        boolean isL = true;
        V rm = get(key);
        while (true) {
            if (p.key.equals(key)) break;
            else if (p.key.toString().compareTo(key.toString()) > 0) {
                subP = p;
                isL = true;
                p = p.left;
            } else {
                subP = p;
                isL = false;
                p = p.right;
            }
        }
        if (p.left == null && p.right == null) {
            if (subP != null) {
                if (isL) subP.left = null;
                else subP.right = null;
            } else node = null;
        } else if (p.left != null && p.right == null) {
            Entry<K, V> rep = p.left;
            if (rep.right == null) {
                p.key = rep.key;
                p.value = rep.value;
                p.left = rep.left;
            } else {
                Entry<K, V> subRep = p;
                while (rep.right != null) {
                    subRep = rep;
                    rep = rep.right;
                }
                p.key = rep.key;
                p.value = rep.value;
                subRep.right = null;
            }

        } else if (p.left == null && p.right != null) {
            Entry<K, V> rep = p.right;
            if (rep.left == null) {
                p.key = rep.key;
                p.value = rep.value;
                p.right = rep.right;
            } else {
                Entry<K, V> subRep = p;
                while (rep.left != null) {
                    subRep = rep;
                    rep = rep.left;
                }
                p.key = rep.key;
                p.value = rep.value;
                subRep.left = null;
            }
        } else {
            Entry<K, V> rep = p.left;
            if (rep.right == null) {
                p.key = rep.key;
                p.value = rep.value;
                p.left = rep.left;
            } else {
                Entry<K, V> subRep = p;
                while (rep.right != null) {
                    subRep = rep;
                    rep = rep.right;
                }
                p.key = rep.key;
                p.value = rep.value;
                subRep.right = null;
            }
        }
        --size;
        return rm;
    }

    @Override
    public V remove(K key, V value) {
        if (size == 0 || !containsKey(key) || get(key) != value)
            return null;
        remove(key);
        return value;
    }

    @NotNull
    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    private class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> left, right;

        public Entry() {
            key = null;
            value = null;
            left = right = null;
        }

        public Entry(K k, V v) {
            key = k;
            value = v;
            left = right = null;
        }

        public Entry(Entry<K, V> l, Pair<K, V> pair, Entry<K, V> r) {
            key = pair.getKey();
            value = pair.getValue();
            left = l;
            right = r;
        }

        public Entry(Pair<K, V> pair) {
            key = pair.getKey();
            value = pair.getValue();
            left = right = null;
        }
    }
}
