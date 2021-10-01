/*
    Урок 2, часть 3

    Создайте класс Wolf
        объявите в нем поля: пол, кличка, вес, возраст, окрас
        реализуйте методы: идти, сидеть, бежать, выть, охотиться
        в каждом методе выводите сообщение вида: "Воет", "Сидит" и тд
*/
public class Wolf {
    
    boolean male;
    String monicker;
    float weight;
    byte age;
    String color;

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