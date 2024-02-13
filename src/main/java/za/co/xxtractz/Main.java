package za.co.xxtractz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
         * 0|X|0
         * -+-+-
         * X|O|X
         * -+-+-
         * X|0|X
         * */
        Character[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        Scanner scanner = new Scanner(System.in);

        boolean player2Turn = false;
        boolean player1Turn = true;

        while (true) {

            if (player1Turn) {
                //We want player 1 inputs and also handle errors
                System.out.print("PLayer1 Enter your placement (1-9): ");
                int player1 = scanner.nextInt();

                if (gameBoard[0][0] == ' ' && player1 == 1) {
                    gameBoard[0][0] = 'X';
                    player2Turn = true;
                    player1Turn = false;
                }
                if (gameBoard[0][2] == ' ' && player1 == 2) {
                    gameBoard[0][2] = 'X';
                    player2Turn = true;
                    player1Turn = false;
                }
                if (gameBoard[0][4] == ' ' && player1 == 3) {
                    gameBoard[0][4] = 'X';
                    player2Turn = true;
                    player1Turn = false;
                }
                if (gameBoard[2][0] == ' ' && player1 == 4) {
                    gameBoard[2][0] = 'X';
                    player2Turn = true;
                    player1Turn = false;
                }
                if (gameBoard[2][2] == ' ' && player1 == 5) {
                    gameBoard[2][2] = 'X';
                    player2Turn = true;
                    player1Turn = false;
                }

                if (gameBoard[2][4] == ' ' && player1 == 6) {
                    gameBoard[2][4] = 'X';
                    player2Turn = true;
                    player1Turn = false;
                }

                if (gameBoard[4][0] == ' ' && player1 == 7) {
                    gameBoard[4][0] = 'X';
                    player2Turn = true;
                    player1Turn = false;
                }

                if (gameBoard[4][2] == ' ' && player1 == 8) {
                    gameBoard[4][2] = 'X';
                    player2Turn = true;
                    player1Turn = false;
                }

                if (gameBoard[4][4] == ' ' && player1 == 9) {
                    gameBoard[4][4] = 'X';
                    player2Turn = true;
                    player1Turn = false;
                }

                if (player1 < 1 || player1 > 9) {
                    break;
                }
            }
            // Player 2 and Handle errors

            if (player2Turn) {
                System.out.print("Player 2 Enter your placement (1-9): ");
                int player2 = scanner.nextInt();

                if (gameBoard[0][0] == ' ' && player2 == 1) {
                    gameBoard[0][0] = '0';
                    player1Turn = true;
                    player2Turn = false;
                }
                if (gameBoard[0][2] == ' ' && player2 == 2) {
                    gameBoard[0][2] = '0';
                    player1Turn = true;
                    player2Turn = false;
                }
                if (gameBoard[0][4] == ' ' && player2 == 3) {
                    gameBoard[0][4] = '0';
                    player1Turn = true;
                    player2Turn = false;
                }
                if (gameBoard[2][0] == ' ' && player2 == 4) {
                    gameBoard[2][0] = '0';
                    player1Turn = true;
                    player2Turn = false;
                }
                if (gameBoard[2][2] == ' ' && player2 == 5) {
                    gameBoard[2][2] = '0';
                    player1Turn = true;
                    player2Turn = false;
                }

                if (gameBoard[2][4] == ' ' && player2 == 6) {
                    gameBoard[2][4] = '0';
                    player1Turn = true;
                    player2Turn = false;
                }

                if (gameBoard[4][0] == ' ' && player2 == 7) {
                    gameBoard[4][0] = '0';
                    player1Turn = true;
                    player2Turn = false;
                }

                if (gameBoard[4][2] == ' ' && player2 == 8) {
                    gameBoard[4][2] = '0';
                    player1Turn = true;
                    player2Turn = false;
                }

                if (gameBoard[4][4] == ' ' && player2 == 9) {
                    gameBoard[4][4] = '0';
                    player1Turn = true;
                    player2Turn = false;
                }

                if (player2 < 1 || player2 > 9) {
                    break;
                }
            }
        }

        printGameCard(gameBoard);
    }

    private static void printGameCard(Character[][] gameBoard) {
        for (Character[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}