package com.architect.threadimpl;

/**
 * @author wenxiong.jia
 * @since 2018/7/17
 */
public class ThreadImplMethodTwo implements Runnable {

    @Override
    public void run() {
        System.out.println("实现Runnable接口是实现线程的方式之一");
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadImplMethodTwo(), "ThreadTwo");
        thread.start();
    }
}
