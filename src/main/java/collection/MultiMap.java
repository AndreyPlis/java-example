package collection;

import java.util.*;

public interface MultiMap<K, V> {

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    void putAll(MultiMap<K, V> m);

    void clear();

    Set<K> keySet();

    Collection<V> values();

    boolean replace(K key, V oldValue, V newValue);

    V replace(K key, V value);

}
