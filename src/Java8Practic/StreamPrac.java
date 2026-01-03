package Java8Practic;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.SQLSyntaxErrorException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPrac {


    public static void main(String[] args) {


        List<String> list = List.of("java", "spring", "boot");


        // convert the strings into uppervase

        List<String> collect = list.stream().map(String::toUpperCase).
                toList();

        // filter even number

        List<Integer> nums = List.of(1,2,3,4,5,6,1,2,3,1,1);

      List<Integer> even =   nums.stream().filter(x ->x % 2 == 0)
                .toList();

      // count elements greater than 3
        long count = nums.stream().filter(x -> x > 3)
                .count();

//        sum of all numbers

        int sum = nums.stream().mapToInt(Integer::intValue).sum();

//        . Find first element
        Optional<Integer> first = nums.stream().findFirst();

//        Remove duplicates

        List<Integer> collect1 = nums.stream().distinct().collect(Collectors.toList());


        // sort list in desending order
        List<Integer> collect2 = nums.stream().sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());


        //sort list in ascending order
        List<Integer> collect3 = nums.stream().sorted(Comparator.comparing(Integer::intValue)).
                collect(Collectors.toList());



//        Find maximum value

        Optional<Integer> max = nums.stream().max(Comparator.naturalOrder());
        System.out.println(max);


//        Convert List → Set

        Set<Integer> collect4 = nums.stream().collect(Collectors.toSet());

        // convert this list into map

        Map<Integer, Integer> collect5 = nums.stream().collect(Collectors.toMap(
                        Function.identity(),
                Function.identity(), (oldValue, newValue) -> oldValue
        ));

//        System.out.println(collect5);

        //Join strings with comma

        List<String> strList = List.of("java", "spring", "boot");

        String collect6 = strList.stream().map(x -> x).collect(Collectors.joining(", "));

//        . Group numbers by even & odd

        Map<Boolean, List<Integer>> evenOdd = nums.stream().collect(Collectors.
                groupingBy(x -> x % 2 == 0));


//        System.out.println(evenOdd);


//        Count frequency of each element


        Map<Integer, Long> groupElements = nums.stream().collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()

        ));

//        Partition employees by salary > 50k

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", "IT", 60000),
                new Employee(2, "Ravi", "HR", 45000),
                new Employee(3, "Neha", "Finance", 75000),
                new Employee(4, "Priya", "IT", 30000)
        );

        Map<Boolean, List<Employee>> salaryGroup = employees.stream().collect(Collectors.
                partitioningBy(x -> x.getSalary() < 75000));


//        Q: Partition employees by salary > 50k and count in each group.

      Map<Boolean, Long> collect7 = employees.stream().collect(Collectors.partitioningBy(
              x -> x.getSalary() > 50000,
              Collectors.counting()
      ));


      //    Find max salary employee in salary > 50k and ≤ 50k.

      Map<Boolean, Optional<Employee>> collect8 = employees.stream().collect(Collectors.groupingBy(
              x -> x.getSalary() > 50000,

              Collectors.maxBy(Comparator.comparing(Employee::getSalary))
      ));

//      : Partition employees and return only names.

      Map<Boolean, List<String>> collect9 = employees.stream()
              .collect(Collectors.partitioningBy(
                      x -> x.getSalary() > 50000,
                      Collectors.mapping(Employee::getName, Collectors.toList())
              ));

//      System.out.println(collect9);


//      can we partition on multiple condition, yes we can do it with help of groupingBy
      Map<String, List<Employee>> em = employees.stream().collect(Collectors.groupingBy(
              e -> {
                if (e.getSalary() > 70000) return "high";

                else if (e.getSalary() > 50000) return "medium";

                else return "low";
              }
      ));

//      System.out.println(em);

//      Average salary for both partitions.

      Map<Boolean, Double> partitionSlary = employees.stream().collect(Collectors.groupingBy(
              e -> e.getSalary() > 50000,

              Collectors.averagingDouble(Employee::getSalary)
      ));



