package com.architect.volatileimpl;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * volatile的内存语义：
 * 参考博客：http://www.infoq.com/cn/articles/java-memory-model-4
 * 该示例没有呈现volatile的内存语义
 * @author wenxiong.jia
 * @since 2018/7/23
 */
public class VolatileJmmExample {
    private int a = 0;
    private volatile boolean flag = false;

    private void writer() {
        a = 1;
        flag = true;
    }

    private void reader() {
        if (flag) {
            int i = a;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileJmmExample volatileExample = new VolatileJmmExample();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService fixedThreadPool = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        fixedThreadPool.execute(volatileExample::writer);
        fixedThreadPool.execute(volatileExample::reader);
        fixedThreadPool.shutdown();
    }
}
