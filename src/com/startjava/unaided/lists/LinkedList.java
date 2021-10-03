/*
    Классическая задачка - разворот односвязного списка.

    javac -encoding utf8 -d out -sourcepath src src/com/startjava/unaided/lists/LinkedListTest.java
    java -cp out com.startjava.unaided.lists.LinkedListTest
*/
package com.startjava.unaided.lists;

public class LinkedList {

    public LinkedList next;
    public int data;

    public LinkedList(LinkedList next, int data) {
        this.next = next;
        this.data = data;
    }

    public static void print(LinkedList root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.next;
        }
        System.out.println();
    }

    public static LinkedList reverse(LinkedList root) {
        LinkedList prev = null;
        LinkedList cur = root;

        while (cur != null) {
            LinkedList next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}