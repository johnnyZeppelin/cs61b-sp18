package DataStructure61B.Map61B;

import java.util.List;

public class Map61BHelper {
    public static <K, V> V get(Map61B<K, V> map61B, K key) {
        return map61B.get(key);
    }

    /**
     * Returns the maximum of all keys in the given ArrayMap.
     * Works only if keys can be compared.
     * @param map61B the map containing the keys
     * @param <K> the type of the keys
     * @param <V> the type of the value of each key
     * @return the maximum of all keys in the given ArrayMap
     */
    public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map61B) {
        List<K> keys = map61B.keys();
        K maxOne = keys.get(0);
        for (K key : keys) {
            if (key.compareTo(maxOne) > 0) maxOne = key;
        }
        return maxOne;
    }
}
