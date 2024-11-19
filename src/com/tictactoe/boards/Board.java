package com.tictactoe.boards;

import com.tictactoe.Controller;

public class Board extends Controller implements BaseBoard{
    public char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    boardState state;

    public Board (){
        this.state = boardState.NOT_PLAYED;
    }

    public void setState(boardState state){
        this.state = state;
    }

    public boardState getState() {
        return state;
    }

    public void updateBoard(int index, char entry) {
        this.board[index-1] = entry;
    }

    public void render () {
        System.out.printf("\n\n======== TIC TAC TOE ========\n\n");
        System.out.printf("         |         |         \n");
        System.out.printf("    %c    |    %c    |    %c    \n", this.board[0], this.board[1],this.board[2]);
        System.out.printf("         |         |         \n");
        System.out.printf("---------+---------+---------\n");
        System.out.printf("         |         |         \n");
        System.out.printf("    %c    |    %c    |    %c    \n",this.board[3],this.board[4],this.board[5]);
        System.out.printf("         |         |         \n");
        System.out.printf("---------+---------+---------\n");
        System.out.printf("         |         |         \n");
        System.out.printf("    %c    |    %c    |    %c    \n",this.board[6],this.board[7],this.board[8]);
        System.out.printf("         |         |         \n\n");
    }
}

/*
                 |         |
            1    |    2    |    3
                 |         |
        ---------+---------+---------
                 |         |
            4    |    5    |    6
                 |         |
        ---------+---------+---------
                 |         |
            7    |    8    |    9
                 |         |

*/