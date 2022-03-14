package gr.codelearn.core.showcase.thread;



public class RaceCondition implements Runnable {

    private int totalValue;

    public RaceCondition() {
        totalValue = 0;
    }

    public synchronized void increment() {
        try {
            Thread.sleep(20);
            totalValue++;
        } catch (InterruptedException ex) {
            System.out.println("Thread interupted. Detailed message: "+ex.getMessage());
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" total value before increment is: " +totalValue);
        increment();
        System.out.println(Thread.currentThread().getName()+" total value after increment is: " +totalValue);
    }
    
    public static void main(String[] args) {
        RaceCondition raceCondition = new RaceCondition();
        System.out.println("Main thread: "+ Thread.currentThread().getName());
        Thread t1 = new Thread(raceCondition);
        Thread t2 = new Thread(raceCondition);
        Thread t3 = new Thread(raceCondition);
        t1.start();
        t2.start();
        t3.start();
    }

}
