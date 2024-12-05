package com.tictactoe;

import com.tictactoe.boards.Board;
import com.tictactoe.boards.MiniBoard;
import com.tictactoe.boards.NestedBoard;

import java.util.*;

public class NestedController extends Controller {
    NestedBoard currentNestedBoard;
    public char[] XwinBoard = {'X', ' ', 'X', ' ', 'X', ' ', 'X', ' ', 'X'};
    public char[] OwinBoard = {'O', 'O', 'O', 'O', ' ', 'O', 'O', 'O', 'O'};
    public char[] DrawBoard = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};

    public void initialize(NestedBoard nestedBoard) {
        this.currentNestedBoard = nestedBoard;
    }

    public void startStrategicGame(NestedBoard currentNestedBoard){
        // implement logic hehe
    }

    public void startRandomizedGame() {
        setupPlayers(0);
        int i;
        MiniBoard currentMiniboard;
        currentNestedBoard.setState(boardState.PLAYING);
        List<Integer> boardNumber = new ArrayList<>();
        for (i = 0; i < 9; i++) {
            boardNumber.add(i);
        }
        Collections.shuffle(boardNumber);


        for (i = 1; i <= 9 && currentNestedBoard.getState() == boardState.PLAYING; i++){
            currentMiniboard = currentNestedBoard.getMiniBoard(boardNumber.get(i - 1));
            currentMiniboard.setState(boardState.PLAYING);
            int turn = 1;
            while(currentMiniboard.getState() == boardState.PLAYING) {
                Player currentPlayer = (turn % 2 == 1) ? super.p1 : super.p2;
                if(turn == 1) {
                    currentNestedBoard.render();
                }
                System.out.println("Turn : " + turn);
                getMiniBoardInput(currentPlayer.getEntry(), boardNumber.get(i-1));
                currentNestedBoard.render();

                if (turn >= 5 && checkWin(currentMiniboard.miniBoard)) {
                    System.out.println("The winner of Mini Board " + boardNumber.get(i-1) + " is " + currentPlayer.getName() + "!!");
                    currentMiniboard.setState((currentPlayer.getEntry() == X)? boardState.X_WON : boardState.O_WON);
                    if(currentMiniboard.getState() == boardState.X_WON) {
                        currentMiniboard.miniBoard = XwinBoard;
                    } else if(currentMiniboard.getState() == boardState.O_WON) {
                        currentMiniboard.miniBoard = OwinBoard;
                    }
                } else if (turn == 9) {
                    System.out.println("The currentBoard ended in a draw!!");
                    currentMiniboard.setState(boardState.DRAW);
                    currentMiniboard.miniBoard = DrawBoard;
                }
                turn++;
            }

            if (i >= 5 && checkNestedWin(currentNestedBoard.getMiniBoards()) != boardState.PLAYING) {
                if(currentMiniboard.getState() == boardState.X_WON) {
                    System.out.println("The winner of the Ultimate Board is " + super.p1.getName() + "!!");
                    currentNestedBoard.setState(boardState.X_WON);
                } else if (currentMiniboard.getState() == boardState.O_WON) {
                    System.out.println("The winner is " + super.p2.getName() + "!!");
                    currentNestedBoard.setState(boardState.O_WON);
                }
            } else if (i == 9) {
                System.out.println("The NestedBoard has ended in a draw!!");
                currentNestedBoard.setState(boardState.DRAW);
            }
        }
    }

    public void getMiniBoardInput(char value, int boardNum) {
        boolean validInput = false;
        while (!validInput) {

            System.out.println("Playing on board : " + (boardNum+1));
            System.out.print("Enter your choice of index (1 - 9) : ");
            try {
                this.choice = input.nextInt();

                if (inputIsValid(choice, currentNestedBoard.getMiniBoard(boardNum).miniBoard)) {
                    currentNestedBoard.getMiniBoard(boardNum).updateBoard(choice, value);
                    validInput = true;
                } else {
                    System.out.println("Error : Invalid Input! Please enter a valid input between (1 - 9)!!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error : Invalid Input! Please enter an integer input!!");
                input.next();
            }
        }
    }

    public boardState checkNestedWin(ArrayList<MiniBoard> miniBoards) {
        int i = 0;
        while(i < 7) {
            if (miniBoards.get(i).getState() == miniBoards.get(i+1).getState() &&
                    miniBoards.get(i).getState() == miniBoards.get(i+2).getState() &&
                    (miniBoards.get(i).getState() == boardState.X_WON || miniBoards.get(i).getState() == boardState.O_WON)) {
                return miniBoards.get(i).getState();
            }
            i += 3;
        }

        i = 0;
        while(i < 3) {

            if (miniBoards.get(i).getState() == miniBoards.get(i+3).getState() &&
                    miniBoards.get(i).getState() == miniBoards.get(i+6).getState() &&
                    (miniBoards.get(i).getState() == boardState.X_WON || miniBoards.get(i).getState() == boardState.O_WON)) {
                return miniBoards.get(i).getState();
            }
            i++;
        }

        if (miniBoards.get(2).getState() == miniBoards.get(4).getState() &&
                miniBoards.get(2).getState() == miniBoards.get(6).getState() &&
                (miniBoards.get(2).getState() == boardState.X_WON || miniBoards.get(2).getState() == boardState.O_WON)) {
            return miniBoards.get(2).getState();
        }

        if (miniBoards.get(0).getState() == miniBoards.get(4).getState() &&
                miniBoards.get(0).getState() == miniBoards.get(8).getState() &&
                (miniBoards.get(0).getState() == boardState.X_WON || miniBoards.get(0).getState() == boardState.O_WON)) {
            return miniBoards.get(0).getState();
        }
        return boardState.PLAYING;
    }
}
