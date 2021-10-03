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

    Урок 4, часть 6, задача 2

    Модифицируйте программу Угадай число:
        используйте массив для хранения в классе Player, введенных игроком чисел
        после запуска игры выведите сообщение о том, что у каждого игрока по 10 попыток
        в конце игры выведите сообщение "Игрок " + имя + " угадал число " + число + " с " + номер + " попытки"
        если у игрока закончились попытки, то отобразите сообщение: "У " + имя + " закончились попытки"
        по окончанию игры отобразите, в две строки через пробел, все названные игроками числа (даже если никто не выиграл)
        если массив полностью не заполнен, т.е. пользователь угадал число менее чем за 10 попыток, то выводить весь массив не нужно
        для получения части массива используйте метод Arrays.copyOf
        для обнуления массива, при повторном запуске игры, используйте метод Arrays.fill(). При этом обнуляйте только те ячейки, где хранятся, названные игроками числа, а не весь массив
        попробуйте улучшить читаемость кода, разделив его на небольшие методы (рефакторинг)

    javac -encoding utf8 -d out -sourcepath src src/com/startjava/lesson_2_3_4/game/GuessNumberTest.java
    java -cp out com.startjava.lesson_2_3_4.game.GuessNumberTest
*/
package com.startjava.lesson_2_3_4.game;

import java.util.Scanner;

public class GuessNumberTest {

    // configuration
    private static int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        displayHelp();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        Player player1 = new Player(scanner.nextLine(), MAX_ATTEMPTS);

        System.out.print("Введите имя второго игрока: ");
        Player player2 = new Player(scanner.nextLine(), MAX_ATTEMPTS);

        GuessNumber game = new GuessNumber(player1, player2);
        
        do {
            game.initialize();
            do {
                game.step(scanner);
            } while (!game.isComplete());
            game.reportResults();
        } while (!acknowledgeExit(scanner));
    }

    private static void displayHelp() {
        System.out.println("Игра \"Угадай число\" для двух игроков.");
        System.out.println("Компьютер загадывает случайное целое число от 0 до 100. Ваша задача - угадать его.");
        System.out.println("В каждом раунде игрокам даётся по 10 попыток.");
        System.out.println();
    }

    private static boolean acknowledgeExit(Scanner scanner) {
        String userAnswer;
        do {
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            userAnswer = scanner.nextLine();
        } while (!userAnswer.equals("yes") && !userAnswer.equals("no"));

        return userAnswer.equals("no");
    }
}