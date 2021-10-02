/*
    Урок 2, часть 2

    Создайте класс Person (без метода main)
    Напишите в нем поля (атрибуты), описывающие характеристики человека: пол, имя, рост, вес, возраст
    Проинициализируйте их какими-то значениями
    Создайте в классе методы, описывающие поведение (что он может делать) человека: идти, сидеть, бежать, говорить, учить Java

    javac -encoding utf8 -d out src/com/startjava/lesson_2_3/person/Person.java
*/
package com.startjava.lesson_2_3.person;

public class Person {

    boolean male = true;
    String name = "John Doe";
    float height = 1.84f;
    float weight = 75.0f;
    byte age = 30;

    public void walk() {
        System.out.println(name + " is walking");
    }

    public void sit() {
        System.out.println(name + " is sitting");
    }

    public void run() {
        System.out.println(name + " is running");
    }

    public void speak(String what) {
        System.out.println(name + " says: " + what);
    }

    public void learnJava() {
        System.out.println(name + " is learning Java");
    }
}