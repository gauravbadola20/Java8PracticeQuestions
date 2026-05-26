package DsaQuestions.Oops;

import java.util.Objects;

public class RuntimPolymorphism {
    public static void main(String[] args) {


      Car car = new Sedan();// upc

        if (car instanceof Sedan) {
            Sedan s = (Sedan) car;



        }
        car.drive();




    }
}


class Car{


public void drive() {

        System.out.println("Driving Car");

}





}


class Sedan extends Car{


public void drive() {


        System.out.println("Driving Sedan");




    }


}




