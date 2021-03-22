package collection;

import java.util.*;

public interface MultiMap {

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    Object get(Object key);

    Object put(Object key, Object value);

    Object remove(Object key);

    void putAll(MultiMap m);

    void clear();

    Set keySet();

    Collection values();

    boolean replace(Object key, Object oldValue, Object newValue);

    Object replace(Object key, Object value);

}
