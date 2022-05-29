package com.example;

import java.util.Map;

public class MyHashMap implements MyMap {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

//    @Override
//    public int subtract(int b, int b2) {
//        return 0;
//    }

    public int divide(int a, int b){
        return a / b;
    }

    public double power(int a, int b){
        return Math.pow(a, b);
    }
}
