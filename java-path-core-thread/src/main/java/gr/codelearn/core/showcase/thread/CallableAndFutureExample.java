package gr.codelearn.core.showcase.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableAndFutureExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new MyCallable("Callable 1"));

        while (!future.isDone()) {
            System.out.println("Waiting for an answer");
        }

        try {
//            System.out.println("Future result: " + future.get(2,TimeUnit.SECONDS));
            System.out.println("Future result: " + future.get());
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println("Future interupted. Detailed message: " + ex.getMessage());
        }
        /*catch (TimeoutException ex) {
            Logger.getLogger(CallableAndFutureExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        executorService.shutdown();
    }

}

class MyCallable implements Callable<String> {

    private final String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Callable initiating. Name: " + name);
        Thread.sleep(3000);
        return "You calle me " + name;
    }
}
