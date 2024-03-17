package Maze_solver;

import java.util.Scanner;

@SuppressWarnings("unused")
class Maze_Solver {
    private char[][] maze;
    private int playerRow;
    private int playerCol;

    public Maze_Solver(char[][] maze, int playerRow, int playerCol) {
        this.maze = maze;
        this.playerRow = playerRow;
        this.playerCol = playerCol;
    }

    public boolean isValidMove(int newRow, int newCol) {
        return newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length &&
                maze[newRow][newCol] != '#';
    }

    public boolean isExit(int row, int col) {
        return maze[row][col] == 'E';
    }

    public void movePlayer(int newRow, int newCol) {
        maze[playerRow][playerCol] = '.';
        playerRow = newRow;
        playerCol = newCol;
        maze[playerRow][playerCol] = 'P';
    }

    public void printMaze() {
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerCol() {
        return playerCol;
    }
}

class Player {
    private Maze_Solver maze;

    public Player(Maze_Solver maze) {
        this.maze = maze;
    }

    public void movePlayer(char direction) {
        int newRow = maze.getPlayerRow();
        int newCol = maze.getPlayerCol();

        switch (direction) {
            case 'W':
                newRow--;
                break;
            case 'S':
                newRow++;
                break;
            case 'A':
                newCol--;
                break;
            case 'D':
                newCol++;
                break;
            default:
                System.out.println("Invalid input!");
                return;
        }

        if (maze.isValidMove(newRow, newCol)) {
            maze.movePlayer(newRow, newCol);
            maze.printMaze();
        } else {
            System.out.println("Invalid move!");
        }

        if (maze.isExit(newRow, newCol)) {
            System.out.println("Congratulations! You've reached the exit.");
            System.exit(0);
        }
    }
}

