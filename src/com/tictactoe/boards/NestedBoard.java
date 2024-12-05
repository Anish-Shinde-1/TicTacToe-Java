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
        initialize(this);
    }

    public MiniBoard getMiniBoard(int index) {
        return this.miniBoards.get(index);
    }

    public ArrayList<MiniBoard> getMiniBoards() {
        return this.miniBoards;
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
        ArrayList<MiniBoard> mbPerRow = new ArrayList<>(3);
        int boardNum = 0;
        for (int mainrow = 1; mainrow <= 3; mainrow++) {
            mbPerRow.add(miniBoards.get(boardNum++));
            mbPerRow.add(miniBoards.get(boardNum++));
            mbPerRow.add(miniBoards.get(boardNum++));
            if(mainrow == 1) {
                System.out.print("\t                         █                           █                         \t\n");
            }

            for (int minirow = 1; minirow <= 3; minirow++) {
                for (int i = 0; i < 3; i++) {
                    mbPerRow.get(i).printRow(minirow);
                    if (i < 2) {
                        System.out.print(" █ ");
                    } else {
                        System.out.print("\n");
                    }
                }
                if (minirow < 3) {
                    System.out.print("\t\t----+-----+----\t\t █\t\t----+-----+----\t\t █\t\t----+-----+----\t\t\n");
                }
            }

            if(mainrow < 3) {
                System.out.print("\t                         █                           █                         \t\n");
                System.out.print("\t━━━━━━━━━━━━━━━━━━━━━━━━━█━━━━━━━━━━━━━━━━━━━━━━━━━━━█━━━━━━━━━━━━━━━━━━━━━━━━━\t\n");
                System.out.print("\t                         █                           █                         \t\n");
            }
            else {
                System.out.print("\t                         █                           █                         \t\n");
            }

            mbPerRow.clear();
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
