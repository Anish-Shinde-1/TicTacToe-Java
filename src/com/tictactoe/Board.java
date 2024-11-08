package com.tictactoe;

import java.io.IOException;

class Board {
    public static void render (char[] entries) {
        System.out.printf("\n\n======== TIC TAC TOE ========\n\n");
        System.out.printf("         |         |         \n");
        System.out.printf("    %c    |    %c    |    %c    \n", entries[0], entries[1], entries[2]);
        System.out.printf("         |         |         \n");
        System.out.printf("---------+---------+---------\n");
        System.out.printf("         |         |         \n");
        System.out.printf("    %c    |    %c    |    %c    \n", entries[3], entries[4], entries[5]);
        System.out.printf("         |         |         \n");
        System.out.printf("---------+---------+---------\n");
        System.out.printf("         |         |         \n");
        System.out.printf("    %c    |    %c    |    %c    \n", entries[6], entries[7], entries[8]);
        System.out.printf("         |         |         \n\n");
    }
}