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

    javac -encoding utf8 Calculator.java CalculatorTest.java
    java CalculatorTest
*/
import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите первое число: ");
            calc.setFirstArg(scanner.nextInt());
            // skip CR+LF
            scanner.nextLine();

            System.out.print("Введите знак математической операции: ");
            calc.setOp(scanner.nextLine().charAt(0));

            System.out.print("Введите второе число: ");
            calc.setSecondArg(scanner.nextInt());
            // skip CR+LF
            scanner.nextLine();

            if (calc.execute()) {
                System.out.println(
                        calc.getFirstArg() + " " +
                        calc.getOp() + " " +
                        calc.getSecondArg() + " = " +
                        calc.getResult()
                        );
            } else {
                System.out.println("Ошибка: " + calc.getLastError());
            }

            String userAnswer;
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                userAnswer = scanner.nextLine();
            } while (!userAnswer.equals("yes") && !userAnswer.equals("no"));

            if (userAnswer.equals("no")) {
                break;
            }
        }
    }
}