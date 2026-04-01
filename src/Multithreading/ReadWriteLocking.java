package Multithreading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocking {


    boolean isAvailable = false;

    public void produce(  ReadWriteLock lock ) {


        try{

            lock.readLock().lock();

            System.out.println(" Read Lock acquired by:  "+Thread.currentThread().getName());

            Thread.sleep(8000);


        }catch (Exception e){

        }finally {
             lock.readLock().unlock();
             System.out.println(" Read Lock released by:  "+Thread.currentThread().getName());

        }
    }


    public void consume(  ReadWriteLock lock ) {

        try{
            lock.writeLock().lock();

            System.out.println(" Write Lock acquired by:  "+Thread.currentThread().getName());

            isAvailable = true;
        }catch (Exception e){

        }finally {

            lock.writeLock().unlock();
            System.out.println(" WriteLock released by:  "+Thread.currentThread().getName());
        }
    }
}
