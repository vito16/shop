package com.vito16.shop;

import com.vito16.shop.model.Product;

/**
 * @author Vito
 * @version 2014/7/21
 */
public class ProductTest {
    public static void main(String[] args) {
        Godown godown = new Godown(20);
        Consumer c1 = new Consumer(80, godown);
        Consumer c2 = new Consumer(30, godown);
        Consumer c3 = new Consumer(20, godown);
        Producer p1 = new Producer(5, godown);
        Producer p2 = new Producer(5, godown);
        Producer p3 = new Producer(5, godown);
        Producer p4 = new Producer(10, godown);
        Producer p5 = new Producer(20, godown);
        Producer p6 = new Producer(35, godown);
        Producer p7 = new Producer(50, godown);

        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }
}

/** 仓库   */
class Godown {
    public static final int max_size = 100; //最大库存量
    public int curnum;     //当前库存量

    Godown() {
    }

    Godown(int curnum) {
        this.curnum = curnum;
    }
    /**
     * 生产指定数量的产品
     * @param neednum
     */
    public synchronized void produce(int neednum) {
        //测试是否需要生产
        while (neednum + curnum > max_size) {
            System.out.println("要生产的产品数量" + neednum + "超过剩余库存量" + (max_size - curnum) + "，暂时不能执行生产任务!");
            try {
                //当前的生产线程等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //满足生产条件，则进行生产，这里简单的更改当前库存量
        curnum += neednum;
        System.out.println("已经生产了" + neednum + "个产品，现仓储量为" + curnum);
        //唤醒在此对象监视器上等待的所有线程
        notifyAll();
    }

    /**
     * 消费指定数量的产品
     * @param neednum
     */
    public synchronized void consume(int neednum) {
        //测试是否可消费
        while (curnum < neednum) {
            try {
                //当前的生产线程等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //满足消费条件，则进行消费，这里简单的更改当前库存量
        curnum -= neednum;
        System.out.println("已经消费了" + neednum + "个产品，现仓储量为" + curnum);
        //唤醒在此对象监视器上等待的所有线程
        notifyAll();
    }
}

/** 生产者   */
class Producer extends Thread {
    //生产产品的数量
    private int neednum;
    //仓库
    private Godown godown;

    Producer(int neednum, Godown godown) {
        this.neednum = neednum;
        this.godown = godown;
    }

    public void run() {
        //生产指定数量的产品
        godown.produce(neednum);
    }
}

/** 消费者    */
class Consumer extends Thread {
    //生产产品的数量
    private int neednum;
    //仓库
    private Godown godown;

    Consumer(int neednum, Godown godown) {
        this.neednum = neednum;
        this.godown = godown;
    }

    public void run() {
        //消费指定数量的产品
        godown.consume(neednum);
    }
}