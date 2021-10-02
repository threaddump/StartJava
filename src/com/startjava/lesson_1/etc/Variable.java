/*
    Урок 1, часть 6:

    Создайте класс Variable с методом main
    Объявите в методе переменные всех существующих в Java примитивных типов данных. Каждой переменной присвойте значение
    В качестве значений используйте информацию о своем компьютере: количество ядер, частота процессора и тд.
    Выведите все значения переменных на консоль
    
    javac -encoding utf8 -d out src/com/startjava/lesson_1/etc/Variable.java
    java -cp out com.startjava.lesson_1.etc.Variable
*/
package com.startjava.lesson_1.etc;

public class Variable {
    
    public static void main(String[] args) {
        byte cpuPhysicalCores = 6;
        System.out.println(cpuPhysicalCores);

        short yearOfAssembly = 2014;
        System.out.println(yearOfAssembly);

        int psuPower = 600;
        System.out.println(psuPower);

        long cpuFreqHz = 3400000000L;
        System.out.println(cpuFreqHz);

        float cpuFreqGhz = 3.4f;
        System.out.println(cpuFreqGhz);

        double driveCSpaceUsedPct = 63.92857d;
        System.out.println(driveCSpaceUsedPct);

        char lastDriveLetter = 'H';
        System.out.println(lastDriveLetter);

        boolean powerOn = true;
        System.out.println(powerOn);
    }
}