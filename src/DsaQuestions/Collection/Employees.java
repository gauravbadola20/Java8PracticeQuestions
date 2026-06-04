package DsaQuestions.Collection;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Employees {

    private int id;
    private  String name;

    public Employees(int id, String name){

        this.id = id;
        this.name = name;
    }

    //ovveride the hascode method
    public int hashCode(){
        return Objects.hash(id,name);
    }

    //override the equals method
    public boolean equals(Object ob){

        if (this == ob){
            return  true;
        }
        if (ob == null || getClass() != ob.getClass()){
            return false;
        }

        Employees em = (Employees) ob;

        return id == em.id && Objects.equals(name,em.name);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id +
                ", name='" + name + "'}";
    }


    public static void main(String[] args) {
        Map<Employees,String> map  = new HashMap<>();


        Employees e1 = new Employees(101,"Gaurav");
        Employees e2 = new Employees(102,"Rahul");

        Employees e3 = new Employees(101, "Gaurav");

        map.put(e1,"Java developer");
        map.put(e2,"Spring boot developer");
//        map.put(e3,"Java develo");

        System.out.println(map.get(e1));
        System.out.println(map.get(e2));

        System.out.println(map.get(e3));


    }


}
