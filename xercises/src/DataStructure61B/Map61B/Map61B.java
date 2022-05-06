package DataStructure61B.Map61B;

import java.util.List;

/**
 * Maps let you associate keys with values,
 * for example, the statement "Josh's score on the exam is 0"
 * could be stored in a Map that associates students to their exam scores.
 * A map is the Java equivalent of a Python dictionary.
 * @param <K> the type of the key
 * @param <V> the type of the value
 */
public interface Map61B<K, V> {
    /**
     * Associates key with values.
     * @param key the key
     * @param value the value
     */
    void put(K key, V value);

    /**
     * Checks if the map contains the key.
     * @param key the key
     * @return true if the map contains the key;
     * false otherwise
     */
    boolean containsKey(K key);

    /**
     * Returns value, assuming the key exists.
     * @param key the key
     * @return the value of the key
     */
    V get(K key);

    /**
     * Returns a list of all keys.
     * @return the list of all keys
     */
    List<K> keys();

    /**
     * Returns the number of keys.
     * @return the number of keys
     */
    int size();
}
