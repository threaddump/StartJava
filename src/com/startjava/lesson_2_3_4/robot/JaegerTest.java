/*
    Урок 2, часть 6, задача 2

    Модифицируйте класс Jaeger, сделав его универсальным (без инициализации полей в самом классе, как мы это делали в уроке). Это позволит на его основе создавать любого робота:
        информацию о роботах можно найти здесь: https://pacificrim.fandom.com/wiki/Category:Jaegers
        выберите два или более разных роботов. Найдите между ними что-то общее (поля, методы). Реализуйте это в коде (не усложняйте реализацию. Делайте все максимально просто)
        создайте 2 экземпляра класса Jaeger в классе JaegerTest и поэкспериментируйте с ними (проинициализируйте поля, вызывайте методы, перезаписывайте и выводите значения полей)
        для инициализации полей объектов при их создании используйте в начале сеттеры (покажите решение ментору), а потом перепишите, используя конструктор (1, 2)

    javac -encoding utf8 -d out -sourcepath src src/com/startjava/lesson_2_3_4/robot/JaegerTest.java
    java -cp out com.startjava.lesson_2_3_4.robot.JaegerTest
*/
package com.startjava.lesson_2_3_4.robot;

public class JaegerTest {

    public static void main(String[] args) {
        // init fields using setters
        Jaeger j1 = new Jaeger();
        j1.setModelName("Chronos Berserker");
        j1.setMark("Mark-5");
        j1.setWeapon("2x Hammerhead Missles");
        j1.setOperational(true);

        // init fields using ctor
        Jaeger j2 = new Jaeger("Titan Redeemer", "Mark-6", "M-19 Morning Star", false);

        System.out.println(
                "Jaeger 1: modelName = " + j1.getModelName() +
                "; mark = " + j1.getMark() +
                "; weapon = " + j1.getWeapon() +
                "; operational = " + j1.isOperational()
                );

        System.out.println(
                "Jaeger 2: modelName = " + j2.getModelName() +
                "; mark = " + j2.getMark() +
                "; weapon = " + j2.getWeapon() +
                "; operational = " + j2.isOperational()
                );

        j1.walk();
        j1.aim();
        j1.useWeapon();
        j1.setOperational(false);
        j1.walk();
        j1.setOperational(true);
        j1.useWeapon();
        j1.setWeapon("N/A");

        System.out.println(
                "Jaeger 1: modelName = " + j1.getModelName() +
                "; mark = " + j1.getMark() +
                "; weapon = " + j1.getWeapon() +
                "; operational = " + j1.isOperational()
                );
    }
}