package Maze_solver;

import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        char[][] mazeData = {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '.', '.', '.', '#', '.', '.', '.', '#'},
                {'#', '.', '#', '.', '#', '.', '#', '.', '#'},
                {'#', '.', '#', '.', '.', '.', '#', '.', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };

        Maze_Solver maze = new Maze_Solver(mazeData, 1, 1);
        Player player = new Player(maze);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            maze.printMaze();
            System.out.println("Enter your move (W/A/S/D): ");
            char move = scanner.next().charAt(0);
            player.movePlayer(move);
        }
    }
}
