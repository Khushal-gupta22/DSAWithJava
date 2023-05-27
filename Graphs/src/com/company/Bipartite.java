package com.company;

import java.util.*;

public class Bipartite {
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

    static class Pair  {
        int vertex;
        String pathSoFar;
        int level;

        public Pair(int vertex, String pathSoFar, int level) {
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
            this.level = level;
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

        int[] visited = new int[n];
        Arrays.fill(visited, -1); // fills the whole array with -1 initially
        for ( int v = 0; v < n; v++) {
            if ( visited[v] == -1) {
                boolean isComponentBipartite = checkComponentForBipartiteness(graph, v, visited);
                if ( !isComponentBipartite) {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    public static boolean checkComponentForBipartiteness(ArrayList<Edge>[] graph, int src, int[] visited) {
        Queue<Pair> queue = new ArrayDeque<>();
        // remove , mark *,  work , add *

        queue.add(new Pair(src, src + "", 0));

        while ( queue.size() > 0) {
            Pair rem = queue.remove();

            if (visited[rem.vertex] !=-1) {
                if ( rem.level != visited[rem.vertex]) {
                    return false;
                }

            } else {
                visited[rem.vertex] = rem.level;
            }

            for ( Edge e : graph[rem.vertex]) {
                if ( visited[e.nbr] == -1) {
                    queue.add(new Pair(e.nbr, rem.pathSoFar + e.nbr, rem.level + 1));
                }
            }
        }
        return true;
    }
}
