package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServices {


    public static void main(String[] args) {


        // create thread pool for 3 workers thread
        ExecutorService executorService =Executors.newFixedThreadPool(3);


        //submit task

        for (int i = 0; i < 10; i++) {

            int task =  i;

            executorService.execute( () ->{

                System.out.println("Task: " + task + " exectued by "+
                        Thread.currentThread().getName());
            });
        }

        // shutdown pool

        executorService.shutdown();
    }
}
