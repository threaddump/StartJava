/*
    Урок 1, части 2-5
*/
public class MyFirstApp {

    /*
        compile: javac -encoding utf8 MyFirstApp.java
            note: "-encoding utf8" is necessary to display cyrillic letters in console
        run class: java MyFirstApp
        decompile class: javap -c -p -s -verbose MyFirstApp.class

        make jar from class file: jar cf MyFirstApp.jar MyFirstApp.class
        run jar: java -cp MyFirstApp.jar MyFirstApp
        decompile class from jar: javap -c -p -s -verbose -cp MyFirstApp.jar MyFirstApp
    */
    
    public static void main(String[] args) {
        System.out.println("Привет, мир!");
    }
}