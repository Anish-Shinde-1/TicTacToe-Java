package com.tictactoe.boards;

import com.tictactoe.NestedController;

import java.util.ArrayList;

public class NestedBoard extends NestedController implements BaseBoard {
    ArrayList<MiniBoard> miniBoards = new ArrayList<>();
    boardState nestedBoardState;

    public NestedBoard () {
        for (int i = 0; i < 9; i++) {
            miniBoards.add(new MiniBoard());
        }
    }

    @Override
    public void setState(boardState state) {
        this.nestedBoardState = state;
    }

    @Override
    public boardState getState() {
        return this.nestedBoardState;
    }

    @Override
    public void updateBoard(int index, char entry) {
        miniBoards.get(index - 1).setState((entry == X)? boardState.X_WON : boardState.O_WON);
    }

    @Override
    public void render() {
        for (int mainrow = 1; mainrow <= 3; mainrow++) {

            if(mainrow == 1) {
                System.out.print("\t                         |                           |                         \t\n");
            }

            for (int minirow = 1; minirow <= 3; minirow++) {
                for (int i = 0; i < 3; i++) {
                    miniBoards.get(i).printRow(minirow);
                    if (i < 2) {
                        System.out.print(" | ");
                    } else {
                        System.out.print("\n");
                    }
                }
                if (minirow < 3) {
                    System.out.print("\t\t----+-----+----\t\t |\t\t----+-----+----\t\t |\t\t----+-----+----\t\t\n");
                }
            }

            if(mainrow < 3) {
                System.out.print("\t                         |                           |                         \t\n");
                System.out.print("\t-------------------------+---------------------------+-------------------------\t\n");
                System.out.print("\t                         |                           |                         \t\n");
            }
            else {
                System.out.print("\t                         |                           |                         \t\n");
            }
        }
    }
}

/*
                             |                           |
         1  |  2  |  3       |      1  |  2  |  3        |       1  |  2  |  3
        ----+-----+----      |     ----+-----+----       |      ----+-----+----
         4  |  5  |  6       |      4  |  5  |  6        |       4  |  5  |  6
        ----+-----+----      |     ----+-----+----       |      ----+-----+----
         7  |  8  |  9       |      7  |  8  |  9        |       7  |  8  |  9
                             |                           |
    -------------------------+---------------------------+-------------------------
                             |                           |
         1  |  2  |  3       |      1  |  2  |  3        |       1  |  2  |  3
        ----+-----+----      |     ----+-----+----       |      ----+-----+----
         4  |  5  |  6       |      4  |  5  |  6        |       4  |  5  |  6
        ----+-----+----      |     ----+-----+----       |      ----+-----+----
         7  |  8  |  9       |      7  |  8  |  9        |       7  |  8  |  9
                             |                           |
    -------------------------+---------------------------+-------------------------
         1  |  2  |  3       |      1  |  2  |  3        |       1  |  2  |  3
        ----+-----+----      |     ----+-----+----       |      ----+-----+----
         4  |  5  |  6       |      4  |  5  |  6        |       4  |  5  |  6
        ----+-----+----      |     ----+-----+----       |      ----+-----+----
         7  |  8  |  9       |      7  |  8  |  9        |       7  |  8  |  9
                             |                           |
*/
