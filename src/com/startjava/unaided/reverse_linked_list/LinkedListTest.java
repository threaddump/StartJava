/*
    Классическая задачка - разворот односвязного списка.

    javac -encoding utf8 -d out -sourcepath src src/com/startjava/unaided/reverse_linked_list/LinkedListTest.java
    java -cp out com.startjava.unaided.reverse_linked_list.LinkedListTest
*/
package com.startjava.unaided.reverse_linked_list;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList root = null;
        for (int i = 654; i < 679; i++) {
            root = new LinkedList(root, i);
        }

        System.out.println("Freshly created list: ");
        LinkedList.print(root);

        root = LinkedList.reverse(root);

        System.out.println("Reversed list: ");
        LinkedList.print(root);

        root = LinkedList.reverse(root);

        System.out.println("Reversed once again: ");
        LinkedList.print(root);
    }
}