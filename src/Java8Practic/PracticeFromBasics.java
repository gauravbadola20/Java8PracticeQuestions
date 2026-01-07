package Java8Practic;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.nio.IntBuffer.wrap;

public class PracticeFromBasics {


    public PracticeFromBasics() {
    }

    public static void main(String[] args) {

//        Lambda to add two numbers
        BiFunction<Integer, Integer, Integer> bi = (a, c) -> a + c;

        Function<Integer, Integer> function = (a) -> a + 1;


        Function<String, Integer> strLength = (a) -> a.length();

//        System.out.println(strLength.apply("Guarav"));

        //using  anoymous class
        Function<Integer,Integer> function1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 2;
            }
        };


        // using funcation with streams

        List<Integer> list = List.of(1, 2, 3,5,12);


        List<Integer> functionList = list.stream()
                .map(x -> x * 2).toList();

//        System.out.println(functionList);

        Function<Integer,Integer> doubleInt = (a -> a * 2);
        Function<Integer,Integer> squareInt = (a -> a*a);

        Function<Integer,Integer> result = doubleInt.andThen(squareInt);

//        System.out.println(result.apply(3));

        Function<Integer, Integer> res = doubleInt.compose(squareInt);

//        System.out.println(res.apply(3));


        // now solve the problems of predicde

        Predicate<Integer> isEven = a -> a % 2 == 0;
        Predicate<Integer> isPositive = a -> a > 0;

        list.stream().filter(isPositive.and(isEven))
                .forEach(System.out::println);

//        Reusable Predicate (advanced style)

//        Numbers divisible by 3 OR 5

        Predicate<Integer> div3 = a -> a % 3 == 0;

        Predicate<Integer> div5 = a -> a % 5 == 0;

//        list.stream().filter(div3.or(div5))
//                .forEach(System.out::println);




//        Names starting with A and ending with a
        List<String> stringList = List.of("anc", "Abc", "annn","Aa");

        Predicate<String> startA = x -> x.startsWith("A");
        Predicate<String> starta = x -> x.endsWith("a");

//        stringList.stream().filter(startA.and(starta)).forEach(System.out::println);


//        list.sort(Comparator.comparingInt(a -> a));

//        Convert Array to Stream

        int[] arr = {1, 2, 3, 4,11,12};

        IntStream stream = Arrays.stream(arr);


        Integer[] arr1 = {1, 2, 3};
        Stream<Integer> stream1 = Arrays.stream(arr1);

//        Find Sum of Array Elements

        int sum = Arrays.stream(arr).sum();

//        System.out.println(sum);


        // find the avergae of arr

        double average = Arrays.stream(arr).average().orElse(0);

//        System.out.println(average);



//        4️⃣ Find Maximum and Minimum

        int i = Arrays.stream(arr).min().orElse(0);

//        System.out.println(i);


//        Find Even Numbers


        int[] array = Arrays.stream(arr).filter(x -> x % 2 == 0)
                .toArray();

//        System.out.println(Arrays.toString(array));

//        Numbers Greater Than 10

     int []num =    Arrays.stream(arr).filter(x -> x > 10)
                .toArray();



//     System.out.println(Arrays.toString(num));


//        9️⃣ Square of Each Element

        int[] array1 = Arrays.stream(arr).map(x -> x * x)
                .toArray();
//        System.out.println(Arrays.toString(array1));


//        Multiply Each Element by 2

        int[] array2 = Arrays.stream(arr)
                .map(x -> x * 2)
                .toArray();

//        System.out.println(Arrays.toString(array2));
//        Sort Array Ascending

        int[] array3 = Arrays.stream(arr)
                .sorted()
                .toArray();

//        System.out.println(Arrays.toString(array3));


//        Sort Array Descending


        int[] array4 = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

//        System.out.println(Arrays.toString(array4));

//        Check If Any Number Is Even
//
//        boolean b = Arrays.stream(arr)
//                .anyMatch(c -> c > 0);

//        System.out.println(b);

//        🔹 DUPLICATES & DISTINCT

        int[] array5 = Arrays.stream(arr)
                .distinct().toArray();

//        System.out.println(Arrays.toString(array5));


//        1️⃣7️⃣ Find Duplicate Elements

        Set<Integer> set = new HashSet<>();

//        Arrays.stream(arr).filter(x -> !set.add(x))
//                .forEach(System.out::println);


//        Product of All Elements
        int reduce = Arrays.stream(arr)
                .reduce(1, (a, b) -> a * b);

//        System.out.println(reduce);
        int max = Arrays.stream(arr)
                .reduce(Integer::max)
                .orElseThrow();




//        0️⃣ Convert int[] to List<Integer>


        List<Integer> collect = Arrays.stream(arr)
                .boxed().collect(Collectors.toList());

//        System.out.println(collect);

        String[] names = {"gaurav", "badola"};

        String[] array6 = Arrays.stream(names)
                .map(String::toUpperCase).toArray(String[]::new);

//        System.out.println(Arrays.toString(array6));
//        2️⃣2️⃣ Find Strings Starting with "A"

        String[] g = Arrays.stream(names)
                .filter(c -> c.startsWith("g"))
                .toArray(String[]::new);

//        System.out.println(Arrays.toString(g));


//        Find Longest String

        String string = Arrays.stream(names)
                .max(Comparator.comparingInt(String::length))
                .orElse(" ");
//        System.out.println(string);


//        2️⃣4️⃣ Find Second Largest Number
        int i1 = Arrays.stream(arr)
                .distinct()
                .sorted()
                .skip(arr.length - 2)
                .findFirst().orElseThrow();

//        System.out.println(i1);


//        2️⃣5️⃣ Find First Non-Repeating Element

        Integer i2 = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        x -> x,
                        TreeMap::new,

                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();

