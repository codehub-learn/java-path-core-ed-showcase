package gr.codelearn.core.showcase.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadCommunicationMain {
        public static void main(String[] args) {
        Integer amount = 10;
        ThreadCommunication tc = new ThreadCommunication(amount);
        Thread t1 = new Thread(new WaitThreadClass("Thread no 1",amount));
        Thread t2 = new Thread(new WaitThreadClass("Thread no 2",amount));
        t1.start();
        t2.start();
        new Thread(()->tc.deposit(50)).start();
    }


}

class WaitThreadClass implements Runnable {

    private Integer amount;
    private String name;

    public WaitThreadClass(String name, Integer amount) {
        this.amount = amount;
        this.name = name;
        System.out.println("Thread " + name + " created!");
    }

    @Override
    public void run() {
        System.out.println("Waiting for a deposit");
        synchronized (amount) {
            try {
                amount.wait();
            } catch (InterruptedException ex) {
                System.out.println("Someone interupted me!");
                System.out.println("Thread interupted. Detailed message: " + ex.getMessage());
            }
            System.out.println("Deposit was made and Thread "+ name + " was notified");
        }
    }
}

class ThreadCommunication{
    private Integer balance;
    private Integer amount;

    public ThreadCommunication(Integer amount) {
        this.amount = amount;
        balance = 100;
    }

    public void deposit(int amountToAdd) {
        System.out.println("Starting deposit at thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println("Thread interupted. Detailed message: " + ex.getMessage());
        }

        synchronized (amount) {
            try {
                Thread.sleep(2000);
                balance += amountToAdd;
            } catch (InterruptedException ex) {
                System.out.println("Thread interupted. Detailed message: " + ex.getMessage());
            }
            amount.notify();
//            amount.notifyAll();
        }
    }
}
