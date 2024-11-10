package com.tictactoe;

import com.tictactoe.boards.Board;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    Player p1 = new Player();
    Player p2 = new Player();
    static Scanner input = new Scanner(System.in);

    public Controller() {
        setupPlayers();
    }

    public void setupPlayers() {
        System.out.println("=== WELCOME TO THE GAME OF TIC TAC TOE ====\n");

        System.out.print("PLAYER 1 (X) NAME: ");
        this.p1.setName(input.next());
        this.p1.setEntry('X');

        System.out.print("PLAYER 2 (O)NAME: ");
        this.p2.setName(input.next());
        this.p2.setEntry('O');
    }

    char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int choice;

    public void startGame() {
        int turn = 1;
        while(turn <= 9) {
            Player currentPlayer = (turn % 2 == 1) ? this.p1 : this.p2;
            if(turn == 1) {
                Board.render(board);
            }
            getInput(currentPlayer.getEntry(), board);
            Board.render(board);
            if (turn >= 5 && checkWin(board)) {
                System.out.println("The winner is " + currentPlayer.getName() + "!!");
                return;
            } else if (turn == 9) {
                System.out.println("The game ended in a draw!!");
                return;
            }
            turn++;
        }
    }

    public void getInput(char value, char[] board) {
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter your choice of index : ");
            try {
                this.choice = input.nextInt();

                if (!inputIsValid(choice)) {
                    System.out.println("Error : Invalid Input! Please enter a valid input!!");
                } else{
                    board[choice - 1] = value;
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error : Invalid Input! Please enter an integer input!!");
                input.next();
            }
        }
    }

    public boolean inputIsValid (int choice) {
        if(choice > 9 || choice < 1) {
            System.out.println("The number is more than 9 or less than 1");
            return false;
        }
        if(board[choice - 1] == 'X' || board[choice - 1] == 'O') {
            System.out.println("That box is already filled!");
            return false;
        }
        return true;
    }

    public boolean checkWin (char[] board) {
        int i = 0;
        while(i < 7) {
            if(board[i] == board[i+1] && board[i] == board[i+2] && (board[i] == 'X' || board[i] == 'O')) {
                return true;
            }
            i += 3;
        }
        i = 0;
        while(i < 3) {
            if(board[i] == board[i+3] && board[i] == board[i+6] && (board[i] == 'X' || board[i] == 'O')) {
                return true;
            }
            i++;
        }

        if ((board[2] == 'X' || board[2] == 'O') && board[2] == board[4] && board[2] == board[6]) {
            return true;
        }

        if ((board[0] == 'X' || board[0] == 'O') && board[0] == board[4] && board[0] == board[8]) {
            return true;
        }

        return false;
    }
}