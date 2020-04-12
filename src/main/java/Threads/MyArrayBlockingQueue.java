package Threads;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Custom class that is basic Array blocking Queue implementation
 *
 * @param <T>
 */
public class MyArrayBlockingQueue<T> {

    Lock lock = new ReentrantLock();
    Condition empty = lock.newCondition();
    Condition full = lock.newCondition();
    int max = 10;
    LinkedList<T> myqueue;

    public MyArrayBlockingQueue(int size) {
        this.max = size;
        myqueue = new LinkedList<>();

    }

    /**
     * This method is used to put and element in Q
     *
     * @param i
     * @throws InterruptedException
     */
    void put(T i) throws InterruptedException {
        try {
            lock.lock();
            while (myqueue.size() == max) {
                full.await();
            }

            myqueue.add(i);
            empty.signalAll();
        } finally {
            lock.unlock();
        }

    }

    /**
     * Apit to take an elelment from Q
     *
     * @return
     * @throws InterruptedException
     */
    T take() throws InterruptedException {
        try {
            lock.lock();
            while (myqueue.size() == 0) {
                empty.await();
            }

            T data = myqueue.remove();
            full.signalAll();
            return data;
        } finally {
            lock.unlock();
        }


    }
}
