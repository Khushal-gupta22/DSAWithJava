package com.company;

import java.util.Scanner;
import com.company.Main;

public class Islands {
    public static void main(String[] args) {
        // count number of islands
        // given a 2d array where 0 is land and 1 is water

        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ( arr[i][j] ==0 && visited[i][j] == false) {
                    drawTreeForComponent(arr, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void drawTreeForComponent(int[][] arr, int i, int j, boolean[][] visited) {
        if ( i < 0 || j < 0 || i > arr.length || j>= arr[0].length || arr[i][j] == 1 ||  visited[i][j] == true ) {
            return;
        }

        visited[i][j] = true;

        drawTreeForComponent(arr, i-1, j, visited); // north
        drawTreeForComponent(arr, i, j+1, visited); // east
        drawTreeForComponent(arr, i, j-1, visited); // west
        drawTreeForComponent(arr, i+1, j, visited); // south
    }
}
