
package gr.codelearn.core.showcase.thread;


public class MySimpleThreadWithJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MySimpleThread("Thread no 1"));
        Thread t2 = new Thread(new MySimpleThread("Thread no 2"));
        Thread t3 = new Thread(new MySimpleThread("Thread no 3"));
        t1.start();
        System.out.println("Current thread "+ Thread.currentThread().getName()+ " will start waiting!");
        t1.join();
        System.out.println("Join invoked by thread "+ Thread.currentThread().getName());
        t2.start();
        System.out.println("Current thread "+ Thread.currentThread().getName()+ " will start waiting for 1 sec");
        t2.join(1000);
        System.out.println("Join invoked by thread "+ Thread.currentThread().getName()+" after 1 sec");
        t3.start();
    }
    
}
