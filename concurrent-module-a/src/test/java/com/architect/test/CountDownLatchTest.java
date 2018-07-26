package com.architect.test;

import java.util.concurrent.CountDownLatch;

/**
 * @author wenxiong.jia
 * @since 2018/7/25
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        Thread parserOne = new Thread(() -> {
            System.out.println("parserOne finish");
            countDownLatch.countDown();
        });
        Thread parserTwo = new Thread(() -> {
            System.out.println("parserTwo finish");
            countDownLatch.countDown();
        });
        parserOne.start();
        parserTwo.start();
        countDownLatch.await();
        System.out.println("all parser finish");
    }
}
