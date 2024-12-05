package com.tictactoe.boards;

import com.tictactoe.Controller;

import java.util.ArrayList;

public interface BaseBoard {
    void setState(Controller.boardState state);
    Controller.boardState getState();
    void updateBoard(int index, char entry);
    void render();
}
