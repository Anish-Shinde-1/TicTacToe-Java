# Ultimate TicTacToe

Ultimate TicTacToe is a strategic and enhanced version of the classic TicTacToe game. It features a 3x3 main board where each cell contains a 3x3 nested mini-board. The game introduces exciting gameplay modes, AI opponents, and strategic twists for a more engaging experience.

---
## **Features**

- **Nested Gameplay:** Play on a 3x3 grid where each cell is a mini TicTacToe game.
- **Four Game Modes:**
    1. **Simple Mode:** Standard TicTacToe gameplay with no restrictions.
    2. **Simple vs AI:** Play against an AI opponent using the Minimax algorithm for optimal decision-making.
    3. **Strategic Mode:** Players must play on a mini-board corresponding to the previous player's move on the main board.
    4. **Randomized Mode:** Adds unpredictability by randomly selecting the next mini-board for each player.
- **Interactive Console Interface:** Built with Java to ensure smooth, text-based gameplay.
- **Comprehensive Win Checks:** Automatically determines wins or draws for both mini-boards and the main board.

---

## **How to Run**

### **Prerequisites**
- Java 8 or higher.

### **Setup Steps**
1. Clone this repository:

```bash
   git clone https://github.com/your-username/TicTacToe-Java.git
```

2. Navigate to the project directory:
```bash
   cd tictactoe
```

3.Compile the Java source files:
```bash
   javac src/com/tictactoe/*.java
```

4.Run the game:
```bash
   java com.tictactoe.TicTacToe
```

---

## **Gameplay Instructions**

### **Game Rules**

#### **Simple Board Rules** (Applicable to Modes 1 and 2)
1. The game is played on a standard 3x3 TicTacToe board.
2. Players alternate turns, placing their symbols (X or O) on the board.
3. A player wins by aligning three of their symbols horizontally, vertically, or diagonally.
4. The game ends in a draw if all cells are filled and no player wins.

#### **Nested Board Rules** (Applicable to Modes 3 and 4)
1. The game is played on a 3x3 main board where each cell contains a 3x3 mini-board.
2. Players alternate turns, placing their symbols (X or O) on the mini-boards:
    - **Winning a Mini-Board:** A player captures a mini-board by aligning three of their symbols horizontally, vertically, or diagonally within that board.
    - **Capturing the Main Board:** The main board is updated when a player wins a mini-board. The player takes control of the corresponding cell on the main board.
3. A player wins the game by capturing three cells in a row on the main board (horizontally, vertically, or diagonally).
4. If the main board is completely filled without a winner, the game ends in a draw.

---

### **Game Modes**

#### **Mode 1: Simple**
- Standard gameplay on a single 3x3 board.
- No AI involvement, strictly two-player gameplay.

#### **Mode 2: Simple vs AI**
- Standard gameplay on a single 3x3 board.
- Player 1 competes against an AI opponent. The AI uses the Minimax algorithm to make optimal decisions.

#### **Mode 3: Strategic**
- Players are restricted to playing on a mini-board corresponding to the position of the previous player’s move on the main board.
    - Example: If Player 1 places a mark in position 7 of a mini-board, Player 2 must play on mini-board 7.
- If the corresponding mini-board is already won or drawn, the player can choose any other valid mini-board.

#### **Mode 4: Randomized**
- The mini-board for the next turn is randomly selected after every move.
- Mini-boards that are already completed (won or drawn) are excluded from the randomization pool.

---
