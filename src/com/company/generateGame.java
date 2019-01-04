package com.company;
import java.util.Random;

public class generateGame {

    public static char[][] board = new char[3][3];
    String status;
    private int numMoves;
    private Random rd = new Random();
    static boolean doneTurn = false;

    public generateGame() {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        status = "";
        numMoves = 0;
    }

    public void printGame(char[][] board) {
        System.out.println("  1   2   3");
        String pboard = "";
        for (int i = 0; i < board.length; i++) {
            pboard = pboard + Integer.toString(i + 1) + " ";
            for (int j = 0; j < board[i].length; j++) {
                if (j == board[i].length - 1) pboard = pboard + (board[i][j]);
                else pboard = pboard + (board[i][j] + " | ");
            }
            pboard = pboard + "\n";
        }
        System.out.println(pboard);
    }


    public void makeMove(char[][] board, int row, int column, char player) {
        if (board[row][column] == 0) {
            board[row][column] = player;
            numMoves++;
            doneTurn = true;
        } else {
            System.out.println("\nThat slot is occupied!\n");
            doneTurn = false;
        }
    }

    public boolean checkStatus(char[][] board) {
        if (numMoves == 9) {
            System.out.println("\nIt's a tie!");
            return true;
        }
        if(checkWin(board, 'X')) {
            System.out.println("\nPlayer " + 1 + " is the winner!");
            return true;
        }
        else if(checkWin(board, 'O')) {
            System.out.println("\nPlayer " + 2 + " is the winner!");
            return true;
        }

        return false;
    }

    public static boolean checkWin(char [][] board, char player) {
        // checks all rows
        for(int x = 0; x < 3; x++) {
            if ((board[x][1] == board[x][0]) && (board[x][1] == board[x][2]) && board[x][0] == player) {
                return true;
            }
        }

        // checks all columns
        for(int y = 0; y < 3; y++) {
            if( (board[1][y]==board[0][y]) && (board[1][y]==board[2][y]) && board[1][y] == player ) {
                return true;
            }
        }

        // checks both diagonals
        if( (board[1][1] == board[0][0]) && (board[1][1]==board[2][2]) && (board[1][1] == player) ||
                (board[1][1]==board[0][2]) && (board[1][1]==board[2][0]) && (board[1][1] == player) ) {
            return true;
        }

        return false;
    }

}
