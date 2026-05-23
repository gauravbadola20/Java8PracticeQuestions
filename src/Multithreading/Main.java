package Multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class BankAccount {


     private int balance = 1000;

     // create readwritelock

     private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

     //Read operation
    public void checkBalance() {

        // acquire read lock

        lock.readLock().lock();
        try{

            System.out.println(Thread.currentThread().getName()
            + " Reading Balance: " + balance);

        }catch (Exception e){
            e.printStackTrace();
        }finally {


            //Always lock  release in finally block
            lock.readLock().unlock();
        }
    }



    // write operation
    public void deposit(int amount){

        // acquire lock
        lock.writeLock().lock();
        try{

            System.out.println(Thread.currentThread().getName()
            + "Updating Balance: " + balance);

            balance = balance  + amount;

            Thread.sleep(2000);

            System.out.println("Balance Updated: " + balance);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // reales the lock in finally block
            lock.writeLock().unlock();
        }
    }


 }

     public class Main{

    public static void main(String[] args) {


        BankAccount bankAccount = new BankAccount();

        //Multiple threads

        Thread t1 = new Thread(bankAccount::checkBalance);

        System.out.println("Readers 1");

        Thread t2 = new Thread(bankAccount::checkBalance);

        System.out.println("Readers 2");


        // writer
        Thread t3 = new Thread(() -> {

            bankAccount.deposit(1000);
        },"Writer");

        t1.start();
        t2.start();
        t3.start();
        }

    }

