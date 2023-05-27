package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirst {
    public static class Edge {
        int vertex;
        int nbr;

        public Edge(int vertex, int nbr) {
            this.vertex = vertex;
            this.nbr = nbr;
        }
    }

    static class Pair  {
        int vertex;
        String pathSoFar;

        public Pair(int vertex, String pathSoFar) {
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
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

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + ""));
        boolean[] visited = new boolean[n];

        while (queue.size() > 0) {
            // r m* w a*
            Pair rem = queue.remove();

            if (visited[rem.vertex]) {
                continue;
            }
            visited[rem.vertex] = true;

            System.out.println(rem.vertex + "@" + rem.pathSoFar);

            for( Edge e : graph[rem.vertex]) {
                if (!visited[rem.vertex]) {
                    queue.add(new Pair(e.nbr, rem.pathSoFar + e.nbr));
                }
            }

        }

        /// is graph cyclic question

        visited = new boolean[n];
        for ( int v = 0; v < n ; v++) {
            if (!visited[v]) {
                boolean cycle = isCycle(graph, src, visited);
                if (cycle) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
    public  static boolean isCycle(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + ""));

        while ( queue.size() > 0) {
            Pair rem = queue.remove();

            if ( visited[rem.vertex]) {
                return true;
            }
            visited[rem.vertex] = true;

            for ( Edge e : graph[rem.vertex]) {
                if ( !visited[e.nbr]) {
                    queue.add(new Pair(e.nbr, rem.pathSoFar + e.nbr)) ;
                }
            }
        }
        return false;
    }


}
