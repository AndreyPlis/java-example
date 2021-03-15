package collection;

import java.util.*;

public class MyMultiMapClass<K, V> implements MultiMap<K, V> {

    private int size;
    private int hash;
    private K key;
    private V value;
    private MyMultiMapClass<K, V> next;
    private MyMultiMapClass<K, V> endData = null;
    private Set<K> mySet = new HashSet<K>();
    private Collection<V> myCollection = new HashSet<V>();

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        MyMultiMapClass<K, V> temp = this;

        for (int i = 0; i < this.size; i++) {
            if (temp.hash == key.hashCode())
                return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        MyMultiMapClass<K, V> temp = this;

        for (int i = 0; i < this.size; i++) {
            if (temp.value.equals(value))
                return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        MyMultiMapClass<K, V> temp = this;

        for (int i = 0; i < this.size; i++) {
            if (temp.hash == key.hashCode())
                return temp.value;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {

        if (mySet.contains(key))
            return null;

        mySet.add(key);
        myCollection.add(value);

        if (endData != null) {
            endData.next = new MyMultiMapClass<K, V>();
            endData.next.key = key;
            endData.next.value = value;
            endData.next.hash = key.hashCode();
            endData = endData.next;
            this.size = ++this.size;
        }

        if (endData == null && this.key != null) {
            this.next = new MyMultiMapClass<K, V>();
            this.next.key = key;
            this.next.value = value;
            this.next.hash = key.hashCode();
            endData = this.next;
            this.size = ++this.size;
        }

        if (this.key == null) {
            this.key = key;
            this.value = value;
            this.size = 1;
            this.hash = key.hashCode();
        }
        return value;
    }

    @Override
    public V remove(Object key) {

        if (!mySet.contains(key))
            return null;

        this.mySet.remove(key);
        this.myCollection.remove(this.get(key));

        MyMultiMapClass<K, V> temp = this;
        MyMultiMapClass<K, V> temp2 = null;

        for (int i = 0; i < this.size; i++) {
            if (temp.hash == key.hashCode()) {
                V tempValue = temp.value;

                for (int j = i; j < this.size - 1; j++) {
                    temp.key = temp.next.key;
                    temp.value = temp.next.value;
                    temp.hash = temp.next.hash;
                    endData = temp;
                    temp2 = temp;
                    temp = temp.next;
                }
                this.size = --this.size;
                temp2.next = null;
                return tempValue;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public void putAll(MultiMap<K, V> m) {

        for (int i = 0; i < m.size(); i++) {
            this.put((K) m.keySet().toArray()[i], (V) m.values().toArray()[i]);
        }
    }

    @Override
    public void clear() {

        this.key = null;
        this.value = null;
        this.size = 0;
        this.endData = null;
        this.next = null;
        this.hash = 0;
        this.mySet = null;
        this.myCollection = null;
    }

    @Override
    public Set<K> keySet() {
        return mySet;
    }

    @Override
    public Collection<V> values() {
        return myCollection;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        MyMultiMapClass<K, V> temp = this;

        for (int i = 0; i < this.size; i++) {
            if (temp.hash == key.hashCode() && temp.value.equals(oldValue)) {
                temp.value = newValue;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public V replace(K key, V value) {
        MyMultiMapClass<K, V> temp = this;

        for (int i = 0; i < this.size; i++) {
            if (temp.hash == key.hashCode()) {
                temp.value = value;
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