//      System.out.println(partitionSlary);

//      Q: Partition employees, then group by department.


      Map<Boolean, Map<String, List<Employee>>> collect10 =
              employees.stream().collect(Collectors.groupingBy(
              x -> x.getSalary() > 50000,
              Collectors.groupingBy(Employee::getDepartment)
      ));

//      System.out.println(collect10);

//      . Average of numbers

      double v = nums.stream().mapToInt(Integer::intValue)
              .average().orElse(0);

//      15. Find highest paid employee

      Optional<Employee> max1 = employees.stream().max(
              Comparator.comparing(Employee::getSalary)
      );


//      System.out.println(max1);


//      16. Flatten list of lists
      List<List<Integer>> lists = List.of(List.of(1,2), List.of(3,4));
      List<Integer> list1 = lists.stream().flatMap(List::stream)
              .toList();

//      System.out.println(list1);


//      17. Find duplicate elements

      Set<Integer> seen = new HashSet<>();
      List<Integer> duplicateElements = nums.stream().filter(n -> !seen.add(n))
              .collect(Collectors.toList());

//      System.out.println(duplicateElements);

//      18. Second highest number

      Optional<Employee> first1 = employees.stream()
              .sorted(Comparator.comparing(Employee::getSalary).reversed())
              .skip(1)
              .findFirst();

//      System.out.println(first1);


      Optional<Integer> first2 = nums.stream().distinct().sorted(Comparator.reverseOrder())
              .skip(1)
              .findFirst()  ;

//      System.out.println(first2);

//      Group employees by departmen
//      Map<String, List<Employee>> map = employees.stream()
//              .collect(Collectors.groupingBy(Employee::getDepartment));

//      20. Department-wise highest salary

      Map<String, Optional<Employee>> map =
              employees.stream()
                      .collect(Collectors.groupingBy(
                              Employee::getDepartment,
                              Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                      ));


//      System.out.println(map);




      // string questions

      String str = "gaurav  badola";

      Map<String, Long> collect11 = Arrays.stream(str.trim().split(" "))
              .collect(Collectors.groupingBy(
                      x -> x,
                      Collectors.counting()
              ));
//      System.out.println(collect11);

      // COUNT THE NUMBER OF FREQUENCY IN STRING

        Map<Character, Long> strFrequency = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ').collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));


        // count frequency of a string in sorted order

        LinkedHashMap<Character, Long> countFtq = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

//        System.out.println(countFtq);

        //find first non-repeating character

        Map<Character, Long> characterLongEntry = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() == 1)

                .findFirst()
                .map(e -> Map.of(e.getKey(), e.getValue()))
                .orElse(null);




        // find first no repeating character
        List<Character> list2 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();




//        System.out.println(c1);


        //f reemove  the duplicate characters

      String removeDuplicateElements = str.chars().distinct()
                .mapToObj(c ->   String.valueOf ((char) c )  )
                .collect(Collectors.joining());

//        System.out.println(removeDuplicateElements);


//        Count frequency of each word

        Map<String, Long> countFreqWord = Arrays.stream(str.split("  "))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));


//        Sort characters by frequency


        str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Character,Long>comparingByValue().reversed())
                ;

//


        //Count frequency of each character

        Map<Character, Long> countFreq = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),

                        Collectors.counting()
                ));



//        First non-repeating character

    Map.Entry<Character,Long> ch =  str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()

                .filter(c -> c.getValue() == 1)

                .findFirst().orElse(null);

//        First repeating character


        Map.Entry<Character, Long> sortthe = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,

                        Collectors.counting()

                ))
                .entrySet().stream().filter(c -> c.getValue() > 1)
                .findFirst().orElse(null);


//        All non-repeating characters

        List<Map.Entry<Character, Long>> list3 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream().filter(c -> c.getValue() > 1).toList();

//        System.out.println(list3);


//        Remove duplicate characters

        str.chars().mapToObj(c -> (char) c)
                .distinct()
                .collect(Collectors.toList());
    }













}
