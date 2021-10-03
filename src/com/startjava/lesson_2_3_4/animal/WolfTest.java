/*
    Урок 2, часть 3

    Создайте класс WolfTest с методом main
        в нем создайте объект типа Wolf
        в этом же классе присвойте полям Wolf какие-то значения
        получите эти значения из полей и отобразите в консоли
        вызовите методы объекта

    Урок 2, часть 5

    Модифицируйте класс WolfTest
        с помощью сеттеров присвойте полям экземпляра класса Wolf какие-то значения
        считайте эти значения из полей с помощью геттеров и отобразите в консоли

    javac -encoding utf8 -d out -sourcepath src src/com/startjava/lesson_2_3_4/animal/WolfTest.java
    java -cp out com.startjava.lesson_2_3_4.animal.WolfTest
*/
package com.startjava.lesson_2_3_4.animal;

public class WolfTest {
    
    public static void main(String[] args) {
        Wolf w = new Wolf();

        w.setMale(true);
        w.setMonicker("Greyback");
        w.setWeight(42.1f);
        w.setAge((byte) 5);
        w.setColor("RAL 7011 (Iron Grey)");

        System.out.println("w.male = " + w.isMale());
        System.out.println("w.monicker = " + w.getMonicker());
        System.out.println("w.weight = " + w.getWeight());
        System.out.println("w.age = " + w.getAge());
        System.out.println("w.color = " + w.getColor());

        w.walk();
        w.sit();
        w.run();
        w.howl();
        w.hunt();
    }
}