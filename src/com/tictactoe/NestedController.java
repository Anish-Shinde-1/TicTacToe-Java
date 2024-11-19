package com.tictactoe;

import com.tictactoe.boards.Board;
import com.tictactoe.boards.MiniBoard;
import com.tictactoe.boards.NestedBoard;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class NestedController extends Controller {

    public void startFreeWillGame(NestedBoard currentNestedBoard){
        // implement logic hehe
    }

    public void startStrategicGame(NestedBoard currentNestedBoard){
        // implement logic hehe
    }

    public void startRandomizedGame(NestedBoard currentNestedBoard){
        // implement logic hehe
    }

    public void getInput(char value, MiniBoard currentBoard) {

    }

    public boolean checkNestedWin(ArrayList<MiniBoard> miniBoards) {
        int i = 0;
        while(i < 7) {
            if (miniBoards.get(i).getState() == miniBoards.get(i+1).getState() &&
                    miniBoards.get(i).getState() == miniBoards.get(i+2).getState()) {
                return true;
            }
            i += 3;
        }

        i = 0;
        while(i < 3) {
            if (miniBoards.get(i).getState() == miniBoards.get(i+3).getState() &&
                    miniBoards.get(i).getState() == miniBoards.get(i+6).getState()) {
                return true;
            }
            i++;
        }

        if (miniBoards.get(2).getState() == miniBoards.get(4).getState() &&
                miniBoards.get(2).getState() == miniBoards.get(6).getState()) {
            return true;
        }

        if (miniBoards.get(0).getState() == miniBoards.get(4).getState() &&
                miniBoards.get(0).getState() == miniBoards.get(8).getState()) {
            return true;
        }
        return false;
    }
}
