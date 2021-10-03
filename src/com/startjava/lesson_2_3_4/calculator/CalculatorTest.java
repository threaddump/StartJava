/*
    Урок 2, часть 6, задача 1

    Модифицируйте программу Калькулятор:
        создайте класс CalculatorTest, который будет содержать метод main и отвечать за создание объектов, их инициализацию, ввод математического выражения и запуск вычислений
        класс Calculator будет содержать код, отвечающий за проверку математического знака и сами вычисления
        замените все if else, отвечающие за проверку математического знака, на оператор switch
        для ввода математического выражения используйте клавиатуру и класс Scanner
        формат ввода математического выражения:
            Введите первое число: 2
            Введите знак математической операции: ^
            Введите второе число: 10
        по окончанию каждого вычисления выводите сообщение "Хотите продолжить вычисления? [yes/no]:" (реализуйте это в CalculatorTest):
            yes — пользователю заново предлагается ввести математическое выражение
            no — программа завершается
            при вводе иного значения выводите сообщение до тех пор, пока не будут введены допустимые ответы

    Урок 4, часть 6, задача 1

    Модифицируйте программу Калькулятор:
        используйте следующий формат ввода (пример): Введите математическое выражение: 2 ^ 10
        введенное выражение храните в массиве. В этом поможет метод String.split()
        для преобразования чисел выражения из String в int используйте метод Integer.parseInt()
        замените методами класса Math, какие только сможете найти, ваши реализации вычислений
        метод calculate() должен возвращать результат вычисления. Выводите его в CalculatorTest

    javac -encoding utf8 -d out -sourcepath src src/com/startjava/lesson_2_3_4/calculator/CalculatorTest.java
    java -cp out com.startjava.lesson_2_3_4.calculator.CalculatorTest
*/
package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);

        do {
            /*
                TODO:
                the way we parse equation  is unsafe. "1 +* 2" would work fine, and the result will be the same as
                for "1 + 2" (that is - all characters, except 1st are ignored in 2nd token of equation). moreover,
                a check for the number of tokens is required.
            */
            System.out.print("Введите математическое выражение: ");
            String[] equationTokens = scanner.nextLine().split(" ", 3);
            calc.setFirstArg(Integer.parseInt(equationTokens[0]));
            calc.setOp(equationTokens[1].charAt(0));
            calc.setSecondArg(Integer.parseInt(equationTokens[2]));

            if (calc.validate()) {
                System.out.println(
                        calc.getFirstArg() + " " +
                        calc.getOp() + " " +
                        calc.getSecondArg() + " = " +
                        calc.calculate()
                        );
            } else {
                System.out.println("Ошибка: " + calc.getLastError());
            }
        } while (!acknowledgeExit(scanner));
    }

    private static boolean acknowledgeExit(Scanner scanner) {
        String userAnswer;
        do {
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            userAnswer = scanner.nextLine();
        } while (!userAnswer.equals("yes") && !userAnswer.equals("no"));

        return userAnswer.equals("no");
    }
}