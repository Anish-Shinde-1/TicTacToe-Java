package com.tictactoe.boards;

public class BoardFactory {
    public static BaseBoard getBoard(String boardType) {
        switch(boardType.toLowerCase()) {
            case "board" :
                return new Board();
            case "miniboard" :
                return new MiniBoard();
            case "nestedboard" :
                return new NestedBoard();
            default:
                throw new IllegalArgumentException("\nUnknown Board Type : " + boardType);
        }
    }
}
