package com.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

class Controller {
    Board board = new Board();
    Player p1 = new Player();
    Player p2 = new Player();

    public Controller () {
        System.out.println("=== WELCOME TO THE GAME OF TIC TAC TOE ====\n");
        System.out.print("PLAYER 1 NAME : ");
        this.p1.setName(input.next());
        this.p1.setEntry('X');
        System.out.print("PLAYER 2 NAME : ");
        this.p2.setName(input.next());
        this.p2.setEntry('O');
    }

    static Scanner input = new Scanner(System.in);
    static char[] entries = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int choice;

    public void startGame() {
        int turn = 1;
        while(turn <= 9) {
            Player currentPlayer = (turn % 2 == 1) ? this.p1 : this.p2;
            if(turn == 1) {
                Board.render(entries);
            }
            getInput(currentPlayer.getEntry());
            Board.render(entries);
            if (turn >= 5 && checkWin()) {
                System.out.println("The winner is " + currentPlayer.getName() + "!!");
                return;
            } else if (turn == 9) {
                System.out.println("The game ended in a draw!!");
                return;
            }
            turn++;
        }
    }

    public void getInput(char value) {
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter your choice of index : ");
            try {
                this.choice = input.nextInt();

                if (!inputIsValid(choice)) {
                    System.out.println("Error : Invalid Input! Please enter a valid input!!");
                } else{
                    entries[choice - 1] = value;
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
        if(entries[choice - 1] == 'X' || entries[choice - 1] == 'O') {
            System.out.println("That box is already filled!");
            return false;
        }
        return true;
    }

    public boolean checkWin () {
        int i = 0;
        while(i < 7) {
            if(entries [i] == entries[i+1] && entries [i] == entries[i+2] && (entries[i] == 'X' || entries[i] == 'O')) {
                return true;
            }
            i += 3;
        }
        i = 0;
        while(i < 3) {
            if(entries [i] == entries[i+3] && entries [i] == entries[i+6] && (entries[i] == 'X' || entries[i] == 'O')) {
                return true;
            }
            i++;
        }

        if ((entries[2] == 'X' || entries[2] == 'O') && entries[2] == entries[4] && entries[2] == entries[6]) {
            return true;
        }

        if ((entries[0] == 'X' || entries[0] == 'O') && entries[0] == entries[4] && entries[0] == entries[8]) {
            return true;
        }

        return false;
    }
}