package com.etcxy.lock;

public class Workshop {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse("工作站");

        Productor p = new Productor(warehouse);
        Consumer c = new Consumer(warehouse);

        new Thread(p, "pro1").start();
        new Thread(p, "pro2").start();

        new Thread(c, "con1").start();
        new Thread(c, "con2").start();

    }
}
