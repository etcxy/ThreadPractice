package com.etcxy.Synchronized;


public class Warehouse {

    private String name;
    private int count = 1;
    private boolean flag = false;

    public Warehouse(String name) {
        this.name = name;
    }

    public synchronized void push() {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "仓库出产:" + this.name + count++);
        flag = true;
        notifyAll();
    }

    public synchronized void pop() {
        while (!flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        System.out.println(Thread.currentThread().getName() + "仓库出库:" + this.name + (count - 1));
        flag = false;
        notifyAll();
    }
}
