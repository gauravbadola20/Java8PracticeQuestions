package Java8Practic;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.*;
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

        System.out.println(collect2);


    }








}
