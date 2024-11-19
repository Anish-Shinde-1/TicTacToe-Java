package com.tictactoe.boards;

import com.tictactoe.NestedController;

public class MiniBoard extends NestedController implements BaseBoard{
    private char[] miniBoard = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    boardState miniboardState;

    public MiniBoard (){
        this.miniboardState = boardState.NOT_PLAYED;
    }

    @Override
    public void setState(boardState state){
        this.miniboardState = state;
    }

    @Override
    public boardState getState() {
        return this.miniboardState;
    }

    @Override
    public void render() {

    }

    @Override
    public void updateBoard(int index, char entry) {
        this.miniBoard[index-1] = entry;
    }

    public void printRow(int row) {
        int i;
        switch(row){
            case 1 : i = 0; break;
            case 2 : i = 3; break;
            case 3 : i = 6; break;
            default:
                System.out.println("ERROR : Invalid Row Provided!");
                return;
        }
        System.out.printf("\t\t %c  |  %c  |  %c\t\t", this.miniBoard[i], this.miniBoard[i+1], this.miniBoard[i+2]);
    }



//    public static void main(String[] args) {
//        MiniBoard mb1 = new MiniBoard();
//    }
}


/*
    1  |  2  |  3
   ----+-----+----
    4  |  5  |  6
   ----+-----+----
    7  |  8  |  9
*/

