package collection;

import java.util.*;

public interface MultiMap<K,V> {

    int size();

    boolean isEmpty();

    boolean containsKey(K key);

    boolean containsValue(V value);

    HashSet<V> get(K key);

    boolean put(K key, V value);

    void remove(K key);

    void putAll(MultiMap<K,V> m);

    void clear();

    Set<K> keySet();

    HashSet<HashSet<V>> values();

    void replace(K key, V oldValue, V newValue);

    void remove(K key, V value);

}
