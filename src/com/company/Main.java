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
                do {
                    System.out.println("Player 1, please select your row.");
                    row = sc.nextInt() - 1;

                    System.out.println("Player 1, please select your column.");
                    column = sc.nextInt() - 1;

                    game.makeMove(game.board, row, column, 'X');
                } while (!generateGame.doneTurn);

                game.printGame(game.board);
                if (game.checkStatus(game.board)) {
                    break;
                }

                do {
                    System.out.println("Player 2, please select your row.");
                    row = sc.nextInt() - 1;

                    System.out.println("Player 2, please select your column.");
                    column = sc.nextInt() - 1;

                    game.makeMove(game.board, row, column, 'O');
                } while (!generateGame.doneTurn);

                game.makeMove(game.board, row, column, 'O');
                if (game.checkStatus(game.board)) {
                    break;
                }
            }
        }

        // PLAYER VS COMPUTER
        if (option == 2) {
            AI ai1;
            int order = (int)(Math.random() * 2 + 1);
            if (order == 1) {
                System.out.println("Human player goes first!");
                ai1 = new AI(game.board, false);

                game.printGame(game.board);
                do {
                    System.out.println("Player 1, please select your row.");
                    row = sc.nextInt() - 1;

                    System.out.println("Player 1, please select your column.");
                    column = sc.nextInt() - 1;

                    game.makeMove(game.board, row, column, 'X');
                } while (!generateGame.doneTurn);

                ai1.AITurn(game.board);
                game.makeMove(game.board, ai1.returnRow(), ai1.returnColumn(), 'O');

                game.printGame(game.board);

                do {
                    System.out.println("Player 1, please select your row.");
                    row = sc.nextInt() - 1;

                    System.out.println("Player 1, please select your column.");
                    column = sc.nextInt() - 1;

                    game.makeMove(game.board, row, column, 'X');
                } while (!generateGame.doneTurn);

            }
            else {
                System.out.println("Computer goes first!");
                ai1 = new AI(game.board, true);
                game.makeMove(game.board, ai1.returnRow(), ai1.returnColumn(), 'O');

                game.printGame(game.board);

                do {
                    System.out.println("Player 1, please select your row.");
                    row = sc.nextInt() - 1;

                    System.out.println("Player 1, please select your column.");
                    column = sc.nextInt() - 1;

                    game.makeMove(game.board, row, column, 'X');
                } while (!generateGame.doneTurn);
            }

            while (true) {
                ai1.AITurn(game.board);
                game.makeMove(game.board, ai1.returnRow(), ai1.returnColumn(), 'O');

                game.printGame(game.board);
                if (game.checkStatus(game.board)) {
                    break;
                }

                do {
                    System.out.println("Player 1, please select your row.");
                    row = sc.nextInt() - 1;

                    System.out.println("Player 1, please select your column.");
                    column = sc.nextInt() - 1;

                    game.makeMove(game.board, row, column, 'X');
                } while (!generateGame.doneTurn);

                game.printGame(game.board);
                if (game.checkStatus(game.board)) {
                    break;
                }
            }
        }

        // COMPUTER VS COMPUTER
        if (option == 3) {

        }

    }
}
