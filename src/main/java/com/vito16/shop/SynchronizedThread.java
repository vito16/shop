package com.vito16.shop;

/**
 * @author Vito
 * @version 2014/7/21
 */
public class SynchronizedThread {
    public static void main(String[] args) {
        User user = new User();
        user.setMoney(100);
        user.setName("王军");
        MyThread myThread1 = new MyThread(user,100);
        MyThread myThread2 = new MyThread(user,2);
        MyThread myThread3 = new MyThread(user,3);
        MyThread myThread4 = new MyThread(user,-4);
        MyThread myThread5 = new MyThread(user,-14);
        MyThread myThread6 = new MyThread(user,4);
        MyThread myThread7 = new MyThread(user,-4);
        MyThread myThread8 = new MyThread(user,-4);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
        myThread6.start();
        myThread7.start();
        myThread8.start();
    }

}

class MyThread extends Thread{
    User user;
    Integer money;

    MyThread(User user, Integer money) {
        this.user = user;
        this.money = money;
    }

    @Override
    public void run() {
        user.oper(money);
        System.out.println(getName()+" -- "+user.getName() + " --  " + user.getMoney());
    }
}

class User {
    private Integer money;
    private String name;

    public synchronized void oper(Integer monty) {
        this.money += monty;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}