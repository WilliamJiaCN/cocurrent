package com.architect.test;

import java.util.concurrent.CyclicBarrier;

/**
 * @author wenxiong.jia
 * @since 2018/7/25
 */
public class CyclicBarrierAdvanceTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println("子线程已到达屏障");
                cyclicBarrier.await();
            } catch (Exception e) {

            }
            System.out.println("子线程开始执行");
        }).start();
        try {
            System.out.println("主线程已到达屏障");
            cyclicBarrier.await();
        } catch (Exception e) {
        }
        System.out.println("主线程开始执行");
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println("线程被优先执行");
        }
    }
}
