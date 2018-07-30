package com.architect.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wenxiong.jia
 * @since 2018/7/29
 */
public class AtomicIntegerTest {
    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}
