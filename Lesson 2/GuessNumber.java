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
*/
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
        return (winner != null);
    }

    public void initialize() {
        System.out.println("Компьютер загадал случайное число от 0 до 100. Попробуйте его отгадать!");
        secretNumber = (int) (Math.random() * 100.0);
        activePlayer = (Math.random() < 0.5) ? player1 : player2;
        winner = null;
    }

    public void step(Scanner scanner) {
        int userGuess;
        do {
            System.out.print("Ход игрока " + activePlayer.getName() + ". Введите число от 0 до 100: ");

            userGuess = scanner.nextInt();
            // skip CR+LF
            scanner.nextLine();
        } while ((userGuess < 0) || (userGuess > 100));

        if (userGuess != secretNumber) {
            // display hint
            if (userGuess < secretNumber) {
                System.out.println("Данное число меньше того, что загадал компьютер");
            } else /* if (userGuess > secretNumber) */ {
                System.out.println("Данное число больше того, что загадал компьютер");
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

    public void reportWinner() {
        System.out.println(winner.getName() + " отгадал число. Поздравляю с победой!");
    }
}