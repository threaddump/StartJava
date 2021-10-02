/*
    Урок 1, часть 8:

    Создайте класс Cycle с методом main
    Выведите на консоль с помощью цикла for все числа от [0, 20]
    Выведите на консоль с помощью цикла while все числа от [6, -6] (с шагом итерации 2)
    Подсчитайте с помощью цикла do-while сумму нечетных чисел от [10, 20]. Выведите ее на консоль

    javac -encoding utf8 -d out src/com/startjava/lesson_1/etc/Cycle.java
    java -cp out com.startjava.lesson_1.etc.Cycle
*/
package com.startjava.lesson_1.etc;

public class Cycle {
    
    public static void main(String[] args) {
        System.out.println("Все числа от 0 до 20:");
        for (int i = 0; i <= 20; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Числа от 6 до -6 с шагом 2:");
        int i = 6;
        while (i >= -6) {
            System.out.print(i + " ");
            i -= 2;
        }
        System.out.println();

        int sum = 0;
        i = 10;
        do {
            if ((i % 2) != 0) {
                sum += i;
            }
            i++;
        } while (i <= 20);
        System.out.println("Сумма нечетных чисел в диапазоне от 10 до 20: " + sum);
    }
}