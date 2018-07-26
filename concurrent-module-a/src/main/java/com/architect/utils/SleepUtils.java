package com.architect.utils;

import java.util.concurrent.TimeUnit;

/**
 * @author wenxiong.jia
 * @since 2018/7/18
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
