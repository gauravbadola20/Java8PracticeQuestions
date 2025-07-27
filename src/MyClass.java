import java.security.PublicKey;
import java.util.Objects;

public class MyClass {

    public MyClass() {
        System.out.println("MyClass constructor called!");

    }



    public void greet(){
        System.out.println("Hello");
    }
}


class RefelectionExampleClass{

    public static void main(String[] args) {
        try{

            // Step 1: Get the class object for MyClass

            Class <?> myClass = Class.forName("MyClass");

            // Step 2: Create instance using default constructor
            Object obj = myClass.getDeclaredConstructor().newInstance();



            // Step 3: Cast to original class type (optional)

            if (obj instanceof MyClass){
                MyClass myClass1 = (MyClass) obj;

                myClass1.greet();
            }


        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
