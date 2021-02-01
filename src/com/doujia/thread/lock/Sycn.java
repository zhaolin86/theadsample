package com.doujia.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Sycn {

    private static int i = 0;
    private static Map map = new HashMap<>();

    //private static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {

        for (int j = 0; j < 1000; j++) {
            new Thread(() -> {
                while (i < 10000) {
                    increase();
                }

            }).start();
        }
        Thread.sleep(5000);
        System.out.println("size :" + map.size());
    }

    public synchronized static void increase() {
        if(map.containsKey(i)){
            System.out.println("重复 " + i);
        }
        map.put(i,i);
        System.out.println(i++);


    }

}
