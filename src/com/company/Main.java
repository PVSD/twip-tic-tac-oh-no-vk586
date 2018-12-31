package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.println("Hello user! \n " +
                "Press (1) to play against another player, \n " +
                "(2) to play against a computer, \n " +
                "(3) to play a computer against it self!");
        int option = sc.nextInt();

        int row = 0;
        int column = 0;

        generateGame game = new generateGame();

        // PLAYER VS PLAYER
        if (option == 1) {
            while (true) {
                game.printGame(game.board);
                System.out.println("Player 1, please select your row.");
                row = sc.nextInt();

                System.out.println("Player 1, please select your column.");
                column = sc.nextInt();

                game.makeMove(game.board, row, column, 'X');

                game.printGame(game.board);
                if (game.checkStatus(game.board)) {
                    break;
                }

                System.out.println("Player 2, please select your row.");
                row = sc.nextInt();

                System.out.println("Player 2, please select your column.");
                column = sc.nextInt();

                game.makeMove(game.board, row, column, 'O');
                if (game.checkStatus(game.board)) {
                    break;
                }
            }
        }

        // PLAYER VS COMPUTER
        if (option == 2) {

        }

        // COMPUTER VS COMPUTER
        if (option == 3) {

        }

    }
}
