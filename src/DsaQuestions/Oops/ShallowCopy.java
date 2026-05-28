package DsaQuestions.Oops;

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Pune");

        Employee e1 = new Employee("John", address);

//        Employee e2 =(Employee) e1.clone();
        Employee e2 = new Employee(e1);
        e2.address.city = "Mumbai";


        System.out.println(e2.address.city);
        System.out.println(e1.address.city);
    }



}


class Address{

    String city;

    Address(String city){
        this.city = city;
    }



}

class Employee implements Cloneable{


    String name;
    Address address;

    Employee(String name, Address address){

        this.name = name;
        this.address = address;
    }

    Employee(Employee other){

        this.name = other.name;

        this.address =
                new Address(
                        other.address.city
                );
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//
//        return super.clone();
//    }
}
