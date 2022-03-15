package gr.codelearn.core.showcase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorServiceExample {

    public static void main(String[] args) {
        Task task1 = new Task("Task 1");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(task1);
        executorService.shutdown();

        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");
        Task task4 = new Task("Task 4");

        ExecutorService executorServicePool = Executors.newFixedThreadPool(2);
        executorServicePool.execute(task2);
        executorServicePool.execute(task3);
        executorServicePool.execute(task4);
        executorServicePool.shutdown();
    }
}

class Task implements Runnable {

    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is starting a connection with database!");
        try {
            Thread.sleep(3000);
            System.out.println("Retrieving information from database");
        } catch (InterruptedException ex) {
            System.out.println("Thread interupted. Detailed message: " + ex.getMessage());
        }
        System.out.println("Information retrieved. Thread: " + name);
    }

}
