package com.etcxy.Synchronized;

public class Workshop {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse("电脑");

        Producer p = new Producer(warehouse);
        Consumer c = new Consumer(warehouse);

        new Thread(p, "p1").start();
        new Thread(p, "p2").start();

        new Thread(c, "c1").start();
        new Thread(c, "c2").start();

    }
}
