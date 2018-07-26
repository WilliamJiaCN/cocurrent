package com.architect.synchronizedimpl;

/**
 * @author wenxiong.jia
 * @since 2018/7/23
 */
public class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    @Override
    public void run() {
        synchronized (this) {
            int len = 5;
            for (int i = 0; i < len; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
