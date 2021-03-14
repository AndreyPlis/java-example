package collection;

import java.util.*;

public interface MultiMap<T> {

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(T value);

    T get(Object key);

    T put(Object key, T value);

    T remove(Object key);

    void putAll(MultiMap<T> m);

    void clear();

    Set keySet();

    Collection<T> values();

    boolean replace(Object key, T oldValue, T newValue);

    T replace(Object key, T value);

}
