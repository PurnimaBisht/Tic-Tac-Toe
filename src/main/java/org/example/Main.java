package org.example;

import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false ;
        Scanner scanner = new Scanner(System.in);
        int filledCount = 0;
        while (!gameOver) {
            printBoard(board);
            if (filledCount == 9) {
                System.out.println("DRAW");
                break;
            }
            System.out.print("Player " + player + " enter: ");
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                System.out.println();
                if (board[row][col] == ' ') {
                    board[row][col] = player; // place the element
                    filledCount++;
                    gameOver = haveWon(board, player); // check whether the game is over or not
                     if (gameOver) {
                         printBoard(board);
                         System.out.println("Player " + player + " has won ");
                     }
                     else
                         player = (player == 'X') ? 'O' : 'X';
                }
                else {
                    System.out.println("Already marked. Try again!");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid move. Try again!");
            }
        }
    }
    public static boolean haveWon(char[][] board, char player) {
        for (int i = 0; i < board.length; i++) {
            // check the rows
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            // check for col
            else if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // check for diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false ;
    }
    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}