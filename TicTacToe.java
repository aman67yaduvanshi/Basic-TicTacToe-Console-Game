import java.util.*;

public class TicTacToe {

    static char[] board = {
            '1', '2', '3',
            '4', '5', '6',
            '7', '8', '9'
    };

    static void printBoard() {
        System.out.println();
        System.out.println("-------------");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("-------------");
    }

    static boolean checkWinner(char player) {

        if (board[0] == player && board[1] == player && board[2] == player)
            return true;

        if (board[3] == player && board[4] == player && board[5] == player)
            return true;

        if (board[6] == player && board[7] == player && board[8] == player)
            return true;

        if (board[0] == player && board[3] == player && board[6] == player)
            return true;

        if (board[1] == player && board[4] == player && board[7] == player)
            return true;

        if (board[2] == player && board[5] == player && board[8] == player)
            return true;

        if (board[0] == player && board[4] == player && board[8] == player)
            return true;

        if (board[2] == player && board[4] == player && board[6] == player)
            return true;

        return false;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char player = 'X';

        while (true) {

            printBoard();

            System.out.print("Player " + player + ", choose a position (1-9): ");
            int position = sc.nextInt();

            if (position < 1 || position > 9) {
                System.out.println("Invalid position! Choose between 1 and 9.");
                continue;
            }

            if (board[position - 1] == 'X' || board[position - 1] == 'O') {
                System.out.println("Position already taken! Choose another position.");
                continue;
            }

            board[position - 1] = player;

            if (checkWinner(player)) {
                printBoard();
                System.out.println("Player " + player + " wins!");
                break;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("The game is a draw!");
                break;
            }

            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }
        }

        sc.close();
    }
}
