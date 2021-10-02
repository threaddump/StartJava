/*
    Урок 1, часть 10, задача 3

    Выведите в цикле символы кодировки Unicode в диапазоне [9398, 10178]. Если выводятся кракозябры, то [33, 126]

    javac -encoding utf8 Unicode.java
    java Unicode
*/
public class Unicode {

    public static void main(String[] args) {
        //for (short i = 9398; i <= 10178; i++) {
        for (short i = 33; i <= 126; i++) {
            System.out.print((char) i);
        }
    }
}