package com.jhy.util.test;

/**
 * @Auther: admin
 * @Date: 2018/8/13 10:33
 * @Description:
 */
public class MyThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
        for (i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + "==" + i);
        }
    }
}
