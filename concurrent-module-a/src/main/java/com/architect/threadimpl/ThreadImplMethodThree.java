package com.architect.threadimpl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wenxiong.jia
 * @since 2018/7/17
 */
public class ThreadImplMethodThree implements Callable<String>{

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("实现Callable<V>接口是实现线程的方式之一");
        sb.append("\n");
        sb.append("当前线程名称：" + Thread.currentThread().getName());
        return  sb.toString();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new ThreadImplMethodThree());
        new Thread(futureTask, "ThreadThree").start();
        System.out.println(futureTask.get());
    }
}
