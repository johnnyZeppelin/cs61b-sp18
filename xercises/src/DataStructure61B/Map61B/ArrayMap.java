package DataStructure61B.Map61B;

import java.util.ArrayList;
import java.util.List;

public class ArrayMap<K, V> implements Map61B<K, V>{
    /**
     * Stores the data of keys.
     */
    private final transient ArrayList<K> keyData;
    /**
     * Stores the data of values.
     */
    private final transient ArrayList<V> valueData;
    /**
     * The size of the map.
     */
    private int size;

    public ArrayMap() {
        keyData = new ArrayList<>();
        valueData = new ArrayList<>();
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = keyData.indexOf(key);
        if (index == -1) {
            keyData.add(key);
            valueData.add(value);
            ++size;
        } else {
            valueData.set(index, value);
        }
    }

    @Override
    public boolean containsKey(K key) {
        return keyData.contains(key);
    }

    @Override
    public V get(K key) {
        int index = keyData.indexOf(key);
        return index == -1 ? null : valueData.get(index);
    }

    @Override
    public List<K> keys() {
        return keyData;
    }

    @Override
    public int size() {
        return size;
    }
}
