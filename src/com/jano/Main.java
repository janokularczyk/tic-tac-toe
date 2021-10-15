package com.jano;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String player1 = "O", player2 = "X";
        String player;
        int clock = 1;
        String[][] grid = new String[5][9];
        Scanner scanner = new Scanner(System.in);

        layoutGrid(grid);

        while (true) {
            if (clock % 2 == 0) {
                player = player1;
            } else {
                player = player2;
            }
            clock++;
            System.out.println("Enter the coordinates: ");
            try {
                String inputX = scanner.next();
                Integer.parseInt(inputX);
                String inputY = scanner.next();
                Integer.parseInt(inputY);
                int x = Integer.parseInt(inputX);
                int y = Integer.parseInt(inputY);
                if (x > 3 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    clock--;
                } else {
                    if (y == 1 && grid[x][y + 1].equals(" ")) {
                        grid[x][y + 1] = player;
                        printGrid(grid);
                    } else if (y == 2 && grid[x][y + 2].equals(" ")) {
                        grid[x][y + 2] = player;
                        printGrid(grid);
                    } else if (y == 3 && grid[x][y + 3].equals(" ")) {
                        grid[x][y + 3] = player;
                        printGrid(grid);
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        clock--;
                    }
                }
                String s = grid[1][2] + grid[1][4] + grid[1][6] + grid[2][2] + grid[2][4] + grid[2][6] + grid[3][2] + grid[3][4] + grid[3][6];
                boolean flagX = checkX(s);
                boolean flagO = checkO(s);
                if (flagX && !flagO) {
                    System.out.println("X wins");
                    break;
                } else if (!flagX && flagO) {
                    System.out.println("O wins");
                    break;
                } else if (!s.contains(" ")) {
                    System.out.println("Draw");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                clock--;
            }
        }
    }

    public static void layoutGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for ( int j = 0; j < grid[i].length; j++) {
                if (i == 0 || i == 4) {
                    grid[i][j] = "-";
                } else if (j == 0 || j == 8) {
                    grid[i][j] = "|";
                } else {
                    grid[i][j] = " ";
                }
            }
        }
        printGrid(grid);
    }

    public static void printGrid(String[][] grid) {
        for (String[] strings : grid) {
            for (String aString : strings) {
                System.out.print(aString);
            }
            System.out.println();
        }
    }

    public static boolean checkX(String s) {
        return s.charAt(0) == 'X' && s.charAt(1) == 'X' && s.charAt(2) == 'X' ||
                s.charAt(3) == 'X' && s.charAt(4) == 'X' && s.charAt(5) == 'X' ||
                s.charAt(6) == 'X' && s.charAt(7) == 'X' && s.charAt(8) == 'X' ||
                s.charAt(0) == 'X' && s.charAt(3) == 'X' && s.charAt(6) == 'X' ||
                s.charAt(1) == 'X' && s.charAt(4) == 'X' && s.charAt(7) == 'X' ||
                s.charAt(2) == 'X' && s.charAt(5) == 'X' && s.charAt(8) == 'X' ||
                s.charAt(0) == 'X' && s.charAt(4) == 'X' && s.charAt(8) == 'X' ||
                s.charAt(2) == 'X' && s.charAt(4) == 'X' && s.charAt(6) == 'X';
    }

    public static boolean checkO(String s) {
        return s.charAt(0) == 'O' && s.charAt(1) == 'O' && s.charAt(2) == 'O' ||
                s.charAt(3) == 'O' && s.charAt(4) == 'O' && s.charAt(5) == 'O' ||
                s.charAt(6) == 'O' && s.charAt(7) == 'O' && s.charAt(8) == 'O' ||
                s.charAt(0) == 'O' && s.charAt(3) == 'O' && s.charAt(6) == 'O' ||
                s.charAt(1) == 'O' && s.charAt(4) == 'O' && s.charAt(7) == 'O' ||
                s.charAt(2) == 'O' && s.charAt(5) == 'O' && s.charAt(8) == 'O' ||
                s.charAt(0) == 'O' && s.charAt(4) == 'O' && s.charAt(8) == 'O' ||
                s.charAt(2) == 'O' && s.charAt(4) == 'O' && s.charAt(6) == 'O';
    }
}
