package com.example;

import java.util.Objects;

public class Person implements Comparable<Person>{
    int age;
    String name;
    long height;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public Person(String name, int age, long height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && height == person.height && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, height);
    }

    @Override
    public int compareTo(Person o) {
        return (int)(this.getHeight() - o.getHeight());
    }
}

