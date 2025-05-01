package cs3345.maze;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the dimensions of the maze n x m\nn = ");
        int n = scan.nextInt();
        System.out.print("m = ");
        int m = scan.nextInt();
        Maze maze = new Maze(n, m);
        System.out.println(maze.toString());
        System.out.println(maze.getPath());
    }
}
