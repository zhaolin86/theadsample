package com.doujia.thread.sample.volitale;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private int i;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private void increase(){
        new Thread(() -> {
            while (i < 100000)
            System.out.println(i++);
        }).start();
        new Thread(() -> {
            while (i < 100000)
                System.out.println(i++);
        }).start();
        new Thread(() -> {
            while (i < 100000)
                System.out.println(i++);
        }).start();
        new Thread(() -> {
            while (i < 100000)
                System.out.println(i++);
        }).start();

    }

    private void atomicIncrease(){
        new Thread(() -> {
            while (i < 100000)
                System.out.println(atomicInteger.addAndGet(1));
        }).start();
        new Thread(() -> {
            while (i < 100000)
                System.out.println(atomicInteger.addAndGet(1));
        }).start();
        new Thread(() -> {
            while (i < 100000)
                System.out.println(atomicInteger.addAndGet(1));
        }).start();
        new Thread(() -> {
            while (i < 100000)
                System.out.println(atomicInteger.addAndGet(1));
        }).start();
    }

    public static void main(String[] args) {
        new AtomicTest().increase();
    }

}
