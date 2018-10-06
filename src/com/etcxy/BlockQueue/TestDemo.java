package com.etcxy.BlockQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDemo {
    public static void main(String args[]) {
        Bascket bascket = new Bascket();
        Consumer c1 = new Consumer(bascket, "c1");
        Consumer c2 = new Consumer(bascket, "c2");

        Producer p1 = new Producer(bascket, "p1");
        Producer p2 = new Producer(bascket, "p2");


        //线程池管理
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(c1);
        service.execute(c2);
        service.execute(p1);
        service.execute(p2);

    }
}