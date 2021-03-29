package block;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueClass implements BlockingQueue {

    private List tempList = new LinkedList();
    private int limit = 0;

    public BlockingQueueClass(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean add(Object o) {
        if (offer(o)) {
            System.out.println("add " + o);
            return true;
        } else
            throw new IllegalStateException("Нет свободного места");
    }

    @Override
    public synchronized boolean offer(Object o) {

        if (this.tempList.size() == this.limit)
            return false;
        else {
            this.tempList.add(o);
            return true;
        }
    }

    @Override
    public synchronized boolean offer(Object o, long timeout, TimeUnit unit) throws InterruptedException {

        wait(timeout); //// возможно неправильно

        if (offer(o))
            return true;
        else return false;
    }

    @Override
    public synchronized boolean remove(Object o) {

        if (tempList.contains(o)) {
            tempList.remove(o);
            return true;
        } else

            return false;
    }

    @Override
    public synchronized boolean contains(Object o) {
        return tempList.contains(o);
    }

    @Override
    public synchronized Object poll(long timeout, TimeUnit unit) throws InterruptedException {

        wait(timeout);
        if (this.tempList.size() == 0)
            return null;
        else {
            Object o = this.tempList.remove(0);
            System.out.println("poll " + o);
            return o;
        }
    }

    @Override
    public synchronized void put(Object o) throws InterruptedException {

        while (this.tempList.size() == this.limit) {
            System.out.println("Нет свободного места");
            wait();
        }
        if (this.tempList.size() == 0) {
            notifyAll();
        }
        this.tempList.add(o);
        System.out.println(" put " + o);
    }

    @Override
    public synchronized Object take() throws InterruptedException {

        while (this.tempList.size() == 0) {
            System.out.println("Очередь пустая");
            wait();
        }
        if (this.tempList.size() == this.limit) {
            notifyAll();
        }

        Object o = this.tempList.remove(0);
        System.out.println("take " + o);
        return o;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public int drainTo(Collection c) {
        return 0;
    }

    @Override
    public int drainTo(Collection c, int maxElements) {
        return 0;
    }
}

