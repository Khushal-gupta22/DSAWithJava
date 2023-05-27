package com.company.backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        //System.out.println(count(3, 3));
        //        System.out.println(count(3, 3));
//        path("", 3, 3);
//        System.out.println(pathRet("", 3, 3));

//        System.out.println(pathRetDiagonal("", 3, 3));

//        boolean[][] board = {
//                {true, true, true},
//                {true, false, true},
//                {true, true, true}
//        };
//
//        pathRestrictions("", board, 0, 0);

        ArrayList<String> ans = getMazePathsWithJumps(1, 1, 3, 4);
        System.out.println(ans);

    }

    static int count(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }

        int left = count(row - 1, col);
        int right = count(row, col - 1);
        return left + right;
    }

    static void path(String processed, int row, int col) {
        if (row == 1 || col == 1) {
            System.out.println(processed);
            return;
        }

        if (row > 1) {
            path(processed + 'D', row - 1, col);
        }

        if (col > 1) {
            path(processed + 'R', row, col - 1);
        }
    }

    static ArrayList<String> pathReturn(String processed, int row, int col) {
        if (row == 1 || col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (row > 1) {
            list.addAll(pathReturn(processed + "D", row - 1, col));
        }

        if (col > 1) {
            list.addAll(pathReturn(processed + "R", row, col - 1));
        }

        return list;
    }

    static ArrayList<String> pathReturnDiagonal(String processed, int row, int col) {
        if (row == 1 || col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (row > 1 && col > 1) {
            list.addAll(pathReturnDiagonal(processed + "D", row - 1, col - 1));
        }

        if (row > 1) {
            list.addAll(pathReturnDiagonal(processed + "V", row - 1, col));
        }

        if (col > 1) {
            list.addAll(pathReturnDiagonal(processed + "H", row, col - 1));
        }

        return list;
    }

    static void pathRestrictions(String processed, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        if (row < maze.length - 1) {
            pathRestrictions(processed + 'D', maze, row + 1, col);
        }

        if (col < maze[0].length - 1) {
            pathRestrictions(processed + 'R', maze, row, col + 1);
        }
    }

    static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> horPaths = new ArrayList<>();
        ArrayList<String> verPaths = new ArrayList<>();

        if (sc < dc) {
            horPaths = getMazePaths(sr, sc + 1, dr, dc);
        }
        if (sr < dr) {
            verPaths = getMazePaths(sr + 1, sc, dr, dc);
            ;
        }

        ArrayList<String> paths = new ArrayList<>();

        for (String path : horPaths) {
            paths.add("h" + horPaths);
        }

        for (String path : verPaths) {
            paths.add("v" + verPaths);
        }

        return paths;
    }

    static ArrayList<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {
//         sr - source row
//         sc - source column
//         dr - destination row
//         dc - destination column

        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if (sr > dr || sc > dc) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }

        ArrayList<String> paths = new ArrayList<>();

        //horizontal moves
        for (int moveSize = 1; moveSize <= dc - sc; moveSize++) {
            ArrayList<String> horPaths = getMazePathsWithJumps(sr, sc + moveSize, dr, dc);
            for (String horPath : horPaths) {
                paths.add("h" + moveSize + horPath);
            }
        }

        //vertical moves
        for (int moveSize = 1; moveSize <= dr - sr; moveSize++) {
            ArrayList<String> verPaths = getMazePathsWithJumps(sr + moveSize, sc, dr, dc);
            for (String verPath : verPaths) {
                paths.add("v" + moveSize + verPath);
            }
        }

        //diagonal moves
        for (int moveSize = 1; moveSize <= (dr- sr) && moveSize <= (dc-sc); moveSize++) {
            ArrayList<String> diagPaths = getMazePathsWithJumps(sr + moveSize, sc + moveSize, dr, dc);
            for (String diagPath : diagPaths) {
                paths.add("d" + moveSize + diagPath);
            }
        }
        return paths;

    }

}