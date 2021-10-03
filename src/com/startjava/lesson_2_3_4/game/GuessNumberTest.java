/*
    Урок 2, часть 6, задача 3

    Модифицируйте программу Угадай число:
        создайте классы:
            GuessNumber — отвечает за игровой процесс
            Player — описывает игроков (один экземпляр класса соответствует одному игроку)
            GuessNumberTest — отвечает за создание объектов, их инициализацию и запуск игры. Содержит метод main
        в игре участвуют два игрока, которые по очереди будут пытаться угадать число, загаданное компьютером, вводя его с клавиатуры
        имена игроков вводите с клавиатуры, а затем передавайте их в конструктор, создаваемых объектов Player
        созданных игроков передавайте в игру через ее конструктор и присвойте двум полям типа Player
        для генерации компьютером псевдослучайного числа в диапазоне (0, 100] используйте класс Random
        после каждой неудачной попытки для каждого игрока выводите подсказку:
            "Данное число больше того, что загадал компьютер" или
            "Данное число меньше того, что загадал компьютер"
        одержать победу может только один игрок
        по окончанию игры выводите сообщение "Хотите продолжить игру? [yes/no]:" (реализуйте это в GuessNumberTest):
            yes — игра запускается повторно с теми же самыми игроками и новым угадываемым числом
            no — игра завершается
            при вводе иного значения выводите сообщение до тех пор, пока не будут введены допустимые ответы

    javac -encoding utf8 -d out -sourcepath src src/com/startjava/lesson_2_3_4/game/GuessNumberTest.java
    java -cp out com.startjava.lesson_2_3_4.game.GuessNumberTest
*/
package com.startjava.lesson_2_3_4.game;

import java.util.Scanner;

public class GuessNumberTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        Player player1 = new Player(scanner.nextLine());

        System.out.print("Введите имя второго игрока: ");
        Player player2 = new Player(scanner.nextLine());

        GuessNumber game = new GuessNumber(player1, player2);
        
        while (true) {
            game.initialize();
            do {
                game.step(scanner);
            } while (!game.isComplete());
            game.reportWinner();

            String userAnswer;
            do {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                userAnswer = scanner.nextLine();
            } while (!userAnswer.equals("yes") && !userAnswer.equals("no"));

            if (userAnswer.equals("no")) {
                break;
            }
        }
    }
}