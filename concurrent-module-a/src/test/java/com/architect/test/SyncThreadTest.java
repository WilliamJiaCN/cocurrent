package com.architect.test;

import com.architect.synchronizedimpl.SyncThread;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author wenxiong.jia
 * @since 2018/7/23
 */
public class SyncThreadTest {
    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("SyncThread%d").build();
        ExecutorService fixedThreadPool = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        int num = 2;
        for (int i = 0; i < num; i++) {
            fixedThreadPool.execute(syncThread);
        }
        fixedThreadPool.shutdown();
    }
}
