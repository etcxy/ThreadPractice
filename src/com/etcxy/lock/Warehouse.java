package com.etcxy.lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Warehouse {

    private String name;
    private int count = 1;
    private boolean flag = false;

    //	创建一个锁对象。
    Lock lock = new ReentrantLock();

    //通过已有的锁获取两组监视器，一组监视生产者，一组监视消费者。
    Condition producer_con = lock.newCondition();
    Condition consumer_con = lock.newCondition();

    public Warehouse(String name) {
        this.name = name;
    }

    public void push() {

        //lock上锁
        lock.lock();

        try {
            while (flag) {
                //使用监视器1使之进入阻塞状态
                producer_con.await();
            }
            System.out.println(Thread.currentThread().getName() + "仓库出产:" + this.name + count++);
            flag = true;
            //唤醒监视器2的线程
            consumer_con.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //防止异常发生，在finally中，解锁
            lock.unlock();
        }

    }

    public void pop() {

        try {
            lock.lock();

            while (!flag) {
                consumer_con.await();
            }
            System.out.println(Thread.currentThread().getName() + "仓库出库:" + this.name + (count - 1));//消费烤鸭1
            flag = false;
            producer_con.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
