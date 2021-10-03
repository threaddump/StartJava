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

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;

    private int secretNumber;
    private Player activePlayer;
    private Player winner;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        secretNumber = 0;
        activePlayer = null;
        winner = null;
    }

    public boolean isComplete() {
        return (winner != null) || !(player1.anyAttemptsLeft() || player2.anyAttemptsLeft());
    }

    public void initialize() {
        System.out.println("Компьютер загадал случайное число от 0 до 100. Попробуйте его отгадать!");

        secretNumber = (int) (Math.random() * 100.0);
        activePlayer = (Math.random() < 0.5) ? player1 : player2;

        winner = null;

        player1.reset();
        player2.reset();
    }

    public void step(Scanner scanner) {
        int userGuess;
        do {
            System.out.print(
                    "Ход игрока " + activePlayer.getName() +
                    ". Осталось попыток - " + activePlayer.getAttemptsLeft() +
                    ". Введите число от 0 до 100: "
                    );

            userGuess = scanner.nextInt();
            // skip CR+LF
            scanner.nextLine();
        } while ((userGuess < 0) || (userGuess > 100));

        activePlayer.storeNumber(userGuess);
        activePlayer.burnAttempt();

        if (userGuess != secretNumber) {
            if (userGuess < secretNumber) {
                System.out.println("Данное число меньше того, что загадал компьютер");
            } else /* if (userGuess > secretNumber) */ {
                System.out.println("Данное число больше того, что загадал компьютер");
            }

            if (!activePlayer.anyAttemptsLeft()) {
                System.out.println("У " + activePlayer.getName() + " закончились попытки");
            }

            // switch player
            if (activePlayer == player1) {
                activePlayer = player2;
            } else /* if (activePlayer == player2) */ {
                activePlayer = player1;
            }
        } else {
            winner = activePlayer;
        }
    }

    public void reportResults() {
        System.out.println();

        if (winner != null) {
            System.out.println(
                    "Игрок " + winner.getName() +
                    " угадал число " + secretNumber +
                    " с " + (Player.MAX_ATTEMPTS - winner.getAttemptsLeft()) + " попытки"
                    );
        } else {
            System.out.println("Раунд завершен. У обоих игроков закончились попытки");
        }

        displayStoredNumbers(player1);
        displayStoredNumbers(player2);

        System.out.println();
    }

    private void displayStoredNumbers(Player player) {
        int[] numbers = player.getStoredNumbers();
        if (numbers.length > 0) {
            System.out.print("Числа, введенные игроком " + player.getName() + ": ");
            System.out.println(Arrays.toString(numbers));
        }
    }
}