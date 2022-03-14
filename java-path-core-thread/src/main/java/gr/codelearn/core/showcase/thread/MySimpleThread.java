package gr.codelearn.core.showcase.thread;

public class MySimpleThread implements Runnable {

    private final String name;

    public MySimpleThread(String name) {
        this.name = name;
        System.out.println("Thread " + name + " created");
    }

    @Override
    public void run() {
        System.out.println(name + " is starting");
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " iterates at " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Thread interupted. Detailed message: "+ex.getMessage());
            }
        }
        System.out.println(name + " finished");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MySimpleThread("Thread No. 1"));
        Thread t2 = new Thread(new MySimpleThread("Thread No. 2"));
        t1.start();
        t2.start();
        
        
    }
}

