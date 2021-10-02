/*
    Урок 2, часть 3

    Создайте класс Wolf
        объявите в нем поля: пол, кличка, вес, возраст, окрас
        реализуйте методы: идти, сидеть, бежать, выть, охотиться
        в каждом методе выводите сообщение вида: "Воет", "Сидит" и тд

    Урок 2, часть 5

    Модифицируйте класс Wolf
        у всех полей класса напишите модификатор доступа private
        а у его методов — public
        для доступа к полям создайте геттеры и сеттеры
        в сеттере поля age реализуйте проверку: если возраст волка > 8 лет, то выведите сообщение "Некорректный возраст". В противном случае сохраните значение в поле

    javac -encoding utf8 -d out -sourcepath src src/com/startjava/lesson_2_3/animal/WolfTest.java
    java -cp out com.startjava.lesson_2_3.animal.WolfTest
*/
package com.startjava.lesson_2_3.animal;

public class Wolf {
    
    private boolean male;
    private String monicker;
    private float weight;
    private byte age;
    private String color;

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getMonicker() {
        return monicker;
    }

    public void setMonicker(String monicker) {
        this.monicker = monicker;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        if (age > 8) {
            System.out.println("error: incorrect age");
        } else {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void walk() {
        System.out.println(monicker + " is walking");
    }

    public void sit() {
        System.out.println(monicker + " is sitting");
    }

    public void run() {
        System.out.println(monicker + " is running");
    }

    public void howl() {
        System.out.println(monicker + " is howling");
    }

    public void hunt() {
        System.out.println(monicker + " is hunting");
    }
}