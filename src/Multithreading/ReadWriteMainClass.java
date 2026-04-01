package Multithreading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteMainClass {



    public static void main(String[] args) {


        ReadWriteLocking resources = new ReadWriteLocking();

        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread t1 = new Thread(() -> {

            resources.produce(lock);
        });

        Thread t2 = new Thread(() -> {

            resources.produce(lock);
        });

        ReadWriteLocking resources1 = new ReadWriteLocking();


        Thread t3 = new Thread(() -> {

            resources1.consume(lock);
        });


        t1.start();
        t2.start();
        t3.start();

    }


    }

