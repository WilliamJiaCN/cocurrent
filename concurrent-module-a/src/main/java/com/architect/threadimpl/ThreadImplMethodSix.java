package com.architect.threadimpl;


import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author wenxiong.jia
 * @since 2018/7/19
 */
public class ThreadImplMethodSix {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("线程名称").daemon(false).build());
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(simpleDateFormat.format(new Date()) + " 当前线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 5, TimeUnit.SECONDS);

//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            System.out.println(simpleDateFormat.format(new Date()));
//            try {
//                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, 0, 5, TimeUnit.SECONDS);
    }
}
