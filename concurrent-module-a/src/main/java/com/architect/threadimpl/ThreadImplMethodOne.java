package com.architect.threadimpl;

/**
 * @author wenxiong.jia
 * @since 2018/7/17
 */
public class ThreadImplMethodOne extends Thread {

    public ThreadImplMethodOne(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("继承Thread类是实现线程的方式之一");
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new ThreadImplMethodOne("ThreadOne");
        thread.start();
    }
}
