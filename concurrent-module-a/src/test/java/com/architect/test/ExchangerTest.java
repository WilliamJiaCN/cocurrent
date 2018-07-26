package com.architect.test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wenxiong.jia
 * @since 2018/7/25
 */
public class ExchangerTest {
    private static final Exchanger<String> exchanger = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            try {
                // A录入银行流水数据
                String A = "银行流水A";
                exchanger.exchange(A);
            } catch (InterruptedException e) {
            }
        });
        threadPool.execute(() -> {
            try {
                // B录入银行流水数据
                String B = "银行流水B";
                String A = exchanger.exchange("B");
                System.out.println("A和B数据是否一致：" + A.equals(B) + "，A录入的是："
                        + A + "，B录入是：" + B);
            } catch (InterruptedException e) {
            }
        });
        threadPool.shutdown();
    }
}
