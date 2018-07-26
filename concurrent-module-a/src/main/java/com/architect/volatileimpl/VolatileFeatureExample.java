package com.architect.volatileimpl;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author wenxiong.jia
 * @since 2018/7/23
 */
public class VolatileFeatureExample {
    private volatile boolean flag = false;

    private void writer() {
        flag = true;
    }

    private void reader() {
        while (!flag) {

        }
        System.out.println("volatile变量自身具有如下特性：");
        System.out.println("1、可见性：对一个volatile变量的读，总是能看到（任意线程）对这个volatile变量最后的写入；");
        System.out.println("2、原子性：对任意单个volatile变量的读/写具有原子性，但类似于volatile++这种复合操作不具有原子性。");
        System.out.println("总结：");
        System.out.println("1、任意单个volatile变量的读/写具有原子性，因此是线程安全的");
        System.out.println("2、对volatile变量的复合操作，如volatile++，不具有原子性，因此不是线程安全的");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileFeatureExample volatileExample = new VolatileFeatureExample();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService fixedThreadPool = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        fixedThreadPool.execute(volatileExample::reader);
        Thread.sleep(1000);
        fixedThreadPool.execute(volatileExample::writer);
        fixedThreadPool.shutdown();
    }
}
