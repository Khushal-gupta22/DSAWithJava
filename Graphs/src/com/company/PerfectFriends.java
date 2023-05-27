package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PerfectFriends {
    public static class Edge {
        int vertex;
        int nbr;

        public Edge(int vertex, int nbr) {
            this.vertex = vertex;
            this.nbr = nbr;
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

        for ( int edge = 0 ; edge < k; edge ++) {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();

            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        for ( int v = 0 ; v < n; v++) {
            if (!visited[v]) {
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndGenerateComponent(graph,v, comp, visited);
                components.add(comp);
            }
        }
        int pairs = 0;

        for (int i = 0; i < components.size(); i++) {
            for (int j = i+1; j < components.size() ; j++) {
                int count = components.get(i).size() * components.get(j).size();
                pairs += count;
            }
        }
        System.out.println(pairs);

    }

    public static void drawTreeAndGenerateComponent(ArrayList<Edge>[] graph, int src,
                                                     ArrayList<Integer> comp, boolean[] visited) {
        visited[src] = true;
        comp.add(src);
        for ( Edge e : graph[src]) {
            if ( !visited[e.nbr]) {
                drawTreeAndGenerateComponent(graph, e.nbr, comp, visited);
            }
        }
    }
}
