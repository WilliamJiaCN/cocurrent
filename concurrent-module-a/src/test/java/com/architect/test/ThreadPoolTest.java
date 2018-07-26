package com.architect.test;

import com.architect.utils.MonitorThreadPoolUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wenxiong.jia
 * @since 2018/7/18
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //监控线程池
        new Thread(new MonitorThreadPoolUtil((ThreadPoolExecutor) executorService, 1)).start();
        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(random.nextInt());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(list.size());
    }
}
