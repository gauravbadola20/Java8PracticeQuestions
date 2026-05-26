package DsaQuestions.Oops;

public class SingleInheritance {


    public static void main(String[] args) {

        new Dog();






}}

class Animal {

    String type;

    Animal() {

        this("Unknown");

        System.out.println("Animal Default Constructor");
    }

    Animal(String type) {

        this.type = type;

        System.out.println(
                "Animal Parameterized Constructor : "
                        + type
        );
    }
}

class Dog extends Animal {

    String name;

    Dog() {

        this("Tommy");

        System.out.println("Dog Default Constructor");
    }

    Dog(String name) {

        super("Pet Animal");

        this.name = name;

        System.out.println(
                "Dog Parameterized Constructor : "
                        + name
        );
    }
}


