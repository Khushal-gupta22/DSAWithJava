package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prims {
    public static class Edge {
        int vertex;
        int nbr;
        int wt;


        public Edge(int vertex, int nbr, int wt) {
            this.vertex = vertex;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int acquiringVtx;
        int wt;

        public Pair(int vertex, int acquiringVtx, int wt) {
            this.vertex = vertex;
            this.acquiringVtx = acquiringVtx;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
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
            int wt = scn.nextInt();

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = scn.nextInt();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));
        boolean[] visited = new boolean[n];

        while ( pq.size() > 0) {
            Pair rem = pq.remove();

            if ( visited[rem.vertex]) {
                continue;
            }
            visited[rem.vertex] = true;

            if ( rem.acquiringVtx != -1) {
                System.out.println("[ " + rem.vertex + " - " + rem.acquiringVtx + " @ " + rem.wt + " ]");

            }

            for ( Edge e : graph[rem.vertex]) {
                if ( !visited[e.nbr]) {
                    pq.add(new Pair(e.nbr, rem.vertex, e.wt));
                }
            }
        }

    }
}
