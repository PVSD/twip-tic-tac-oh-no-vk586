package com.company;

public class generateGame {

    public char[][] board = new char[3][3];
    private static boolean finished = false;
    String status;
    private int numMoves;

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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == board[i].length - 1) System.out.print(board[i][j]);
                else System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }


    public void makeMove(char[][] board, int row, int column, char player) {
        if (board[row][column] == 0) {
            board[row][column] = player;
            numMoves++;
        } else {
            System.out.println("\nThat slot is occupied!");
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
