/*
    Урок 1, часть 10, задача 3

    Выведите в цикле символы кодировки Unicode в диапазоне [9398, 10178]. Если выводятся кракозябры, то [33, 126]

    javac -d out src/com/startjava/lesson_1/unicode/Unicode.java
    java -cp out com.startjava.lesson_1.unicode.Unicode
*/
package com.startjava.lesson_1.unicode;

public class Unicode {

    public static void main(String[] args) {
        //for (short i = 9398; i <= 10178; i++) {
        for (short i = 33; i <= 126; i++) {
            System.out.print((char) i);
        }
    }
}