public class StackImplementation {


    public static void main(String[] args){
        stack s = new stack();
        s.push(6);
        s.push(3);
        s.push(7);


        System.out.println("This is  top elenemt: "+s.peek());
        System.out.println("poped elemegt: "+s.pop());
    }


}

class stack{

    int size = 10000;
    int arr[] = new int[size];

    int top  = -1;


    void push(int x){
        top++;
        arr[top] = x;
    }

    int pop(){
        int x = arr[top];
        top--;
        return x;
    }


    // to find the peek
    int peek(){
        return arr[top];
    }


    int size(){
        return  top+1;
    }
}
