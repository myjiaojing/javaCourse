package com.zcr.c004;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Homework {


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 1.future
     * @return
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();



        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });
        new Thread(task).start();

        int result = 0;
        try {
            result = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        System.out.println("threadName:"+Thread.currentThread().getName());
        // 然后退出main线程
    }







    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 2.CompletableFuture
     * @return
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
        public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        Integer result = CompletableFuture.supplyAsync(()->{
            return sum();
        }).join();

        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        System.out.println("threadName:"+Thread.currentThread().getName());
        // 然后退出main线程
    }*/









    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 3.thread.join()
     * @return
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
    static  Integer result = 0;
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                result = sum();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.join();


        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        System.out.println("threadName:"+Thread.currentThread().getName());
    }
*/







    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 4.wait&notify
     * @return
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
    static Integer result = 0;
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        long start = System.currentTimeMillis();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                result = sum();
                synchronized (lock){
                    lock.notify();
                }

            }
        };

        Thread thread = new Thread(task);
        thread.start();
        synchronized (lock){
            lock.wait();
        }

        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        System.out.println("threadName:"+Thread.currentThread().getName());
    }
*/






    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 5.Lock&Condition
     * @return
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

 /*
    static Integer result = -1;
    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new ReentrantLock();
        final Condition done  = lock.newCondition();

        long start = System.currentTimeMillis();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    result = sum();
                    done.signal();
                }finally {
                    lock.unlock();
                }


            }
        };

        Thread thread = new Thread(task);
        thread.start();
        lock.lock();
        if (result == -1) {
           done.await();
        }
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        System.out.println("threadName:"+Thread.currentThread().getName());
        lock.unlock();
    }
*/


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 6.countDownLatch
     * @return
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    static Integer result = 0;
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                result = sum();
                countDownLatch.countDown();

            }
        };

        Thread thread = new Thread(task);
        thread.start();

        countDownLatch.await();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        System.out.println("threadName:"+Thread.currentThread().getName());
    }
*/




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 7.CyclicBarrier
     * @return
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*    static Integer result = 0;
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Object lock = new Object();
        long start = System.currentTimeMillis();
        CyclicBarrier barrier  = new CyclicBarrier(2);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                result = sum();
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread = new Thread(task);
        thread.start();

        barrier.await();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        System.out.println("threadName:" + Thread.currentThread().getName());
    }*/




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 8.while flag
     * @return
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
    static  Integer result = 0;
    static  boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                result = sum();
                flag = true;
            }
        };
        Thread thread = new Thread(task);
        thread.start();

        while (!flag){
            System.out.println("等结果ing");
        }

        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        System.out.println("threadName:"+Thread.currentThread().getName());
        // 然后退出main线程
    }
*/




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 9，just sleep
     * @return
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*    static  Integer result = 0;
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                result = sum();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(1000);


        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        System.out.println("threadName:"+Thread.currentThread().getName());
        // 然后退出main线程
    }*/






    private static int sum() {
        System.out.println("threadName:"+Thread.currentThread().getName());
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
