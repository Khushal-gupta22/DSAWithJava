package com.company.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {

//        boolean[][] board = {
//                {true, true, true},
//                {true, true, true},
//                {true, true, true}
//        };
//
//        int[][] path = new int[board.length][board[0].length];
//
//        allPathPrint("", board, 0, 0, path, 1);

        ArrayList<String> paths = getStairsPath(4);
        System.out.println(paths);


    }

    static void allPath(String processed, boolean[][] maze, int row, int col) {
        if ( row == maze.length-1 && col == maze[0].length-1 ) {
            System.out.println(processed);
            return;
        }

        if (!maze[row][col]) {
            return;
        }
        //i am  considering this as a block in the path
        maze[row][col] = false;

        if (row  < maze.length-1) {
            allPath(processed + 'D', maze, row+1, col);
        }

        if (col < maze[0].length-1) {
            allPath(processed + 'R', maze, row, col+1);
        }

        if ( row > 0  ) {
            allPath(processed + "U", maze,row-1, col);
        }

        if ( col > 0 ) {
            allPath(processed + "L", maze, row, col-1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function call;
        maze[row][col] = true;
    }

    static void allPathPrint(String processed, boolean[][] maze, int row, int col, int[][] path, int step) {
        if ( row == maze.length-1 && col == maze[0].length-1 ) {
            path[row][col] = step;
//            for (int[] arr: path) {
//                System.out.println(Arrays.toString(arr));
//            }
            System.out.println(Arrays.deepToString(path)
                    .replace("],","\n")
                    .replace(","," ") // fancy method for printing 2D array
                    .replaceAll("[\\[\\]]", " "));

            System.out.println((processed));
            System.out.println();
            return;
        }

        if (!maze[row][col]) {
            return;
        }
        // considering this as a block in the path
        maze[row][col] = false;
        path[row][col] = step;

        if (row  < maze.length-1) {
            allPathPrint(processed + 'D', maze, row+1, col, path, step+1);
        }

        if (col < maze[0].length-1) {
            allPathPrint(processed + 'R', maze, row, col+1, path, step+1);
        }

        if ( row > 0  ) {
            allPathPrint(processed + "U", maze,row-1, col, path, step+1);
        }

        if ( col > 0 ) {
            allPathPrint(processed + "L", maze, row, col-1, path, step+1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function call;
        maze[row][col] = true;
        path[row][col] = 0;
    }


    public static ArrayList<String> getStairsPath ( int n ) {

        if ( n== 0 ) {
            ArrayList<String> bres = new ArrayList<>(); // bres = base result
            bres.add("");
            return bres;
        } else if ( n < 0 ) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }

        ArrayList<String> paths1 = getStairsPath(n-1 ) ;
        ArrayList<String> paths2 = getStairsPath( n-2 );
        ArrayList<String> paths3 = getStairsPath( n-3 );
        ArrayList<String> paths = new ArrayList<>();

        for ( String path : paths1) {
            paths.add(1 + path);
        };
        for ( String path: paths2) {
            paths.add(2 + path) ;
        };
        for ( String path: paths3) {
            paths.add(3 + path);
        };

        return paths;
    }

}


