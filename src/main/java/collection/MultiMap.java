package collection;

import java.util.*;

public interface MultiMap<K, V> {

    int size();

    boolean isEmpty();

    boolean containsKey(K key);

    boolean containsValue(V value);

    Collection<V> get(K key);

    V put(K key, V value);

    Collection<V> remove(K key);

    void putAll(MultiMap<K, V> m);

    void clear();

    Set<K> keySet();

    Collection<V> values();

    boolean replace(K key, V oldValue, V newValue);

    V replace(K key, V value);

}

