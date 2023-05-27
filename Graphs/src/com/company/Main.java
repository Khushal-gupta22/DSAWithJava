package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
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

    static class Pair implements Comparable<Pair> {
        int wtSoFar ;
        String pathSoFar;

        public Pair(int wtSoFar, String pathSoFar) {
            this.wtSoFar = wtSoFar;
            this.pathSoFar = pathSoFar;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wtSoFar - o.wtSoFar;
        }
    }

    public static boolean hasPath( ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if ( src == dest) {
            return true;
        }
        visited[src] = true;
        for ( Edge edge: graph[src]) {
            if(!visited[edge.nbr]) {
                boolean hasNbrPath = hasPath(graph, edge.nbr, dest, visited);
                if (hasNbrPath) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String pathSoFar) {
        if ( src == dest) {
            System.out.println(pathSoFar);
            return;
        }
        visited[src] = true;
        for ( Edge edge: graph[src]) {
            if (!visited[edge.nbr]) {
                printAllPaths(graph, edge.nbr, dest, visited, pathSoFar + edge.nbr);
            }
        }
        visited[src] = false;
    }

    static String smallestPath;
    static Integer smallestPathWt = Integer.MAX_VALUE;
    static String largestPath;
    static Integer largestPathWt = Integer.MIN_VALUE;
    static String ceilPath;
    static Integer cielPathWt = Integer.MAX_VALUE;
    static String floorPath;
    static Integer floorPathWt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k,
                                   String pathSoFar, int wtSoFar) {
        if ( src == dest) {
            if ( wtSoFar < smallestPathWt) {
                smallestPathWt = wtSoFar;
                smallestPath = pathSoFar;
            }
            if ( wtSoFar > largestPathWt) {
                largestPathWt = wtSoFar;
                largestPath = pathSoFar;
            }
            if ( wtSoFar > criteria && wtSoFar < cielPathWt) {
                cielPathWt = wtSoFar;
                ceilPath = pathSoFar;
            }
            if ( wtSoFar < criteria && wtSoFar > floorPathWt) {
                floorPathWt = wtSoFar;
                floorPath = pathSoFar;
            }
            if ( pq.size() < k) {
                pq.add(new Pair(wtSoFar, pathSoFar));
            } else {
                if ( wtSoFar > pq.peek().wtSoFar) {
                    pq.remove();
                    pq.add(new Pair(wtSoFar, pathSoFar));
                }
            }
            return;
        }

        visited[src] = true;
        for ( Edge e : graph[src]) {
            if (!visited[e.nbr])  {
                multiSolver(graph, e.nbr, dest, visited, criteria, k, pathSoFar + e.nbr, wtSoFar + e.wt);
            }
        }
        visited[src] = false;
    }

    public static void  drawTreeAndGenerateComp(ArrayList<Edge>[] graph, int src,
                                                ArrayList<Integer> comp, boolean[] visited) {
        visited[src] = true;
        comp.add(src);
        for ( Edge e: graph[src]) {
            if ( !visited[e.nbr]) {
                drawTreeAndGenerateComp(graph, e.nbr, comp, visited);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
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
        boolean path = hasPath(graph, 0, 6, visited);
        System.out.println(path);
        printAllPaths(graph, 0, 6, visited ,0 + "" );

//         question // get connected components of graphs
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        for (int v = 0; v < vtces; v++) {
            if (!visited[v]) {
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndGenerateComp(graph, v, comp, visited);
                components.add(comp);
            }
        }
//        public static void  drawTreeAndGenerateComp(ArrayList<Edge>[] graph, int src,
//        ArrayList<Integer> comp, boolean[] visited) {
//            visited[src] = true;
//            comp.add(src);
//            for ( Edge e: graph[src]) {
//                if ( !visited[e.nbr]) {
//                    drawTreeAndGenerateComp(graph, e.nbr, comp, visited);
//                }
//            }
//        }

        System.out.println(components.size() == 1);

        // int vces = 7;
        // how to make a graph ->
//        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[7];
//        for (int i = 0; i < vces; i++) {
//            graph[i] = new ArrayList<Edge>();
//        }
//
//        graph[0].add(new Edge(0, 3, 40));
//        graph[0].add(new Edge(0, 1, 10));
//
//        graph[1].add(new Edge(1, 0, 10));
//        graph[1].add(new Edge(1, 2, 10));
//
//        graph[2].add(new Edge(2, 3, 10));
//        graph[2].add(new Edge(2, 1, 10));
//
//        graph[3].add(new Edge(3, 0, 40));
//        graph[3].add(new Edge(3, 2, 10));
//        graph[3].add(new Edge(3, 4, 2));
//
//        graph[4].add(new Edge(4, 3, 2));
//        graph[4].add(new Edge(4, 5, 3));
//        graph[4].add(new Edge(4, 6, 8));

//        graph[5].add(new Edge(5, 4, 3));
//        graph[5].add(new Edge(5, 6, 3));
//
//        graph[6].add(new Edge(6, 5, 3));
//        graph[6].add(new Edge(6, 4, 8));


    }
}
