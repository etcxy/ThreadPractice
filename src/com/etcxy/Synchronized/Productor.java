package com.etcxy.Synchronized;

public class Productor implements Runnable{

    private Warehouse warehouse;

    public Productor(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            warehouse.push();
        }
    }
}
