package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class IterativeDFS {
    public static class Edge {
        int vertex;
        int nbr;

        public Edge(int vertex, int nbr) {
            this.vertex = vertex;
            this.nbr = nbr;
        }
    }

    static class Pair {
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

        boolean[] visited = new boolean[n];
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(src, src + ""));

        while (st.size() > 0) {
            Pair rem = st.pop();

            if (visited[rem.vertex]) {
                continue;
            }
            visited[rem.vertex] = true;

            System.out.println(rem.vertex + " @ " + rem.pathSoFar);

            for (Edge e : graph[rem.vertex]) {
                if (!visited[e.nbr]) {
                    st.push(new Pair(e.nbr, rem.pathSoFar + e.nbr));
                }
            }
        }
    }
}
