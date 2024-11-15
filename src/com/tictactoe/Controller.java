package com.tictactoe;

import com.tictactoe.boards.Board;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.security.SecureRandom;

public class Controller {
    Player p1 = new Player();
    Player p2 = new Player();
    static Scanner input = new Scanner(System.in);
    private final char X = 'X';
    private final char O = 'O';
    int choice, mode;
    public static enum boardState {X_WON, O_WON, DRAW, PLAYING, NOT_PLAYED};

    public Controller(int mode) {
        setupPlayers(mode);
    }

    public Controller() {
        setupPlayers(0);
    }

    public void setupPlayers(int mode) {

        if(mode == 2) {
            SecureRandom randomizer = new SecureRandom();
            System.out.print("PLAYER NAME: ");
            int player = randomizer.nextInt(2) + 1;
            if(player % 2 == 0) {
                this.p1.setName(input.next());
                this.p1.setEntry(X);
                this.p2.setName("AI");
                this.p2.setEntry(O);
            } else {
                this.p1.setName("AI");
                this.p1.setEntry(X);
                this.p2.setName(input.next());
                this.p2.setEntry(O);
            }
        }

        System.out.print("PLAYER 1 (X) NAME: ");
        this.p1.setName(input.next());
        this.p1.setEntry(X);

        System.out.print("PLAYER 2 (O)NAME: ");
        this.p2.setName(input.next());
        this.p2.setEntry(O);
    }

    public void startGame(Board currentBoard) {

        currentBoard.setState(boardState.PLAYING);
        while(currentBoard.getState() == boardState.PLAYING) {
            int turn = 1;
            while(turn <= 9) {
                Player currentPlayer = (turn % 2 == 1) ? this.p1 : this.p2;
                if(turn == 1) {
                    currentBoard.render();
                }
                getInput(currentPlayer.getEntry(), currentBoard.board);
                currentBoard.render();
                if (turn >= 5 && checkWin(currentBoard.board)) {
                    System.out.println("The winner is " + currentPlayer.getName() + "!!");
                    currentBoard.setState((currentPlayer.getEntry() == X)? boardState.X_WON : boardState.O_WON);
                    return;
                } else if (turn == 9) {
                    System.out.println("The currentBoard ended in a draw!!");
                    currentBoard.setState(boardState.DRAW);
                    return;
                }
                turn++;
            }
        }
    }

    public void startGame(Board currentBoard, String opponent) {
        // IMPLEMENT MINIMAX ALGO FOR AI OPPONENT
    }

    public void getInput(char value, char[] board) {
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter your choice of index (1 - 9) : ");
            try {
                this.choice = input.nextInt();

                if (!inputIsValid(choice, board)) {
                    System.out.println("Error : Invalid Input! Please enter a valid input between (1 - 9)!!");
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

    public boolean inputIsValid (int choice, char[] board) {
        if(choice > 9 || choice < 1) {
            System.out.println("The number is more than 9 or less than 1");
            return false;
        }
        if(board[choice - 1] == X || board[choice - 1] == O) {
            System.out.println("That box is already filled!");
            return false;
        }
        return true;
    }

    public boolean checkWin (char[] board) {
        int i = 0;
        while(i < 7) {
            if((board[i] == X || board[i] == O) && board[i] == board[i+1] && board[i] == board[i+2]) {
                return true;
            }
            i += 3;
        }

        i = 0;
        while(i < 3) {
            if((board[i] == X || board[i] == O) && board[i] == board[i+3] && board[i] == board[i+6]) {
                return true;
            }
            i++;
        }

        if ((board[2] == X || board[2] == O) && board[2] == board[4] && board[2] == board[6]) {
            return true;
        }

        if ((board[0] == X || board[0] == O) && board[0] == board[4] && board[0] == board[8]) {
            return true;
        }

        return false;
    }
}

