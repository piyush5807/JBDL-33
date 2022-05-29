package com.example;

import java.util.*;

public class Main{

    public static void main(String[] args) {
	// write your code here

        MyHashMap myHashMapChild = new MyHashMapChild();
        myHashMapChild.divide(50, 5);

        // Reference of interface and Instance of class
        MyMap myHashMap = new MyHashMap();
//        myHashMap.divide();

        // Reference and instance of the class
        MyHashMap map = new MyHashMap();


//        Main.InnerClass innerClass = new Main.InnerClass();
//        innerClass.func(10);

//        ArrayList<Integer> al = new ArrayList<>();
//        al.add(2);

        MyMap myMap = new MyMap() {
            @Override
            public int add(int a, int b) {
                System.out.println("In myMap code block:");
                return a + b + 1;
            }
        };

        MyMap myMap3 = (c, d) ->  {
            System.out.println("In lambda block of myMap3:");
            return c + d + 1;
        };

        System.out.println(myMap3.add(3, 4));
        System.out.println(myMap.add(3, 4));
//
//        MyMap myMap2 = new MyHashMap();
//
//        System.out.println(myMap2.add(3, 4)); // 7
//        System.out.println(myMap.add(3, 4)); // 8
//
//        // 2 , 1, 3, 1, 1, 1, 1, .....
//        // Sum of this list
//
//        // Q1. You are given a map of numbers and their frequency.
//        // 2 , 4
//        // 1, 45
//        // 3, 50
//
//        // 2*4 + 1*45 + 3*50 = 203
//        Map<Integer, Integer> frequencyMap = new HashMap<>();
//        frequencyMap.put(2, 4); // 8
//        frequencyMap.put(1, 45); // 45
//        frequencyMap.put(3, 50); // 150
//
//        frequencyMap.put(2, 5); // 10
//
//        int sum = 0;
//
//        Set<Map.Entry<Integer, Integer>> entrySet = frequencyMap.entrySet();
//
//        // Enhanced for loop
//        for(Map.Entry<Integer, Integer> entry : entrySet){
//            sum += entry.getKey() * entry.getValue();
//        }
//
////        Iterator<Map.Entry<Integer, Integer>> elements = frequencyMap.entrySet().iterator();
//
//        System.out.println(sum);

        /**  Collections
         *  List
         *  Map
         *  Set
         */


        List<String> cities = Arrays.asList("Delhi", "Mumbai");

        cities.stream().map(Main::replace)
                .forEach(System.out::println);

        // x -> System.out.println(x)

    }

    /**
        1. Streams - examples
        2. Exception Handing
        3. Multi Threading
     **/

    // Maven

    public static String replace(String a){
        return a.toUpperCase();
    }

    private static class InnerClass{

        private int a;

        public void func(int a){
            this.a = a;
            System.out.println("a = " + a);
        }

    }

    // JDK - compiles your code .java --> .class
    // JRE - contains JVM where .class file runs
}
