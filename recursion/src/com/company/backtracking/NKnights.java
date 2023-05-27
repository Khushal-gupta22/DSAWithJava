package com.company.backtracking;

import java.util.SortedMap;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(knightCount(board, 0, 0, 4));
    }

    static void knight(boolean[][] board, int row, int col, int knights) {
        if ( knights == 0 ) {
            display(board);
            System.out.println();
            return;
        }

        if ( row == board.length-1 && col== board.length) {
            return;
        }

        if (col == board.length) {
            knight(board, row+1, 0, knights);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col+1, knights-1);
            board[row][col] = false;
        }

        knight(board, row, col+1, knights);
    }

    static int knightCount(boolean[][] board, int row, int col, int knights) {
        if ( knights == 0 ) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;

        if ( row == board.length-1 && col== board.length) {
            return count;
        }

        if (col == board.length) {
            count+= knightCount(board, row+1, 0, knights);
            return count;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += knightCount(board, row, col+1, knights-1);
            board[row][col] = false;
        }

        count += knightCount(board, row, col+1, knights);
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col -1 )) {
            if (board[row - 2][col - 1]) { // whether knight is already available there or not
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1 )) {
            if (board[row - 2 ][col + 1]) { // whether knight is already available there or not
                return false;
            }
        }

        if (isValid(board, row -1, col -2 )) {
            if (board[row -1][col -2]) { // whether knight is already available there or not
                return false;
            }
        }

        if (isValid(board, row +1, col -2 )) {
            if (board[row +1][col -2]) { // whether knight is already available there or not
                return false;
            }
        }
        return true;
    }


    // do not repeat yourself, hence created this function
    static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row: board) {
            for (boolean element: row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }


}
