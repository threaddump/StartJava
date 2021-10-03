/*
    Testing how System.arraycopy() works with overlapping source and destination.

    javac -encoding utf8 -d out src/com/startjava/unaided/arrays/ArrayCopy.java
    java -cp out com.startjava.unaided.arrays.ArrayCopy
*/
package com.startjava.unaided.arrays;

public class ArrayCopy {

    public static void main(String[] args) {
        // initialize and print array
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.pow(2, i);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // test copying when tail of src overlaps head of dst
        //System.arraycopy(arr, 0, arr, 3, 7);
        System.arraycopy(arr, 0, arr, 1, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // initialize array once again
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.pow(2, i);
        }

        // test copying when head of src overlaps tail of dst
        //System.arraycopy(arr, 3, arr, 0, 7);
        System.arraycopy(arr, 1, arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}