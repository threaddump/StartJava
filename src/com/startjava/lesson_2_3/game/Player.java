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

    javac -encoding utf8 -d out -sourcepath src src/com/startjava/lesson_2_3/game/GuessNumberTest.java
    java -cp out com.startjava.lesson_2_3.game.GuessNumberTest
*/
package com.startjava.lesson_2_3.game;

public class Player {

    private String name;
    private int number;
    
    public Player(String name) {
        this.name = name;
        number = 0;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}