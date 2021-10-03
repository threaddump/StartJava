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

public class Player {

    public static int MAX_ATTEMPTS = 10;

    private String name;
    private int attemptsLeft;
    private int[] numbers = new int[MAX_ATTEMPTS];

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAttemptsLeft() { return attemptsLeft; }

    public boolean anyAttemptsLeft() { return attemptsLeft > 0; }

    public void burnAttempt() { attemptsLeft--; }

    public void storeNumber(int number) {
        numbers[MAX_ATTEMPTS - attemptsLeft] = number;
    }

    public int[] getStoredNumbers() {
        return Arrays.copyOf(numbers, MAX_ATTEMPTS - attemptsLeft);
    }

    public void reset() {
        Arrays.fill(numbers, 0, MAX_ATTEMPTS - attemptsLeft, 0);
        attemptsLeft = MAX_ATTEMPTS;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", attemptsLeft=" + attemptsLeft +
                ", numbers=" + Arrays.toString(numbers) +
                '}';
    }
}