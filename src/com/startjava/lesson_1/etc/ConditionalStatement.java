/*
    Урок 1, часть 7:

    Создайте класс ConditionalStatement с методом main
    Перепишите псевдокод, приведенный ниже, с помощью Java
    Используйте переменные, условные операторы, оператор ! (логическое НЕ)
    Выводите сообщения на консоль
    Не используйте переменные типа String

    javac -encoding utf8 -d out src/com/startjava/lesson_1/etc/ConditionalStatement.java
    java -cp out com.startjava.lesson_1.etc.ConditionalStatement
*/
package com.startjava.lesson_1.etc;

public class ConditionalStatement {
    
    public static void main(String[] args) {
        int age = 30;
        if (age > 20) {
            System.out.println("Возраст больше 20");
        }

        boolean isMale = true;
        if (isMale) {
            System.out.println("Пол - мужской");
        }
        if (!isMale) {
            System.out.println("Пол - женский");
        }

        double height = 1.83;
        if (height < 1.80) {
            System.out.println("Рост < 1.80");
        } else {
            System.out.println("Рост >= 1.80");
        }

        char nameFirstLetter = 'E';
        if (nameFirstLetter == 'M') {
            System.out.println("Первая буква имени - M");
        } else if (nameFirstLetter == 'I') {
            System.out.println("Первая буква имени - I");
        } else {
            System.out.println("Первая буква имени - не M, и не I");
        }
    }
}