package com.architect.threadimpl;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author wenxiong.jia
 * @since 2018/7/17
 */
public class ThreadImplMethodFour implements Runnable {

    @Override
    public void run() {
        System.out.println("实现Runnable接口是实现线程的方式之一");
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().build();
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(new ThreadImplMethodFour());
        executorService.shutdown();
    }
}