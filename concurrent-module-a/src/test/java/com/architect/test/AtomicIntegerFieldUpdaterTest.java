package com.architect.test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author wenxiong.jia
 * @since 2018/7/29
 */
public class AtomicIntegerFieldUpdaterTest {
    // 创建原子更新器，并设置需要更新的对象类和对象的属性
    private static final AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    public static void main(String[] args) {
        // 设置柯南的年龄是10岁
        User conan = new User("conan", 10);
        // 柯南长了一岁，但是仍然会输出旧的年龄
        System.out.println(atomicIntegerFieldUpdater.getAndIncrement(conan));
        // 输出柯南现在的年龄
        System.out.println(atomicIntegerFieldUpdater.get(conan));
    }

    public static class User {
        String name;
        volatile int old;

        User(String name, int old) {
            this.name = name;
            this.old = old;
        }
    }
}
