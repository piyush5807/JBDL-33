package com.example;

public class MyHashMapChild extends MyHashMap{

    @Override
    public int divide(int a, int b){
        System.out.println("In MyHashMapChild: divide fn");
        return a / b;
    }

    public double power(int a, int b){
        System.out.println("In MyHashMapChild: power fn");
        return Math.pow(a, b);
    }
}
