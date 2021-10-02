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
*/
public class Calculator {

    private char op;
    private int firstArg;
    private int secondArg;
    private int result;
    private String lastError;

    public Calculator() {
        op = '?';
        firstArg = 0;
        secondArg = 0;
        result = 0;
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

    public int getResult() {
        return result;
    }

    public String getLastError() {
        return lastError;
    }

    private void setLastError(String lastError) {
        this.lastError = lastError;
    }

    public boolean execute() {
        switch (op) {
        case '+':
            result = firstArg + secondArg;
            setLastError("");
            return true;
        case '-':
            result = firstArg - secondArg;
            setLastError("");
            return true;
        case '*':
            result = firstArg * secondArg;
            setLastError("");
            return true;
        case '/':
            if (secondArg != 0) {
                result = firstArg / secondArg;
                setLastError("");
                return true;
            } else {
                setLastError("Деление на ноль");
                return false;
            }
        case '%':
            if (secondArg != 0) {
                result = firstArg % secondArg;
                setLastError("");
                return true;
            } else {
                setLastError("Деление на ноль");
                return false;
            }
        case '^':
            if (secondArg > 0) {
                result = calcPositiveIntPower(firstArg, secondArg);
                setLastError("");
                return true;
            } else if (secondArg < 0) {
                setLastError("Отрицательные показатели степени не поддерживаются");
                return false;
            } else if (/* secondArg == 0 && */ firstArg != 0) {
                result = 1;
                setLastError("");
                return true;
            } else /* if (secondArg == 0 && firstArg == 0) */ {
                // https://en.wikipedia.org/wiki/Zero_to_the_power_of_zero
                setLastError("Ноль в нулевой степени");
                return false;
            }
        default:
            setLastError("Неизвестная операция");
            return false;
        }
    }

    private int calcPositiveIntPower(int base, int exp) {
        int power = 1;
        while (exp > 0) {
            power *= base;
            exp--;
        }
        return power;
    }

}