package collection;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class HashMultiMap<K,V> implements MultiMap<K,V>{
    private LinkedHashMap<K, HashSet<V>> map = new LinkedHashMap<>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(V value) {
        AtomicBoolean flag = new AtomicBoolean(false);
        map.forEach((k,v)->{
            if (v.contains(value))
                flag.set(true);
        });
        return flag.get();
    }

    @Override
    public HashSet<V> get(K key) {
        return map.get(key);
    }

    @Override
    public boolean put(K key, V value) {
        return map.get(key).add(value);
    }

    @Override
    public void remove(K key) {
        map.remove(key);
    }

    @Override
    public void putAll(MultiMap<K, V> m) {
        m.keySet().forEach(k -> {
            map.put(k,m.get(k));
        });
    }

    @Override
    public void clear() {
        map.forEach((k,v)->{
            v.clear();
        });
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public HashSet<HashSet<V>> values() {
        HashSet<HashSet<V>> set = new HashSet<>();
        map.forEach((k,v)->{
            set.add(map.get(k));
        });
        return set;
    }

    @Override
    public void replace(K key, V oldValue, V newValue) {
        map.get(key).remove(oldValue);
        map.get(key).add(newValue);
    }

    @Override
    public void remove(K key, V value) {
        map.get(key).remove(value);
    }
}
