package com.architect.test;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author wenxiong.jia
 * @since 2018/7/29
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[]{1, 2};
    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        atomicIntegerArray.getAndSet(0, 3);
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(value[0]);
    }
}
