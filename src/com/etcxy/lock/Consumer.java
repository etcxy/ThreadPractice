package com.etcxy.lock;

public class Consumer implements Runnable {

    private Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            warehouse.pop();
        }
    }
}
