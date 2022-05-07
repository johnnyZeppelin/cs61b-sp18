package DataStructure61B.Map61B;

import javafx.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayMap<K, V> implements Map61B<K, V>, Iterable<Pair<K, V>> {
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
        if (index == -1) {
            throw new IllegalArgumentException("Key #" + key + "# does not exist in the map.");
        }
        return valueData.get(index);
        //return index == -1 ? null : valueData.get(index);
    }

    @Override
    public List<K> keys() {
        return keyData;
    }

    @Override
    public int size() {
        return size;
    }

    private class ArrayMapIterator implements Iterator<Pair<K, V>> {
        private transient int wizPosK, wizPosV;

        public ArrayMapIterator() {
            wizPosK = wizPosV = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPosK  < size;
        }

        @Override
        public Pair<K, V> next() {
            return new Pair<>(keyData.get(wizPosK++), valueData.get(wizPosV++));
        }
    }

    @NotNull
    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new ArrayMapIterator();
    }

    public static <Klerp, Vlerp> ArrayMap<Klerp, Vlerp> of(Pair<Klerp, Vlerp>... pairs) {
        ArrayMap<Klerp, Vlerp> returnMap = new ArrayMap<>();
        for (Pair<Klerp, Vlerp> i : pairs) returnMap.put(i.getKey(), i.getValue());
        return returnMap;
    }
    public static <Klerp, Vlerp> ArrayMap<Klerp, Vlerp> of(List<Pair<Klerp, Vlerp>> pairs) {
        ArrayMap<Klerp, Vlerp> returnMap = new ArrayMap<>();
        for (Pair<Klerp, Vlerp> i : pairs) returnMap.put(i.getKey(), i.getValue());
        return returnMap;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;

        ArrayMap<K, V> o = (ArrayMap<K, V>) obj;
        if (o.size != size()) return false;
        for (Object p : o) {
            if(!(containsKey(((Pair<K, V>) p).getKey())) ||
                    !(((Pair<K, V>) p).getValue().equals(get(((Pair<K, V>) p).getKey())))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("[");
        for (Pair<K, V> o : this) {
            returnSB.append('(');
            returnSB.append(o.toString());
            returnSB.append(')');
        }
        return returnSB.append(']').toString();
    }
}
