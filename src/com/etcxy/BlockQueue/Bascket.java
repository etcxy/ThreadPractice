package com.etcxy.BlockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Bascket {
    //共享存储
    BlockingQueue<String> bascket = new ArrayBlockingQueue(3);

    public void add(String things) throws InterruptedException {
        if (bascket.size() >= 3) {
            System.out.println("add block,please waiting...");
        }
        bascket.put(things);
    }

    public String get() throws InterruptedException {
        if (bascket.isEmpty()) {
            System.out.println("get block,there is no food...");
        }
        return bascket.take();
    }
}