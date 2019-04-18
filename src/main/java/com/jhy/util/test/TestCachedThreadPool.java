package com.jhy.util.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: admin
 * @Date: 2018/8/13 10:56
 * @Description:没有返回结果的4种线程池
 */
public class TestCachedThreadPool {

    public static void main(String[] args) {
        /**
         * 1.这4个线程池都掉用了new ThreadPoolExecutor();
         * ThreadPoolExecutor (int corePoolSize, int maximumPoolSize, long keepAliveTime,
                TimeUnit unit,BlockingQueue<Runnable> workQueue)
         *  corePoolSize：线程池中所保存的核心线程数，包括空闲线程。
         *  maximumPoolSize：池中允许的最大线程数。
         *  keepAliveTime：线程池中的空闲线程所能持续的最长时间。
         *  unit：持续时间的单位。
         *  workQueue：任务执行前保存任务的队列，仅保存由 execute 方法提交的 Runnable 任务。
         */
        //缓存
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        //调度型
        ExecutorService executorService2 = Executors.newScheduledThreadPool(5);
        /**
         *主要问题是创建的线程的最大数为integer的最大值，
         * 可能会创建非常多的线程，甚至OOM
         */

        //单例
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        //固定大小
        ExecutorService executorService4 = Executors.newFixedThreadPool(5);
        /**
         *主要问题是堆积的问题处理可能会消耗很大的内存，甚至OOM
         */

        for (int i = 0; i < 5; i++) {
            executorService1.execute(new TestRunnable());
            System.out.println("************* a" + i + " *************");
        }
        executorService1.shutdown();
    }
}

class TestRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ==线程被调用了。");
    }
}
