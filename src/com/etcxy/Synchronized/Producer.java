package com.etcxy.Synchronized;

public class Producer implements Runnable{

    private Warehouse warehouse;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            warehouse.push();
        }
    }
}
