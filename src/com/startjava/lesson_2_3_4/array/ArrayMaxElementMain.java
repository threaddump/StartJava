package com.startjava.lesson_2_3_4.array;

import java.util.Scanner;

public class ArrayMaxElementMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину массива: ");
        int numElems = scanner.nextInt();
        int[] numbers = new int[numElems];

        System.out.print("Заполните массив целыми числами через пробел:");
        for (int i = 0; i < numElems; i++) {
            numbers[i] = scanner.nextInt();
        }

        int max = numbers[0];
        for (int elem: numbers) {
            max = Math.max(max, elem);
        }

        System.out.println("Максимальное число = " + max);
    }
}