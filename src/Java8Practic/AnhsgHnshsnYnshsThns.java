package Java8Practic;

import java.util.*;
import java.util.stream.Collectors;

public class AnhsgHnshsnYnshsThns {


    public static void main(String[] args) {
//        1. Find all even numbers

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,1,1,1,2,22,2);


        List<Integer> evenList = nums.stream()
                .filter(x -> x % 2 == 0)
                .toList();

//        2. Convert all names to uppercase


        List<String> names = Arrays.asList("gaurav", "aman", "rahul");

        List<String> uppercaseString = names.stream().map(String::toUpperCase)
                .toList();



//        3. Find sum of all numbers
        Optional<Integer> sumNumbers = nums.stream()
                .reduce(Integer::sum);

//        System.out.println(sumNumbers);


//        4. Find maximum number

        Optional<Integer> maxElemensts = nums.stream()
                .min(Integer::compare);

//        System.out.println(maxElemensts);

//        5. Count strings starting with A

        long count = names.stream().map(String::toUpperCase)
                .filter(x -> x.startsWith("A"))
                .count();

//        System.out.println(count);

//        6. Remove duplicates

        List<Integer> list = nums.stream()
                .distinct().toList();

//        System.out.println(list);


        // find duplicate
        Set<Integer> set = new HashSet<>();
        List<Integer> list1 = nums.stream()
                .filter(x -> !set.add(x))
                .toList();

//        System.out.println(list1);

        List<Employee> employees = Arrays.asList(
                new Employee(1,"John","IT", 20000),
                new Employee(2,"Tom","Account", 10000),
                new Employee(3,"Rom","HR", 2000),
                new Employee(4,"BOob","BR", 1000)

        );

        //    7. Sort employees by salary

        List<String> employeeSortedList = employees.stream().map(x->x.getName())
                .sorted()
                .toList();

//        System.out.println(employeeSortedList);

        List<String> list2 = employees.stream().map(x -> x.getName())
                .toList();

//        System.out.println(employeeSortedList);

//        8. Find second highest number

        Optional<Integer> first = nums.stream().distinct()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst();
//        System.out.println(first);


//        9. Find first non-repeated character

        String str = "stress";

    Character ch =  str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                        .entrySet()
                                .stream()
                                        .filter(x -> x.getValue() == 1)
                                                .map(Map.Entry::getKey)
                                                        .findFirst()
                                                                .get();

//        System.out.println(ch);

//        10. Group employees by department

        Map<String,  Long> emList = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        )
                );

//        System.out.println(emList);
//        12. Find frequency of each character

        Character c1 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)

                .map(x -> x.getKey())
                .findFirst().get();

//        System.out.println(c1);


//        13. Partition numbers into even and odd

        Map<Boolean, List<Integer>> partition = nums.stream()
                .collect(Collectors.partitioningBy(
                        x -> x % 2 == 0
                ));

//        System.out.println(partition);

//        14. Get top 3 highest salaries

        List<Employee> top3EmpSalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3)
                .toList();

        Map<String, Double> collect = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Employee::getSalary
                ));

//        System.out.println(collect);

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );


        List<String> flatList = nestedList.stream()
                .flatMap(Collection::stream)
                .toList();

//        System.out.println(flatList);

//        17. Find employee with highest salary

        Optional<Employee> max = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));

//        System.out.println(max);


//        18. Average salary of employees

        Double collect1 = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

//        System.out.println(collect1);

        String collect2 = names.stream()
                .collect(Collectors.joining(","));

//        System.out.println(collect2);


        String  word = "Java Spring java boot spring";

        Map<Character, Long> wordFrequency = word.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isAlphabetic)
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));


        Map<String, Long> wordFre = Arrays.stream(word.split(" "))
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));

    }







}
