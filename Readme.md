# TicTacToe Game

A simple two-player TicTacToe game implemented in Java. Players alternate turns to place their marks (X or O) on a 3x3 grid. The game checks for a winner or a draw after every move. This project demonstrates basic game logic, input validation, and object-oriented programming in Java.

## Features

- Two-player gameplay (player 1: X, player 2: O)
- Input validation for valid moves
- Checks for win conditions (horizontal, vertical, and diagonal)
- Ends when there's a winner or the board is full (draw)

## Getting Started

### Prerequisites

- Java 8 or higher

### How to Run

1. Clone this repository:
```bash
   git clone https://github.com/your-username/tictactoe.git
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

## Gameplay

1. **Start the Game:** Enter player names. Player 1 gets X, Player 2 gets O.
2. **Take Turns:** Players take turns to place their symbol on the board by selecting a number between 1 and 9 corresponding to a cell.
3. **Winning the Game:** The first player to align three of their symbols horizontally, vertically, or diagonally wins.
4. **End of Game:** The game ends when a player wins or all cells are filled, resulting in a draw.

