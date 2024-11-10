package com.tictactoe;

/*
    1  |  2  |  3
   ----+-----+----
    4  |  5  |  6
   ----+-----+----
    7  |  8  |  9
*/

public class MiniBoard {
    private char[] state = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void printRow(int row) {
        int i;
        switch(row){
            case 1 : i = 0; break;
            case 2 : i = 3; break;
            case 3 : i = 6; break;
            default:
                System.out.println("ERROR : Invalid Row PROVIDED!");
                return;
        }
        System.out.printf("\t\t %c  |  %c  |  %c\t\t", this.state[i], this.state[i+1], this.state[i+2]);
    }

    public void updateMiniBoard(int index, char entry) {
        this.state[index-1] = entry;
    }

//    public static void main(String[] args) {
//        MiniBoard mb1 = new MiniBoard();
//        mb1.printRow(1);
//    }
}


