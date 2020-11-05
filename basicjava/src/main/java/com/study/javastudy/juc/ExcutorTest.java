package com.study.javastudy.juc;

import java.util.concurrent.*;

public class ExcutorTest {
    public static void main(String[] args) throws InterruptedException {
        testCyc();
    }

    public static void test01() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 10; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

    }
    public static void testCyc() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        int count = 5;

        while(count > 0 ){
            count--;
            System.out.println("get into while :"+count);
            final CountDownLatch latch = new CountDownLatch(3);
            for(int i = 0; i < 3; i++){
                Future submit = executorService.submit(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                    latch.countDown();
                });
            }
            latch.await();
            System.out.println("end of while---》"+count);
        }
        executorService.shutdown();
        System.out.println("fininsh");
    }
}
