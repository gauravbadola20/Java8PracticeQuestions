public class QueueImplementation {



}

class Queue{
    private int arr[];
    private  int  start, end, currSize, maxSize;


    public Queue(){
        arr  = new int[16];
        start = -1;
        end = -1;
        currSize = 0;
    }

    public Queue(int maxSize){
        this.maxSize = maxSize;
        start = -1;
        end = -1;
        currSize = 0;
    }




    // to push th elements into queue
    public void push(int newElement){
         if (currSize == maxSize){
             System.out.println("Queue is full");
             System.exit(1);
         }


         if (end == -1){
             start = 0;
             end = 0;

         }else {
              end = (end + 1) %  maxSize;

              arr[end] = newElement;

              currSize++;
         }
    }


    public int pop(){
        if (start == -1){
            System.out.println("Queue is empty");
        }

        int poppedElement = arr[start];

        if (currSize == 1){
            start = -1;
            end = -1;

        }else {
            start = (start+1) % maxSize;
            currSize--;

        }
        return poppedElement;
    }


// to pop the element
    public int peek(){

        if (start == -1){
            System.out.println("Queue is empty");
        }

        return arr[start];
    }


    //  to find the size of array
    public int size(){
        return currSize;
    }
}
