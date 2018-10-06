package com.etcxy.BlockQueue;

//消费者
public class Consumer implements Runnable {
    private Bascket bascket;
    private String name;

    public Consumer(Bascket bascket, String name) {
        this.bascket = bascket;
        this.name = name;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(name + ":consumer:" + bascket.get());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}