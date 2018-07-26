package com.architect.test;

/**
 * @author wenxiong.jia
 * @since 2018/7/25
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread parserOne = new Thread(() -> System.out.println("parserOne finish"));
        Thread parserTwo = new Thread(() -> System.out.println("parserTwo finish"));
        parserOne.start();
        parserTwo.start();
        parserOne.join();
        parserTwo.join();
        System.out.println("all parser finish");
    }
}
