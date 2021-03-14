package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MultiMapImpl<T> implements MultiMap<T> {

    private HashMap<Object, T> table = new HashMap<Object, T>();

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public boolean isEmpty() {
        return table.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return table.containsKey(key);
    }

    @Override
    public boolean containsValue(T value) {
        return table.containsValue(value);
    }

    @Override
    public T get(Object key) {
        return table.get(key);
    }

    @Override
    public T put(Object key, T value) {
        return table.put(key, value);
    }

    @Override
    public T remove(Object key) {
        return table.remove(key);
    }

    @Override
    public void putAll(MultiMap<T> m) {
        for (Object e : m.keySet()) {
            table.put(e, m.get(e));
        }
    }

    @Override
    public void clear() {
        table.clear();
    }

    @Override
    public Set keySet() {
        return table.keySet();
    }

    @Override
    public Collection<T> values() {
        return table.values();
    }

    @Override
    public boolean replace(Object key, T oldValue, T newValue) {
        return table.replace(key, oldValue, newValue);
    }

    @Override
    public T replace(Object key, T value) {
        return table.replace(key, value);
    }
}
