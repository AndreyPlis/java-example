package queue;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueClass<T> extends PriorityQueue<T> implements BlockingQueue<T>{
    Lock addLock = new ReentrantLock();
    Lock getLock = new ReentrantLock();
    int maxSize = 1;

    public BlockingQueueClass(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean add(T t){
        checkIsFullQueue();
        if(addLock.tryLock()) {
            super.add(t);
            getLock.unlock();
            return true;
        }
        else
            throw new IllegalStateException();
    }

    @Override
    public boolean offer(T t) {
        checkIsFullQueue();
        if(addLock.tryLock()) {
            super.offer(t);
            getLock.unlock();
            return true;
        }
        else
            return false;
    }

    @Override
    public void put(T t) {
        checkIsFullQueue();
        while (true)
        {
            if(addLock.tryLock()) {
                super.add(t);
                getLock.unlock();
                break;
            }
        }
    }

    @Override
    public boolean offer(T t, long timeout, TimeUnit unit) throws InterruptedException {
        checkIsFullQueue();
        if(addLock.tryLock()){
            offer(t);
            getLock.unlock();
            return true;
        }
        wait(timeout);
        if(addLock.tryLock()){
            offer(t);
            getLock.unlock();
            return true;
        }else
            return false;
    }

    @Override
    public T take() throws InterruptedException {
        checkIsEmptyQueue();
        T element;
        while (true)
        {
            if(getLock.tryLock())
            {
                element = super.poll();
                addLock.unlock();
                break;
            }
        }
        assert element != null;
        return element;
    }

    @Override
    public T poll(long timeout, TimeUnit unit) throws InterruptedException {
        T element;
        checkIsEmptyQueue();
        if(getLock.tryLock()) {
            element = super.poll();
            addLock.unlock();
            return element;
        }
        wait(timeout);
        if(getLock.tryLock()){
            element = super.poll();
            addLock.unlock();
            return element;
        }
        else
            throw new InterruptedException();
    }

    @Override
    public int remainingCapacity() {
        return maxSize;
    }

    @Override
    public boolean remove(Object o) {
        checkIsEmptyQueue();
        boolean res;
        while (true)
        {
            if (getLock.tryLock()){
                res = super.remove(o);
                addLock.unlock();
                break;
            }
        }
        return res;
    }

    @Override
    public boolean contains(Object o) {
        boolean result;
        boolean addLockCondition = addLock.tryLock();
        boolean getLockCondition = getLock.tryLock();
        addLock.lock();
        getLock.lock();
        result = super.contains(o);
        if(addLockCondition)
            addLock.unlock();
        if(getLockCondition)
            getLock.unlock();
        return result;
    }

    @Override
    public int drainTo(Collection<? super T> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super T> c, int maxElements) {
        return 0;
    }

    private void checkIsFullQueue(){
        if(super.size() >= maxSize)
            addLock.lock();
    }

    private void checkIsEmptyQueue(){
        if(super.size() == 0)
            getLock.lock();
    }
}
