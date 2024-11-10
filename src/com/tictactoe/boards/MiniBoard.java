package com.tictactoe.boards;

import com.tictactoe.Controller;

public class MiniBoard extends Controller {
    private char[] miniBoard = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    enum miniBoardState {WON, DREW, LOST, NOT_PLAYED, PLAYING};

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

    public void updateMiniBoard(int index, char entry) {
        this.miniBoard[index-1] = entry;
    }

//    public static void main(String[] args) {
//        MiniBoard mb1 = new MiniBoard();
//        mb1.printRow(1);
//    }
}


/*
    1  |  2  |  3
   ----+-----+----
    4  |  5  |  6
   ----+-----+----
    7  |  8  |  9
*/

