package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class spreadInfection {
    public static class Edge {
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair  {
        int vertex;
        int time;

        public Pair(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // no of vertex
        int k = scn.nextInt(); // no of edges

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int v = 0; v < n; v++) {
            graph[v] = new ArrayList<>(); // sbke saamne khaali arraylist daaldi
        }

        for (int edge = 0; edge < k; edge++) {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();

            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = scn.nextInt();
        int t = scn.nextInt();

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, 1));
        int[] visited = new int[n];
        int count = 0;

        while ( queue.size()> 0) {
            Pair rem = queue.remove();

            if (visited[rem.vertex] > 0) {
                continue;
            }
            visited[rem.vertex] = rem.time;
            if ( rem.time > t) {
                break;
            }
            count++;

            for( Edge e : graph[rem.vertex]) {
                if( visited[e.nbr] == 0) {
                    queue.add(new Pair(e.nbr, rem.time + 1));
                }
            }
        }
        System.out.println(count);
    }
}
