/*
    Урок 2, часть 6, задача 2

    Модифицируйте класс Jaeger, сделав его универсальным (без инициализации полей в самом классе, как мы это делали в уроке). Это позволит на его основе создавать любого робота:
        информацию о роботах можно найти здесь: https://pacificrim.fandom.com/wiki/Category:Jaegers
        выберите два или более разных роботов. Найдите между ними что-то общее (поля, методы). Реализуйте это в коде (не усложняйте реализацию. Делайте все максимально просто)
        создайте 2 экземпляра класса Jaeger в классе JaegerTest и поэкспериментируйте с ними (проинициализируйте поля, вызывайте методы, перезаписывайте и выводите значения полей)
        для инициализации полей объектов при их создании используйте в начале сеттеры (покажите решение ментору), а потом перепишите, используя конструктор (1, 2)

    javac -encoding utf8 -d out -sourcepath src src/com/startjava/lesson_2_3/robot/JaegerTest.java
    java -cp out com.startjava.lesson_2_3.robot.JaegerTest
*/
package com.startjava.lesson_2_3.robot;

public class Jaeger {

    private String modelName;
    private String mark;
    private String weapon;
    private boolean operational;

    public Jaeger() {
        modelName = "N/A";
        mark = "N/A";
        weapon = "N/A";
        operational = true;
    }

    public Jaeger(String modelName, String mark, String weapon, boolean operational) {
        this.modelName = modelName;
        this.mark = mark;
        this.weapon = weapon;
        this.operational = operational;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public boolean isOperational() {
        return operational;
    }

    public void setOperational(boolean operational) {
        if (this.operational) {
            this.operational = operational;
        }
    }

    public void walk() {
        if (operational) {
            System.out.println(modelName + " is walking");
        } else {
            System.out.println(modelName + " is not operational");
        }
    }

    public void aim() {
        if (operational) {
            System.out.println(modelName + " is aiming");
        } else {
            System.out.println(modelName + " is not operational");
        }
    }

    public void useWeapon() {
        if (operational) {
            System.out.println(modelName + " uses his " + weapon + ". Pew-pew!");
        } else {
            System.out.println(modelName + " is not operational");
        }
    }
}