package com.example;


import java.util.HashMap;

public class q1 {

    private static class Node {
        Person person;
        Node left;
        Node right;

        Node(Person person){
            this.person = person;
            this.left = null;
            this.right = null;
        }
    }

    public HashMap<Person,Integer> duplicatePersonCount(Node root){
        HashMap<Person,Integer> personMap = new HashMap<>();
        inorderTraverse(personMap,root);
        return personMap;
    }

    public void inorderTraverse(HashMap<Person,Integer> map, Node node){
        if(node == null){
            return;
        }
        inorderTraverse(map,node.left);
        if(map.containsKey(node.person)){
            map.put(node.person, map.get(node.person)+1);
        }
        else{
            map.put(node.person,1);
        }
        inorderTraverse(map,node.right);
    }


    public static void main(String [] args){

        Person person1 = new Person("Richard",155,79);
        Person person2 = new Person("Gavin",162,62);
        Person person3 = new Person("Peter",130,59);

        Person person4 = new Person("Laurie",125,79);
        Person person5 = new Person("Gavin",162,62);
        Person person6 = new Person("Peter",130,59);
        /*              Tree  structure
                                   node1
                                /          \
                            node2         node3
                            /     \        /      \
                        node4 node5  node6

        */

        Node node1 = new Node(person1);
        Node node2 = new Node(person2);
        Node node3 = new Node(person3);
        Node node4 = new Node(person4);
        Node node5 = new Node(person5);
        Node node6 = new Node(person6);


        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

        q1 obj = new q1();
        HashMap<Person,Integer> personMap = obj.duplicatePersonCount(node1);

        System.out.println(personMap);

        // total values in tree is 6
        // two of which are duplicate values
        System.out.println(personMap.size());


    }
}