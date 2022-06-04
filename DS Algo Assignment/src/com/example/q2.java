package com.example;

import java.util.*;

public class q2 {

        public int minCost(List<Person> personList)
        {
            PriorityQueue<Person> pq = new PriorityQueue<>();

            for (int i = 0; i < personList.size(); i++) {
                pq.add(personList.get(i));
            }

            int res = 0;

            while (pq.size() > 1) {
                Person first = pq.poll();
                Person second = pq.poll();

                res += first.getHeight() + second.getHeight();
                Person p = new Person();
                p.setHeight(first.getHeight() + second.getHeight());
                pq.add(p);
            }

            return res;
        }

    public static void main(String [] args){
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("Richard",5,1);
        Person person2 = new Person("Gavin",7,2);
        Person person3 = new Person("Peter",9,3);
//
        Person person4 = new Person("Laurie",2,4);

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        q2 minimumHeightQ2 = new q2();
        System.out.println(minimumHeightQ2.minCost(personList));
    }
}

