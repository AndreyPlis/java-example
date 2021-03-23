package collection;

import java.util.*;

public class MultiMapClass<K, V> implements MultiMap<K, V> {

    HashMap<K, ArrayList<V>> tempMap = new HashMap<>();

    @Override
    public int size() {
        return tempMap.size();
    }

    @Override
    public boolean isEmpty() {
        return tempMap.isEmpty();
    }

    @Override
    public boolean containsKey(K key) {
        return tempMap.containsKey(key);
    }

    @Override
    public boolean containsValue(V value) {
        return this.values().contains(value);
    }

    @Override
    public ArrayList<V> get(K key) {
        return tempMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        ArrayList<V> tempList = null;

        if (!tempMap.containsKey(key)) {
            tempList = new ArrayList<V>();
            tempList.add(value);
            tempMap.put(key, tempList);
        } else {
            tempList = tempMap.get(key);
            tempList.add(value);
            tempMap.put(key, tempList);
        }
        return value;
    }

    @Override
    public ArrayList<V> remove(K key) {
        ArrayList<V> tempList = tempMap.get(key);
        tempMap.remove(key);
        return tempList;
    }

    @Override
    public void putAll(MultiMap<K, V> m) {

        for (K tempKey : m.keySet()) {
            if (!this.containsKey(tempKey)) {
                tempMap.put(tempKey, (ArrayList<V>) m.get(tempKey));
            } else {

                ArrayList<V> tempList = tempMap.get(tempKey);
                tempList.addAll(m.get(tempKey));
                tempMap.remove(tempKey);
                tempMap.put(tempKey, tempList);
            }
        }
    }

    @Override
    public void clear() {
        tempMap.clear();
    }

    @Override
    public Set<K> keySet() {
        return tempMap.keySet();
    }

    @Override
    public ArrayList<V> values() {
        ArrayList<V> tempValueList = new ArrayList<V>();

        for (Map.Entry<K, ArrayList<V>> entry : tempMap.entrySet()) {
            tempValueList.addAll(entry.getValue());
        }
        return tempValueList;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {

        if (tempMap.get(key).contains(oldValue)) {
            ArrayList<V> tempList = tempMap.get(key);
            int tempIndex = tempList.indexOf(oldValue);
            tempList.set(tempIndex, newValue);
            this.remove(key);
            tempMap.put(key, tempList);
            return true;
        }
        return false;
    }

    @Override
    public V replace(K key, V value) {
        ArrayList<V> tempList = new ArrayList<V>();
        tempList.add(value);
        tempMap.replace(key, tempList);
        return value;
    }
}
