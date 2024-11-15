package com.tictactoe;

import com.tictactoe.boards.MiniBoard;
import com.tictactoe.boards.NestedBoard;

import java.util.ArrayList;

public class NestedController extends Controller{

    public void startGame(NestedBoard nestedTictactoe){
        // implement logic hehe
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
