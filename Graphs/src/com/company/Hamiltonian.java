package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Hamiltonian {
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

        int src = scn.nextInt();
        HashSet<Integer> visited = new HashSet<>();
        hamiltonian(graph, src, visited, src + "", src);
    }

    public static void hamiltonian(ArrayList<Edge>[] graph, int src,
                                   HashSet<Integer> visited, String pathSoFar, int originalSrc) {

        if ( visited.size() == graph.length - 1) {
            System.out.println(pathSoFar);

            boolean closingEdgeFound = false;
            for(Edge e : graph[src]) {
                if ( e.nbr == src) {
                    closingEdgeFound = true;
                    break;
                }
            }
            if ( closingEdgeFound == true) {
                System.out.println("*");
            } else {
                System.out.println(".");
            }
            return ;
        }

        visited.add(src);
        for ( Edge e : graph[src]) {
            if ( visited.contains(e.nbr) == false) {
                hamiltonian(graph, e.nbr, visited, pathSoFar + e.nbr, originalSrc);
            }
        }
        visited.remove(src);
    }
}
