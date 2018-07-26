package com.architect.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author wenxiong.jia
 * @since 2018/7/25
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = new ThreadPoolExecutor(THREAD_COUNT, THREAD_COUNT,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<>(1024), new ThreadFactoryBuilder().setNameFormat("thread%d").build(), new ThreadPoolExecutor.AbortPolicy());
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " save data");
                    semaphore.release();
                } catch (InterruptedException e) {
                }
            });
        }
        threadPool.shutdown();
    }
}
