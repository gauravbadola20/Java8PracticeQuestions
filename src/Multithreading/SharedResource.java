package Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> sharedBuffer;
    private int bufferSize;


  public   SharedResource(int bufferSize){
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized  void produce(int items)throws Exception{

      //if buffer is full, wait for the consumer to consume items

        while (sharedBuffer.size()==bufferSize){

            System.out.println("Buffer is full, waiting for consumer to consume items");

            wait();
        }
        sharedBuffer.add(items);
        System.out.println("produced: "+items);


        //notify the consumer that tere are items to consume now
        notify();

    }


    public synchronized int consume() throws Exception{

      // if buffer is empty, wait for the producer to produce items

        while (sharedBuffer.isEmpty()){

            System.out.println("Buffer is empty, waiting for producer to produce items");

            wait();
        }

        int items = sharedBuffer.poll();

        System.out.println("Consumed: "+items);

        // notify the producer that there is a space in the buffer now
        notify();

        return items;

    }


}
