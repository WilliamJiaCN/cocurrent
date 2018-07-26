package com.architect.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wenxiong.jia
 * @since 2018/7/25
 */
public class ConditionUseCase {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            //当调用await()方法后，当前线程会释放锁并在此等待
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
            //其他线程调用Condition对象的signal()方法，通知当前线程后，当前线程才从await()方法返回，并且在返回前已经获取了锁
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
