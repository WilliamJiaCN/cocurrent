package com.architect.test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wenxiong.jia
 * @since 2018/7/29
 */
public class AtomicReferenceTest {
    private static AtomicReference<User> atomicUserRef = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("william", 28);
        atomicUserRef.set(user);
        User updateUser = new User("jack", 45);
        atomicUserRef.compareAndSet(user, updateUser);
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getOld());
    }

    static class User {
        private String name;
        private int old;

        User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        String getName() {
            return name;
        }

        int getOld() {
            return old;
        }
    }
}
