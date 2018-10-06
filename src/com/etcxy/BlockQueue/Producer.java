package com.etcxy.BlockQueue;

//生产者
public class Producer implements Runnable {
    private Bascket bascket;
    private String name;

    public Producer(Bascket bascket, String name) {
        this.bascket = bascket;
        this.name = name;
    }

    public void run() {

        while (true) {
            try {
                String apple = "apple NO." + Math.random() * 100;
                bascket.add(apple);
                System.out.println(name + " produce.."+apple);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}