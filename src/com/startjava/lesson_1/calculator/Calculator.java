/*
    Урок 1, часть 10, задача 1

    Реализуйте Калькулятор, который должен уметь выполнять математические операции (+, -, *, /, ^, %) над целыми положительными числами:
        что бы программа могла выполнить ту или иную математическую операцию (одну, а не все сразу), делайте проверку математического знака, используя if else
        выведите на экран результат вычисления с помощью System.out.println()
        Символ ^ используется в данном задании для обозначения операции возведения в степень, но в Java он выполняет совсем иную функцию. Использовать его для возведения в степень не получится. Самостоятельно реализуйте данную операцию (не используйте Math.pow())
        Символ %, похожий на проценты, называется оператором деления по модулю. В калькуляторе не надо считать проценты! Считайте остаток от деления

    javac -encoding utf8 Calculator.java
    java Calculator
*/
public class Calculator {

    public static void main(String[] args) {
        // operation (+, -, *, /, ^, %)
        char op = '-';

        // arguments (operands)
        int firstArg = 123;
        int secondArg = 24;

        // display the problem
        System.out.print(firstArg + " " + op + " " + secondArg + " = ");

        // execute operation and display result or error message
        if (op == '+') {
            System.out.println(firstArg + secondArg);
        } else if (op == '-') {
            System.out.println(firstArg - secondArg);
        } else if (op == '*') {
            System.out.println(firstArg * secondArg);
        } else if (op == '/') {
            if (secondArg != 0) {
                System.out.println(firstArg / secondArg);
            } else {
                System.out.println("Error (division by zero)");
            }
        } else if (op == '%') {
            if (secondArg != 0) {
                System.out.println(firstArg % secondArg);
            } else {
                System.out.println("Error (division by zero)");
            }
        } else if (op == '^') {
            if (secondArg > 0) {
                int power = 1;
                while (secondArg > 0) {
                    power *= firstArg;
                    secondArg--;
                }
                System.out.println(power);
            } else if (secondArg < 0) {
                System.out.println("Error (negative exponents are not supported)");
            } else if (/* secondArg == 0 && */ firstArg != 0) {
                System.out.println("1");
            } else /* if (secondArg == 0 && firstArg == 0) */ {
                // https://en.wikipedia.org/wiki/Zero_to_the_power_of_zero
                System.out.println("Error (0 ^ 0 is undefined)");
            }
        } else {
            System.out.println("Error (unknown or unsupported operation)");
        }
    }
}