package com.tictactoe;

import com.tictactoe.boards.Board;
import com.tictactoe.boards.NestedBoard;


import java.util.InputMismatchException;
import java.util.Scanner;

/*

   ██╗   ██╗██╗  ████████╗██╗███╗   ███╗ █████╗ ████████╗███████╗    ████████╗██╗ ██████╗████████╗ █████╗  ██████╗████████╗ ██████╗ ███████╗
   ██║   ██║██║  ╚══██╔══╝██║████╗ ████║██╔══██╗╚══██╔══╝██╔════╝    ╚══██╔══╝██║██╔════╝╚══██╔══╝██╔══██╗██╔════╝╚══██╔══╝██╔═══██╗██╔════╝
   ██║   ██║██║     ██║   ██║██╔████╔██║███████║   ██║   █████╗         ██║   ██║██║        ██║   ███████║██║        ██║   ██║   ██║█████╗
   ██║   ██║██║     ██║   ██║██║╚██╔╝██║██╔══██║   ██║   ██╔══╝         ██║   ██║██║        ██║   ██╔══██║██║        ██║   ██║   ██║██╔══╝
   ╚██████╔╝███████╗██║   ██║██║ ╚═╝ ██║██║  ██║   ██║   ███████╗       ██║   ██║╚██████╗   ██║   ██║  ██║╚██████╗   ██║   ╚██████╔╝███████╗
    ╚═════╝ ╚══════╝╚═╝   ╚═╝╚═╝     ╚═╝╚═╝  ╚═╝   ╚═╝   ╚══════╝       ╚═╝   ╚═╝ ╚═════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝   ╚═╝    ╚═════╝ ╚══════╝
*/
class TicTacToe {
    public static void main(String[] args) {
        Controller controller;
        NestedController nestedController;
        Board board;
        NestedBoard nestedBoard;
        int mode = getMode();

        switch(mode){
            case 1 :
                board = new Board();
                board.startGame(board);
                break;

            case 2 :
                board = new Board();
                board.startGameVsAI(board);
                break;

            case 3 :
                nestedBoard = new NestedBoard();
                nestedBoard.startStrategicGame(nestedBoard);
                break;

            case 4 :
                nestedBoard = new NestedBoard();
                nestedBoard.startRandomizedGame();
                break;
        }
    }

    public static int getMode() {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        displayMenu();
        while(choice < 1 || choice > 4) {
            System.out.print("Enter your mode of choice: ");
            try {
                choice = input.nextInt();
                if(choice < 1 || choice > 4) {
                    System.out.println("ERROR : INVALID INPUT, PLEASE CHOOSE THE CORRECT MODE\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error : Invalid Input! Please enter an integer input!!\n");
                input.next();
            }
        }
        return choice ;
    }

    public static void displayMenu() {
//        System.out.println("\n\n /$$$$$$$$ /$$$$$$  /$$$$$$        /$$$$$$$$ /$$$$$$   /$$$$$$       /$$$$$$$$ /$$$$$$  /$$$$$$$$");
//        System.out.println("|__  $$__/|_  $$_/ /$$__  $$      |__  $$__//$$__  $$ /$$__  $$     |__  $$__//$$__  $$| $$_____/");
//        System.out.println("   | $$     | $$  | $$  \\__/         | $$  | $$  \\ $$| $$  \\__/        | $$  | $$    $$| $$      ");
//        System.out.println("   | $$     | $$  | $$               | $$  | $$$$$$$$| $$              | $$  | $$  | $$| $$$$$   ");
//        System.out.println("   | $$     | $$  | $$               | $$  | $$__  $$| $$              | $$  | $$  | $$| $$__/   ");
//        System.out.println("   | $$     | $$  | $$    $$         | $$  | $$  | $$| $$    $$        | $$  | $$  | $$| $$      ");
//        System.out.println("   | $$    /$$$$$$|  $$$$$$/         | $$  | $$  | $$|  $$$$$$/        | $$  |  $$$$$$/| $$$$$$$$");
//        System.out.println("   |__/   |______/ \\______/          |__/  |__/  |__/ \\______/         |__/   \\______/ |________/\n\n");

        System.out.println("\n\n██╗   ██╗██╗  ████████╗██╗███╗   ███╗ █████╗ ████████╗███████╗    ████████╗██╗ ██████╗████████╗ █████╗  ██████╗████████╗ ██████╗ ███████╗");
        System.out.println("██║   ██║██║  ╚══██╔══╝██║████╗ ████║██╔══██╗╚══██╔══╝██╔════╝    ╚══██╔══╝██║██╔════╝╚══██╔══╝██╔══██╗██╔════╝╚══██╔══╝██╔═══██╗██╔════╝");
        System.out.println("██║   ██║██║     ██║   ██║██╔████╔██║███████║   ██║   █████╗         ██║   ██║██║        ██║   ███████║██║        ██║   ██║   ██║█████╗  ");
        System.out.println("██║   ██║██║     ██║   ██║██║╚██╔╝██║██╔══██║   ██║   ██╔══╝         ██║   ██║██║        ██║   ██╔══██║██║        ██║   ██║   ██║██╔══╝  ");
        System.out.println("╚██████╔╝███████╗██║   ██║██║ ╚═╝ ██║██║  ██║   ██║   ███████╗       ██║   ██║╚██████╗   ██║   ██║  ██║╚██████╗   ██║   ╚██████╔╝███████╗");
        System.out.println(" ╚═════╝ ╚══════╝╚═╝   ╚═╝╚═╝     ╚═╝╚═╝  ╚═╝   ╚═╝   ╚══════╝       ╚═╝   ╚═╝ ╚═════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝   ╚═╝    ╚═════╝ ╚══════╝\n\n");



        System.out.println("Welcome to ULTIMATE TIC-TAC-TOE!");

        System.out.println("\n1. Simple Mode (Human vs Human):");
        System.out.println("Two human players take turns, alternating moves until one wins or it's a draw.");

        System.out.println("\n2. Simple Mode (Human vs AI):");
        System.out.println("One human player vs AI. AI makes calculated moves. The game alternates until one wins or it's a draw.");

        System.out.println("\n3. Nested Mode (Strategic):");
        System.out.println("Players must play on the mini-board corresponding to the position of the last move on the Ultimate board.");

        System.out.println("\n4. Nested Mode (Randomized):");
        System.out.println("A random mini-board is chosen, and players must finish it. Then a new random mini-board is selected. \nThis continues until all mini-boards are completed.");

        System.out.println("\nGeneral Layout & Placement : \n");

        System.out.println("    1  |  2  |  3");
        System.out.println("   ----+-----+----");
        System.out.println("    4  |  5  |  6");
        System.out.println("   ----+-----+----");
        System.out.println("    7  |  8  |  9\n");
    }
}



/*
* So here is how this program will run
* the program starts, and it shows a menu where it gives the option to choose the game mode
* 1. original simple mode
* 2. nested mode where there are three options => free mode, strategy mode and randomized mode
* 3. original mode has the option to play against the AI (minimax) or the human opponent
* 4. nested only allows human opponent for now
*
* original is already is built, I just need to refactor it based on inheritance
*
* nested logic for random is the easiest
* game starts -> then it randomly chooses any miniboard and starts a game there
* then once the game ends there, the state of the board is updated based on who wins and that miniboard is locked
* then a new board is chosen randomly
* this continues until either player wins or all the miniboards are played(draw)
*
*
*
* */