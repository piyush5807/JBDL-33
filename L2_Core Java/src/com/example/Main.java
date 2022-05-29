package com.example;

import java.util.*;

public class Main implements AutoCloseable{

    public static void main(String[] args) {

//        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println("Running in which thread ?.." + Thread.currentThread().getName());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(26);
        set.add(1);
        set.add(2);
        set.add(46);
        set.add(66);
        set.add(76);

        for(Integer num : set){
            System.out.println("Encountered element " + num);
            if(num % 2 == 0){
                System.out.println(num);
                break;
            }
        }

        Optional<Integer> firstEvenNumber = set.stream()
                .filter(x -> {
                    System.out.println("Inside filter for element:" + x);
                    return x % 2 == 0;
                })
                .findFirst();

        Optional<Integer> firstEvenNumberP = set.parallelStream()
                .filter(x -> {
                    System.out.println("Inside filter for element parallel:" + x);
                    return x % 2 == 0;
                })
                .findFirst();

//        System.out.println(firstEvenNumber + " " + firstEvenNumberP);


        int[]arr = {1, 2, 3,4, 5, 6, 7, 8, 9, 10};

        // 2 4 6 8 10
        // 4 16 36 64 100
        // 220

        // 11, 22, 33, 44, 55, 66, 77, 88, 99, 1010

        int sum = 0;
        for(Integer number : numbers){
            if(number % 2 == 0){
                sum += number * number;
            }
        }
//        System.out.println(sum);


        set.stream()
                .filter(integer -> {
//                    System.out.println("In filter function: element " + integer + ", thread = " + Thread.currentThread().getName());
                    return integer % 2 == 0;
                }) // 10
                .map(integer -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    System.out.println("In map function: element " + integer + ", thread = " +  Thread.currentThread().getName());
                    return integer * integer;
                }).reduce(0, Main::subtract);

        // Sonar qube - code smells + bugs + vulnerabilities
        // Sonar lint plugin

        // 30 ops
//
//        System.out.println(Arrays.stream(arr)
//                .filter(x -> x % 2 == 0)
//                .map(x -> x * x)
//                .reduce(0, (x1, x2) -> x1 + x2));

//        System.out.println(result);


//        set.stream().parallel()
//                .filter(integer -> {
////                    System.out.println("In filter function: element " + integer + ", thread = " + Thread.currentThread().getName());
//                    return integer % 2 == 0;
//                }) // 10
//                .map(integer -> {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
////                    System.out.println("In map function: element " + integer + ", thread = " +  Thread.currentThread().getName());
//                    return integer * integer;
//                }).forEachOrdered(x -> System.out.println(x));
    }

    public static int subtract(int a, int b){
        return a - b;
    }

    @Override
    public void close() throws Exception {
        System.out.println("I am in the close function of main class");
    }
}