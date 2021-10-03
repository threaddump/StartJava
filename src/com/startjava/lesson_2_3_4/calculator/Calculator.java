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

public class Calculator {

    private char op;
    private int firstArg;
    private int secondArg;
    private String lastError;

    public Calculator() {
        op = '?';
        firstArg = 0;
        secondArg = 0;
        lastError = "";
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public int getFirstArg() {
        return firstArg;
    }

    public void setFirstArg(int firstArg) {
        this.firstArg = firstArg;
    }

    public int getSecondArg() {
        return secondArg;
    }

    public void setSecondArg(int secondArg) {
        this.secondArg = secondArg;
    }

    public String getLastError() {
        return lastError;
    }

    private void setLastError(String lastError) {
        this.lastError = lastError;
    }

    public boolean validate() {
        if (secondArg == 0) {
            if ((op == '/') || (op == '%')) {
                setLastError("Деление на ноль");
                return false;
            } else if ((firstArg == 0) && (op == '^')) {
                // https://en.wikipedia.org/wiki/Zero_to_the_power_of_zero
                setLastError("Ноль в нулевой степени");
                return false;
            }
        } else if ((secondArg < 0) && (op == '^')) {
            setLastError("Отрицательные показатели степени не поддерживаются");
            return false;
        }

        char[] validOps = {'+', '-', '*', '/', '%', '^'};
        boolean validOp = false;
        for (char c : validOps) {
            if (op == c) {
                validOp = true;
                break;
            }
        }
        if (!validOp) {
            setLastError("Неизвестная операция");
            return false;
        }

        setLastError("");
        return true;
    }

    public int calculate() {
        switch (op) {
            case '+':
                return Math.addExact(firstArg, secondArg);
            case '-':
                return Math.subtractExact(firstArg, secondArg);
            case '*':
                return Math.multiplyExact(firstArg, secondArg);
            case '/':
                return Math.floorDiv(firstArg, secondArg);
            case '%':
                return Math.floorMod(firstArg, secondArg);
            case '^':
                return (int) Math.pow(firstArg, secondArg);
            default:
                // should never happen
                return 0;
        }
    }
}