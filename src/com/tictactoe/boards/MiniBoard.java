package com.tictactoe.boards;

import com.tictactoe.NestedController;

public class MiniBoard extends NestedController implements BaseBoard{
    public char[] miniBoard = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
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
        System.out.printf("\n\n======== TIC TAC TOE ========\n\n");
        System.out.printf("    %c  |  %c  |  %c \n", this.miniBoard[0], this.miniBoard[1],this.miniBoard[2]);
        System.out.printf("  -----+------+-----\n");
        System.out.printf("    %c  |  %c  |  %c \n",this.miniBoard[3],this.miniBoard[4],this.miniBoard[5]);
        System.out.printf("  -----+------+-----\n");
        System.out.printf("    %c  |  %c  |  %c \n",this.miniBoard[6],this.miniBoard[7],this.miniBoard[8]);
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
//        mb1.render();
//    }
}


/*
    1  |  2  |  3
   ----+-----+----
    4  |  5  |  6
   ----+-----+----
    7  |  8  |  9
*/

