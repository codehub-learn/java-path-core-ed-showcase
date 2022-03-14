package gr.codelearn.core.showcase.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySimpleThreadWithStop implements Runnable {

    private final String name;
    private final AtomicBoolean exit = new AtomicBoolean(false);

    public MySimpleThreadWithStop(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is starting.");
        while (!exit.get()) {
            try {
                Thread.sleep(2000);
                System.out.println("No one can stop me. I will run forever!");
            } catch (InterruptedException ex) {
                System.out.println("Thread interupted. Detailed message: " + ex.getMessage());
            }
        }
        System.out.println("Oh no you stopped me!");
    }

    public void stop() {
        exit.set(true);
    }

    public static void main(String[] args) {
        MySimpleThreadWithStop ts = new MySimpleThreadWithStop("Thread no 1");
        Thread t1 = new Thread(ts);
        t1.start();
        try {
            Thread.sleep(5000);
            ts.stop();
        } catch (InterruptedException ex) {
            System.out.println("Thread interupted. Detailed message: " + ex.getMessage());
        }
    }
}
