package com.architect.threadimpl;

import java.util.concurrent.*;

/**
 * @author wenxiong.jia
 * @since 2018/7/17
 */
public class ThreadImplMethodFive implements Callable<String> {

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("实现Callable<V>接口是实现线程的方式之一");
        sb.append("\n");
        sb.append("当前线程名称：" + Thread.currentThread().getName());
        return  sb.toString();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future future = executorService.submit(new ThreadImplMethodFive());
        executorService.shutdown();
        System.out.println(future.get());
    }
}