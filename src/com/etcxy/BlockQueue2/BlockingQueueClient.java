package com.etcxy.BlockQueue2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class BlockingQueueClient {

    public static void main(String[] args) throws InterruptedException {
        // 声明一个容量为10的缓存队列  
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        //Consumer consumer2 = new Consumer(queue);
        //Consumer consumer3 = new Consumer(queue);

        // 借助Executors  
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors
                .newCachedThreadPool();
        // 启动线程  
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        // service.execute(consumer2);  
        // service.execute(consumer3);  
        service.execute(consumer);

        // 执行10s  
        Thread.sleep(10 * 1000);

        System.out.println("active count = " + service.getActiveCount());
        // producer1.stop();  
        // producer2.stop();  
        // producer3.stop();  
        Thread.sleep(2000);
        // 退出Executor  
        service.shutdown();
    }
} 