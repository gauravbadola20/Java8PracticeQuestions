package Java8Practic;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rjstream {


    public static void main(String[] args) {


//        Filter even numbers

        List<Integer> list = List.of(2,3,4,2,5,5,5,5,56,7,8,11,12,13,14);

        List<Integer> list1 = list.stream()
                .filter(x -> x % 2 == 0)
                .toList();



//        2️⃣ Convert list of strings to uppercase

        List<String> str = List.of("Gaurav", "Shubhangi");
        List<String> strUppercase = str.stream()
                .map(String::toUpperCase)
                .toList();

//        Count elements greater than 10

        long count = list.stream()
                .filter(x -> x > 10)
                .count();
//        System.out.println(count);

        int sum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();

        Integer i = list.stream().reduce((x, y) -> x + y)
                .orElse(0);

//        Find max and min

        Integer i1 = list.stream().min(Comparator.naturalOrder())
                .orElse(0);


        // there is another way to find min and max

        Integer i2 = list.stream().max(Integer::compare).orElse(0);

//        Remove duplicates

        List<Integer> list2 = list.stream().distinct()
                .toList();

//        System.out.println(list2);

        // find duplicates

        HashSet<Integer> set = new HashSet<>();

        List<Integer> collect = list.stream().filter(x -> !set.add(x))
                .toList();


//        Sort numbers

        List<Integer> sortNumbers = list.stream().sorted().toList();

        // sort descending order

        List<Integer> collect1 = list.stream().sorted(Comparator.reverseOrder())
                .toList();
//
//        First element

        Integer i3 = list.stream().findFirst().orElse(0);

//        Any match / all match // any greater than 50

        boolean b = list.stream().anyMatch(x -> x > 50);

        boolean b1 = list.stream().allMatch(x -> x > 0);

//        1️⃣1️⃣ Count characters in a string

        String str1 = "gaurav and shubhangi";


        ConcurrentHashMap<Character, Integer> map = new ConcurrentHashMap<>();

        for (char word : str1.toCharArray()) {
            map.merge(word, 1, Integer::sum);
        }




        // now find the first non-repeative character

        Character c1 = str1.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),

                        LinkedHashMap::new,

                        Collectors.counting()

                )).entrySet()
                .stream().
                filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
//        System.out.println(c1);





        int[] nums = {6,7,8,1,2,3,4};

        int target = 3;



        int low = 0;
        int high = nums.length-1;

        while (low <= high){

            int mid = (low + high) / 2;

            // check if tartget found
            if (nums[mid] == target) {; }

            // if left part is sorted

            if (nums[low] <= nums[mid]){

                // check if the target lies in left sorted part

                if (nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }else{
                     low = mid + 1;
                }
            }else {

                // if right part is sorted

                if (nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }



//        Reverse each word

        String collect2 = Arrays.stream(str1.split(" "))
                .map(x -> new StringBuilder(x).reverse().toString())
                .collect(Collectors.joining(" "));

//                System.out.println(collect2);

//        Second highest number


        Integer highestNumber = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();

//        Sum of even numbers

        int sum1 = list.stream().filter(c -> c % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();



        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", "IT", 70000),
                new Employee(2, "Rahul", "IT", 90000),
                new Employee(3, "Neha", "HR", 60000),
                new Employee(4, "Pooja", "HR", 80000),
                new Employee(5, "Karan", "Finance", 75000)
        );
        //        1️⃣8️⃣ Group employees by department

        Map<String, List<Employee>> em = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

//        1️⃣9️⃣ Highest salary per department

        Map<String, Optional<Employee>> collect3 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                ));

//        5️⃣ Top 3 highest salaries

        List<Employee> list3 = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(5).toList();

        System.out.println(list3);


    }



}
