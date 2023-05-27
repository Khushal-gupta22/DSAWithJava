package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Topological {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = scn.nextInt();
        for (int i = 0; i < edges; i++) {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
        for ( int v = 0 ; v < vtces ; v++) {
            if ( !visited[v]) {
                topologicalSort(graph, v, visited, st);
            }
        }
        while ( st.size() > 0) {
            System.out.println(st.pop());
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {

        visited[src] = true;
        for ( Edge e : graph[src] ) {
            if ( !visited[e.nbr]) {
                topologicalSort(graph, e.nbr, visited, st);
            }
        }
        st.push(src);
    }
}
