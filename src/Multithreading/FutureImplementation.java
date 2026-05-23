package Multithreading;

import java.security.PrivilegedAction;
import java.util.concurrent.*;

public class FutureImplementation {



    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService ex = Executors.newFixedThreadPool(2);

        // callable returns value

        Callable<Integer> task = () -> {
            Thread.sleep(2000);

            return 100;
        };

        Future<Integer> future = ex.submit(task);

        System.out.println("Task submitted");

        //blocking call

        Integer result = future.get();

        System.out.println("Result: "+result);

        ex.shutdown();


    }
}
