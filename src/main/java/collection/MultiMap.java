package collection;

import java.util.*;

public interface MultiMap<K, T> {

    int size();

    boolean isEmpty();

    boolean containsKey(K key);

    boolean containsValue(T value);

    Set<T> get(K key);

    Set<T> put(K key, Set<T> value);

    void put(K key, T value);

    Set<T> remove(K key);

    void remove(K key, T value);

    void putAll(MultiMap<K, T> m);

    void clear();

    Set keySet();

    Collection<Set<T>> values();

    boolean replace(K key, T oldValue, T newValue);

    Set<T> replace(K key, Set<T> value);
}