//        System.out.println(i2);

//        2️⃣6️⃣ Frequency Count of Elements


        Map<Integer, Long> collect1 = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        x -> x,
                        Collectors.counting()
                ));


//        System.out.println(collect1);


        Optional<Integer> first = list.stream()
                .filter(n -> {
//                    System.out.println("filter------: " + n);
                    return n > 10;
                })
                .map(n -> {
//                    System.out.println("map--------: " + n);
                    return n * 2;
                })
                .findFirst();

//        System.out.println(first);


        boolean b = list.stream()
                .filter(
                        n ->{

//                            System.out.println("filter------: " + n);

                            return n % 2 == 0;

                        }
                )

                .anyMatch(c -> c > 10);


//        System.out.println(b);/

        List<List<String>> data = List.of(
                List.of("Java", "Spring"),
                List.of("Docker", "Kubernetes")
        );

        List<String> collect2 = data.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

//        System.out.println(collect2);

        String string1 = "java  stream api";

        // counting characters

        Map<Character, Long> collect3 = string1.chars()// chars() return the instream to make it char
//                we need to yype caST IT IN CHAR
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()

                ));

//        System.out.println(collect3);

//        Find first non-repeated character


        Character c1 = string1
                .chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,

                        Collectors.counting()

                ))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

//        3. Find duplicate characters

        String s = "programming";

        List<Character> collect4 = s
                .chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet()
                .stream()
                .filter(c -> c.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


//        4. Second highest number


        int[] nums = {5, 9, 11, 2, 8, 11};

        Integer i3 = Arrays.stream(nums).distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().orElse(null);


//        System.out.println(i3);

        String sentence = "Java 8 stream api interview questions";
//        5. Longest word in sentence

        String string2 = Arrays.stream(sentence.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

//        System.out.println(string2);

//        6. smallest word in the string
        String string3 = Arrays.stream(sentence.split(" "))
                .min(Comparator.comparingInt(String::length))
                .orElse(null);

//        System.out.println(string3);


        List<Integer> parList = List.of(1,2,3,4,5,6);

         parList.stream()
                .collect(Collectors.partitioningBy(
                        n -> n % 2 == 0
                ));

//        7. Sum of digits of a number

        int num1 = 12345;

        int sum1 = String.valueOf(num1)
                .chars()
                .map(c -> (char) c - '0')
                .sum();

//        🔥 8. Check palindrome using streams

        String s1 = "madam";

        boolean b1 = IntStream.range(0, s1.length() / 2)
                .allMatch(j -> s1.charAt(j) == s1.charAt(s1.length() - j - 1));



//        9. Sort map by values (DESC)

        Map<String, Integer> map = Map.of(
                "A", 3,
                "B", 1,
                "C", 2
        );

        LinkedHashMap<String, Integer> collect5 = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, c) -> a,
                        LinkedHashMap::new
                ));



//        🔥 10. Find common elements between two lists
        List<Integer> l1 = List.of(1,2,3,4);
        List<Integer> l2 = List.of(3,4,5,6);


        List<Integer> collect6 = l1.stream().filter(l2::contains)
                .collect(Collectors.toList());

//        System.out.println(collect6);

        // remove duplicates

        List<Integer> lust = List.of(1,2,2,3,1,4);

        List<Integer> collect7 = lust.stream()
                .distinct()
                .collect(Collectors.toList());

//        System.out.println(collect7);


//        🔥 12. Find max occurring character

        String sb = "banana";

        Map.Entry<Character, Long> characterLongEntry = sb.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                )).entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

//        System.out.println(characterLongEntry);

//        Group employees by department and find highest salary


        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", "IT", 70000),
                new Employee(2, "Rahul", "IT", 90000),
                new Employee(3, "Neha", "HR", 60000),
                new Employee(4, "Pooja", "HR", 80000),
                new Employee(5, "Karan", "Finance", 75000)
        );

        Map<String, Optional<Employee>> collect8 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                ));

//        System.out.println(collect8);


//        4. Infinite stream but limit safely

        // how to create infinite stream
//        Stream.iterate(1, n-> n+1)
//                .limit(10)
//                .forEach(System.out::println);


        // 🔥 15. Parallel stream side-effect bug



//        Count frequency of characters in a string


        String str = "gaurav badola";


        Map<Character,Integer> countFreq = new LinkedHashMap<>();

        for (char ch : str.toCharArray()){

            if (!countFreq.containsKey(ch)){

                countFreq.put(ch,1);

            }else{

             int count =    countFreq.get(ch);
             count++;
             countFreq.put(ch,count);
            }


        }

        System.out.println(countFreq);

//        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
//
//        concurrentHashMap.put(1, "A");
//
//
//        concurrentHashMap.forEach((k, v) -> {
//            concurrentHashMap.put(2, "B");
//        });


//        here we are do somdcnkf

        Map<Integer, String> conurrentCuurentHaspMap = new ConcurrentHashMap<>();

        conurrentCuurentHaspMap.put(1,"a");

        conurrentCuurentHaspMap.forEach((k,v) ->
        {
            System.out.println(k+ " "+v);
            conurrentCuurentHaspMap.put(2,"n");


        });


        Map<String, Integer> map1 = Map.of("A", 10, "B", 20);
        Map<String, Integer> map2 = Map.of("B", 30, "C", 40);

//        Map<String, Integer> res1 = new HashMap<>(map1);
//
//        map2.forEach((k, v) ->
//                res1.merge(k, v, Integer::sum)
//        );
//
//        System.out.println(res1);

        Map<String, Integer> res1 = new HashMap<>(map1);

        map2.forEach((k,v) ->{

            res1.merge(k,v, Integer::sum);

        });

        System.out.println(res1);







    }













}
