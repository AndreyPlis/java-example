package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MultiMapImpl<K, T> implements MultiMap<K, T> {

    private HashMap<K, Set<T>> table = new HashMap<K, Set<T>>();

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public boolean isEmpty() {
        return table.isEmpty();
    }

    @Override
    public boolean containsKey(K key) {
        return table.containsKey(key);
    }

    @Override
    public boolean containsValue(T value) {
        for (Set<T> e : this.values())
            if (e.contains(value))
                return true;
        return false;
    }

    @Override
    public Set<T> get(K key) {
        return table.get(key);
    }

    /*
    Returns the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public Set<T> put(K key, Set<T> value) {
        return table.put(key, value);
    }

    @Override
    public void put(K key, T value) {
        if (table.containsKey(key)) {
            table.get(key).add(value);
        } else {
            Set<T> t = new HashSet<T>();
            t.add(value);
            table.put(key, t);
        }
    }

    /*
    Returns the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public Set<T> remove(K key) {
        return table.remove(key);
    }

    @Override
    public void remove(K key, T value) {
        table.get(key).remove(value);
    }

    @Override
    public void putAll(MultiMap<K, T> m) {
        for (Object e : m.keySet()) {
            table.put((K) e, m.get((K) e));
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
    public Collection<Set<T>> values() {
        return table.values();
    }

    @Override
    public boolean replace(K key, T oldValue, T newValue) {
        if (table.get(key).contains(oldValue)) {
            table.get(key).remove(oldValue);
            table.get(key).add(newValue);
            return true;
        }

        return false;
    }

    /*
    Replaces the entry for the specified key only if it is currently mapped to some value.
    Returns the previous value associated with the specified key, or null if there was no mapping for the key.
     */
    @Override
    public Set<T> replace(K key, Set<T> value) {
        return table.replace(key, value);
    }

    public void print() {
        for (Object e : table.keySet()) {
            System.out.println(e);
            System.out.println(table.get(e));
            System.out.println();
        }
    }
}
