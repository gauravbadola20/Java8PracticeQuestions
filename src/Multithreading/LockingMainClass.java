package Multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class LockingMainClass {

    public static void main(String[] args) {

        LockingSharedResources resources = new LockingSharedResources();

        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread( () ->{

            resources.produce(lock);
        });

        LockingSharedResources resources1 = new LockingSharedResources();
        Thread t2 = new Thread( () ->{

            resources1.produce(lock);
        });

        t1.start();
        t2.start();
    }
}
