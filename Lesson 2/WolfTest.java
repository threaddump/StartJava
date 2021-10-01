/*
    Урок 2, часть 3

    Создайте класс WolfTest с методом main
        в нем создайте объект типа Wolf
        в этом же классе присвойте полям Wolf какие-то значения
        получите эти значения из полей и отобразите в консоли
        вызовите методы объекта

    javac Wolf.java WolfTest.java
    java WolfTest
*/
public class WolfTest {
    
    public static void main(String[] args) {
        Wolf w = new Wolf();

        w.male = true;
        w.monicker = "Greyback";
        w.weight = 42.1f;
        w.age = 5;
        w.color = "RAL 7011 (Iron Grey)";

        System.out.println("w.male = " + w.male);
        System.out.println("w.monicker = " + w.monicker);
        System.out.println("w.weight = " + w.weight);
        System.out.println("w.age = " + w.age);
        System.out.println("w.color = " + w.color);

        w.walk();
        w.sit();
        w.run();
        w.howl();
        w.hunt();
    }
}