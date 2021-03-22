package collection;

import java.util.*;

public class MultiMapImpl<K, V> implements MultiMap<K, V> {

    private Map<K, HashSet<V>> map = new HashMap<>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        if (map.size() == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean containsKey(K key) {
        if (map.containsKey(key))
            return true;
        else
            return false;
    }

    @Override
    public boolean containsValue(V value) {
        HashSet<V> set = (HashSet<V>) map.values();
        if (set.contains(value))
            return true;
        else
            return false;
    }

    @Override
    public Collection<V> get(Object key) {
        return map.get(key);
    }

    @Override
    public Collection<V> put(K key, V value) {
        if (map.containsKey(key)) {
            HashSet<V> set = (HashSet<V>) map.get(key);
            set.add(value);
            return null;
        } else {
            HashSet<V> set2 = new HashSet<>();
            HashSet<V> setToReturn = new HashSet<>();
            setToReturn.addAll(set2);
            set2.add(value);
            map.put(key, set2);
            return setToReturn;
        }
    }

    @Override
    public void remove(K key) {
        map.remove(key);
    }

    @Override
    public void putAll(MultiMap m) {
        map.putAll((Map<? extends K, ? extends HashSet<V>>) m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return (Collection<V>) map.values();
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        HashSet<V> set = (HashSet<V>) map.get(key);
        set.remove(oldValue);
        set.add(newValue);

        if (map.containsValue(newValue))
            return true;
        else
            return false;
    }

    @Override
    public Collection<V> replace(K key, V value) {
        HashSet<V> set = (HashSet<V>) map.get(key);
        HashSet<V> returnSet = new HashSet<>();
        returnSet.addAll(set);

        if (map.containsKey(key)) {
            set.clear();
            set.add(value);
        }
        return returnSet;
    }
}