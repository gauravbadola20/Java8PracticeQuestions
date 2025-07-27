import java.util.Objects;
import java.util.Optional;

public class Employee {


    String name;

    double salary;


    public Employee(String name,  double salary) {
        this.name = name;

        this.salary = salary;

    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj){
            return true;
        }


        Employee employee  = (Employee) obj;

        return  name == employee.name && Objects.equals(name, employee.name);
    }







    public static void main(String[] args) {

        int arr[] = {2,3,4,7};
        int key = 4;

       int res =  findKey(arr,key);


    }


    public static int findKey(int arr[], int k){

        int left = 0;

        int right = arr.length;

        while (left <= right){
            int mid = (left + right)/2;


            if (arr[mid] == k){
                return mid;
            }else if (arr[mid] < k){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }














}
