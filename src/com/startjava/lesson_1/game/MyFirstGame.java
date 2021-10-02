/*
    Урок 1, часть 10, задача 2

    Напишите игру Угадай число:
        компьютер "загадывает" целое число от (0 до 100], которое необходимо угадать
        после каждой неудачной попытки выводите подсказку:
            "Данное число больше того, что загадал компьютер" или
            "Данное число меньше того, что загадал компьютер"
        если число угадано — "Поздравляю, число угадано!"
        меняйте значение переменной, хранящей числа игрока, автоматически по какому-то простому алгоритму (без применения ввода с клавиатуры или генерации рандомных чисел)
        игра продолжается до тех пор, пока число не будет угадано

    javac -encoding utf8 -d out src/com/startjava/lesson_1/game/MyFirstGame.java
    java -cp out com.startjava.lesson_1.game.MyFirstGame
*/
package com.startjava.lesson_1.game;

public class MyFirstGame {
    
    public static void main(String[] args) {
        // число, которое необходимо отгадать
        int secretNumber = 88;

        // число, вводимое пользователем
        int userGuess = 50;

        // основной цикл игры, вариант 1
        do {
            /*
                TODO: в этом месте следует считывать ввод пользователя,
                но по условию задачи пока что этого делать не нужно.
                вместо этого делаем простой алгоритм для автоматической смены числа.

                https://en.wikipedia.org/wiki/Lehmer_random_number_generator
                https://en.wikipedia.org/wiki/Primitive_root_modulo_n
                https://www.wolframalpha.com/input/?i=primitive+roots+of+101
            */
            userGuess = (userGuess * 46) % 101;

            System.out.println("Текущая догадка пользователя: " + userGuess);
            if (userGuess > secretNumber) {
                System.out.println("Данное число больше того, что загадал компьютер");
            } else if (userGuess < secretNumber) {
                System.out.println("Данное число меньше того, что загадал компьютер");
            }
        } while (secretNumber != userGuess);

        // основной цикл игры, вариант 2
        /*
        do {
            System.out.println("Текущая догадка пользователя: " + userGuess);
            if (userGuess > secretNumber) {
                System.out.println("Данное число больше того, что загадал компьютер");
                userGuess--;
            } else if (userGuess < secretNumber) {
                System.out.println("Данное число меньше того, что загадал компьютер");
                userGuess++;
            }
        } while (secretNumber != userGuess);
        */
        
        System.out.println("Поздравляю, число угадано!");
    }
}