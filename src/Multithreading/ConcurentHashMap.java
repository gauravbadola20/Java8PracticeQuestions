package Multithreading;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurentHashMap
{



    public static void main(String[] args){



        ConcurrentHashMap<String, Integer> map =
                new ConcurrentHashMap<>();


        String[] words = {
                "java",
                "spring",
                "java",
                "kafka",
                "spring",
                "java"
        };


        for (String word : words){


            map.merge(word , 1, Integer::sum);// MEREG FUNCITION IS USED TO INSERT VALUE IF ABSENT OTHER IT
            // COBINE THE VALUE WITH THE EXITING VALE USING remappingFunction
        }


//        System.out.println(map);




        ConcurrentHashMap<String, AtomicInteger> map1 =
                new ConcurrentHashMap<>();


        map1.put("home", new AtomicInteger(0));

        Runnable task = () ->{

            for (int i = 0; i < 1000; i++){
                 map1.get("home").incrementAndGet();
            }
        };


//        Thread t1 = new Thread(task);
//        Thread t2 = new Thread(task);
//
//        t1.start();
//        t2.start();

//                try {
//                    t1.join();
//                    t2.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

//        System.out.println(map1.get("home").get());




        //putIfAbsent
        ConcurrentHashMap<Integer,String> map2 = new ConcurrentHashMap<>();


        map2.putIfAbsent(1, "java");
        map2.putIfAbsent(2, "spring");
        map2.putIfAbsent(1, "java");
        map2.putIfAbsent(4, "kafka");
        map2.putIfAbsent(2, "spring");
        map2.putIfAbsent(1, "java");

        System.out.println(map2);
    }





}
