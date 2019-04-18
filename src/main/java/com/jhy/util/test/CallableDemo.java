package com.jhy.util.test;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Auther: admin
 * @Date: 2018/8/13 11:24
 * @Description:有返回值得线程池
 */
public class CallableDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(3, 5, 60, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<Runnable>(10));
        ArrayList<Future<String>> futures = new ArrayList<Future<String>>();

        //创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = threadPoolExecutor.submit(new TaskWithResult(i));
            //将任务执行结果存储到List中
            futures.add(future);
        }

        for (Future<String> fs : futures) {
            try{
                //Future返回如果没有完成，则一直循环等待，直到Future返回完成
                while (!fs.isDone()){
                    //打印各个线程（任务）执行的结果
                    System.out.println("执行的结果==" + fs.get());
                } ;
            }catch(InterruptedException e){
                e.printStackTrace();
            }catch(ExecutionException e){
                e.printStackTrace();
            }finally{
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                threadPoolExecutor.shutdown();
            }
        }

    }
}

class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }
    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，
     * 则该方法自动在一个线程上执行
     */
    @Override
    public String call() throws Exception {
        System.out.println("call()方法被自动调用！！！    " + Thread.currentThread().getName());
        //该返回结果将被Future的get方法得到
        return "call()方法被自动调用，任务返回的结果是：" + id + "  " + Thread.currentThread().getName();
    }
}
