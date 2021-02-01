package com.doujia.thread.sample.volitale;

/**
 * double check Lock 单例
 */
public class DCLInstance {

    //volatile可以保证对象创建的可见性与有序性，避免对象在版初始化状态及被使用。
    private static volatile DCLInstance dclInstance;

    private DCLInstance(){}

    public static DCLInstance getInstance(){
        //先进行判断，避免上来就加锁 ，下边两行代码的执行速度比近 100:1
        if(dclInstance == null){
            synchronized (DCLInstance.class) {
                //避免加锁期间 对象被别的线程创建
                if(dclInstance == null){
                    dclInstance = new DCLInstance();
                }
            }

        }

        return dclInstance;
    }

    private void doSomeThing(){
        System.out.println("some thing");
    }

    public static void main(String[] args) {
        DCLInstance.getInstance().doSomeThing();
    }
}


