package Multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CompleteableFutureImplementation
{
    public static void main(String[] args) {

        ScheduledExecutorService scheduler =

                Executors.newScheduledThreadPool(2);

        scheduler.scheduleAtFixedRate(() -> {

            System.out.println(
                    "Running: " +
                            Thread.currentThread().getName()
            );

        }, 1, 3, TimeUnit.SECONDS);
    }
}
