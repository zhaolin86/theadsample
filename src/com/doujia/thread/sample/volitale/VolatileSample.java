package com.doujia.thread.sample.volitale;

public class VolatileSample {

    private static boolean isFalg = false;

    //private static volatile boolean vIsFlag = false;

    public static void assgin(){
        isFalg = true;
        //vIsFlag = true;
        System.out.println(Thread.currentThread().getName() + "-hello ,assgin ");
    }

    public static void main(String[] args) {
        new Thread(() -> {
            while (!isFalg) {
                System.out.println(Thread.currentThread().getName() + "-hello ,i am running");
            }
        }).start();

/*        new Thread(() -> {
            while (!vIsFlag) {
                System.out.println(Thread.currentThread().getName() + "-hello ,i am running");
            }
        }).start();*/

        new Thread(() -> {
            assgin();
        }).start();


    }




}
