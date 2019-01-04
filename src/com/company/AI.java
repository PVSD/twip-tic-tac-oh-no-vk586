package com.company;

public class AI {

    private int row = 1;
    private int column = 1;
    private char cplay = 'O';
    private char hplay = 'X';

    public AI(char [][] board, boolean fMove) {
        if (fMove) {
            returnPlace(randomCorner());
        }
    }

    public void AITurn(char [][] board) {
        while(occupied(board, row, column)) {
            returnPlace((int)(Math.random() * 9 + 1));
        }
        // cplay has the ai check if it can make a win; hplay has the ai check if it needs to block the player
        checkWin(board, cplay);
        checkWin(board, hplay);
        if (!occupied(board, 1, 1)) { row = 1; column = 1; }
    }

    public int returnRow() {
        return row;
    }

    public int returnColumn() {
        return column;
    }

    private void checkWin(char [][] board, char play) {
        for (int x = 0; x < 3; x++) {
            // checks rows
            if (board[x][0] == board[x][1] && board[x][0] == play && !occupied(board, x, 2)) {
                row = x;
                column = 2;
            }
            if (board[x][0] == board[x][2] && board[x][0] == play && !occupied(board, x, 1)) {
                row = x;
                column = 1;
            }
            if (board[x][1] == board[x][2] && board[x][1] == play && !occupied(board, x, 0)) {
                row = x;
                column = 0;
            }

            // checks columns
            if (board[0][x] == board[1][x] && board[0][x] == play && !occupied(board, 2, x)) {
                row = 2;
                column = x;
            }
            if (board[0][x] == board[2][x] && board[0][x] == play && !occupied(board, 1, x)) {
                row = 1;
                column = x;
            }
            if (board[1][x] == board[2][x] && board[0][x] == play && !occupied(board, 0, x)) {
                row = 0;
                column = x;
            }

            // checks diagonals, ew
            if (board[0][0] == board[1][1] && board[0][0] == play && !occupied(board, 2, 2)) {
                row = 2;
                column = 2;
            }
            if (board[0][0] == board[2][2] && board[0][0] == play && !occupied(board, 1, 1)) {
                row = 1;
                column = 1;
            }
            if (board[1][1] == board[2][2] && board[1][1] == play && !occupied(board, 0, 0)) {
                row = 0;
                column = 0;
            }

            if (board[0][2] == board[1][1] && board[0][0] == play && !occupied(board, 2, 0)) {
                row = 2;
                column = 0;
            }
            if (board[0][2] == board[2][2] && board[0][2] == play && !occupied(board, 0, 0)) {
                row = 0;
                column = 0;
            }
            if (board[1][1] == board[2][0] && board[1][1] == play && !occupied(board, 0, 2)) {
                row = 0;
                column = 2;
            }
        }

    }

    // Easier method of selecting the row and column for the computer. important for selecting random places
    private void returnPlace(int index) {
        if (index == 1 ) {
            row = 0;
            column = 0;
        }
        if (index == 2 ) {
            row = 0;
            column = 1;
        }
        if (index == 3 ) {
            row = 0;
            column = 2;
        }

        if (index == 4 ) {
            row = 1;
            column = 0;
        }
        if (index == 5 ) {
            row = 1;
            column = 1;
        }
        if (index == 6 ) {
            row = 1;
            column = 2;
        }

        if (index == 7 ) {
            row = 2;
            column = 0;
        }
        if (index == 8 ) {
            row = 2;
            column = 1;
        }
        if (index == 9 ) {
            row = 2;
            column = 2;
        }
    }

    private boolean occupied(char [][] board, int row, int column) {
        return (board[row][column] == hplay || board[row][column] == cplay);
    }

    private int randomCorner() {
        boolean done = false;
        int rd = 1;
        while (!done) {
            rd = (int)(Math.random() * 9 + 1);
            if (rd == 1 || rd == 3 || rd == 7 || rd == 9) done = true;
        }
        return rd;
    }

}
