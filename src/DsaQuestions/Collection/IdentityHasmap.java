package DsaQuestions.Collection;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHasmap {


    public static void main(String[] args) {

        Map<String,String> map =
                new IdentityHashMap<>();

        String s1 = new String("Java");
        String s2 = new String("Java");


        map.put(s1,"Developer");

        map.put(s2,"Architect");


        System.out.println("This is using here string object");

//        System.out.println(map);


        String s3  = "test";
        String s4 = "test";

        map.put(s3,"Developer");
        map.put(s4,"Architect");

        System.out.println("This is using here String literal");

//        System.out.println(map);


        Employee e1 = new Employee(1);
        Employee e2 = new Employee(2);


        Map<Employee,String> em = new HashMap<>();

        em.put(e1,"Developer");
        em.put(e2,"Architect");

        System.out.println(em.size());



    }
}


class Employee {

    int id;

    Employee(int id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o){
        return true;
    }

    @Override
    public int hashCode(){
        return 1;
    }
}
