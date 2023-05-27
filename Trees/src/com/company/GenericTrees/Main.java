package com.company.GenericTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node () {

        }
        Node(int data) {
            this.data = data;
        }
    }

    // d(10) => 10 will print itself and it's family
    // d(20), d(30), d(40) will print themselves and their families
    // d(10 ) = s(10) + d(20) + d(30) + d(40)
    public static void display(Node node) {
        String str = node.data + " -> ";
        for ( Node child: node.children) {
            str += child.data + " , ";

        }
        str += ".";
        System.out.println(str);

        for ( Node child : node.children) {
            display(child);
        }
    }
    public static int sizeOfTree(Node node) {
        if (node == null) {
            return 0;
        }

        int size = 1;
        for (Node child : node.children) {
            size += sizeOfTree(child);
        }
        return size;
    }
    public static int max(Node node) {
        int max = Integer.MIN_VALUE;
        for ( Node child : node.children) {
            int childMax = max(child);
            max = Math.max(childMax, max);
        }
        max = Math.max(node.data, max);
        return max;
    }

    public static int height(Node node) {
        int ht = -1; // because edges
        for ( Node child: node.children) {
            int childHt = height(child);
            ht = Math.max(childHt, ht);
        }
        ht = ht+1;

        return ht;
    }

    public static void traversals( Node node) {
        // area 1 euler's left, while on the way deep in the recursion, node's pre area
        System.out.println("Node pre " + node.data);
        for (Node child: node.children) {
            //edge pre
            System.out.println("Edge pre " + node.data + " -- " + child.data);
            traversals(child);
            // edge post
            System.out.println("Edge post " + node.data + " -- " + child.data);

        }
        System.out.println("Node post " + node.data);
        // area 2 euler's right, on the way out of the recursion node's post area
    }

    public static void levelOrderTraversal(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while ( queue.size() > 0) {
            node = queue.remove();
            System.out.print(node.data + " ");

            for ( Node child : node.children) {
                queue.add(child);
            }
        }

        System.out.print(".");
    }

    public static void levelOrderTraversalLineWise(Node node) {
        Queue<Node> mainQ = new ArrayDeque<>();
        mainQ.add(node);

        Queue<Node> childQ = new ArrayDeque<>();
        while ( mainQ.size() > 0) {
            node = mainQ.remove();
            System.out.print(node.data + " ");

            for ( Node child : node.children) {
                childQ.add(child);
            }

            if ( mainQ.size() == 0) {
                mainQ = childQ;
                childQ = new ArrayDeque<>();
                System.out.println();
            }
        }

        System.out.print(".");
    }

    public static void levelOrderZigzag(Node node) {
        Stack<Node> mainS = new Stack<>();
        mainS.push(node);

        Stack<Node> childS = new Stack<>();
        int level = 1;
        while (! mainS.isEmpty()) {
            node = mainS.pop();
            System.out.print(node.data + " ");

            if ( level % 2 == 1 ) {
                for (int i = 0; i < node.children.size(); i++) {
                    Node child = node.children.get(i);
                    childS.push(child);
                }

            } else {
                for (int i = node.children.size() - 1; i >= 0 ; i--) {
                    Node child = node.children.get(i);
                    childS.push(child);
                }
            }
            if ( mainS.size() ==0 ) {
                mainS = childS;
                childS = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void levelOrderLineWise2 ( Node node ) {
        Queue<Node> mainQ = new ArrayDeque<>();
        mainQ.add(node);
        mainQ.add(new Node(-1));

        while ( mainQ.size() > 0) {
            node = mainQ.remove();
            if ( node.data != -1) {
                System.out.print(node.data + " ");

                for ( Node child: node.children) {
                    mainQ.add(child);
                }
            } else {
                if (mainQ.size() > 0) {
                    mainQ.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }

    public static void levelOrderLineWise3 ( Node node) {
        Queue < Node> mainQ = new ArrayDeque<>();
        mainQ.add(node);

        while (mainQ.size() > 0) {
            int childrenInCurrentLevel = mainQ.size();
            for (int i = 0; i < childrenInCurrentLevel; i++) {
                node = mainQ.remove();
                System.out.print(node.data + " ");

                for (Node child: node.children) {
                    mainQ.add(child);
                }
            }
            System.out.println();
        }
    }


    private static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level= level;
        }
    }
    public static void levelOrderLineWise4 ( Node node) {
        Queue <Pair> mainQ = new ArrayDeque<>();
        mainQ.add(new Pair(node, 1));

        int level = 1;
        while (mainQ.size() > 0) {
            Pair pair = mainQ.remove();
            if ( pair.level > level) {
                level = pair.level;
                System.out.println();
            }

            System.out.print(pair.node.data + " ");
            for ( Node child: node.children) {
                Pair childPair = new Pair(child, level + 1 );
                mainQ.add(childPair);
            }
        }
    }

    public static void removeLeaves(Node node) {
//      for(int i = 0; i < node.children.size(); i++) // when you're removing element from an arraylist you
            // never run the loop from fwd direction as the elements shift towards right side when the element from a
            // particular index is removed so run the loop from back always
        for( int i = node.children.size() - 1; i >= 0 ; i--) {
            Node child = node.children.get(i);
            if ( child.children.size() == 0 ) {
                node.children.remove(child);
            }
        }

        for ( Node child: node.children) {
            removeLeaves(child);
        }
    }

    public static boolean find(Node node, int data) {
        if ( node.data == data ) {
            return true;
        }

        for ( Node child: node.children) {
            boolean findInChild = find(child, data);
            if (findInChild) return true;
        }
        return false;
    }

    public static ArrayList <Integer> nodeToRootPath(Node node, int data) {
        if ( node.data == data ) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
        }
        for ( Node child: node.children) {
            ArrayList<Integer> pathTillChild = nodeToRootPath(child, data);
            if (pathTillChild.size() > 0) {
                pathTillChild.add(node.data);
                return pathTillChild;
            }
        }
        return new ArrayList<>();
    }

    static class Pairs {
        Node node;
        int state;

        Pairs(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void IterativePreAndPostOrder ( Node node) {
        Stack < Pairs> st = new Stack<>();
        st.push(new Pairs(node, -1));

        String pre = "";
        String post = "";
        while ( st.size() > 0) {
            Pairs top = st.peek();
            if ( top.state == -1) {
                pre += top.node.data + " ";
                top.state ++ ;
            } else if ( top.state == top.node.children.size()) {
                post += top.node.data + " " ;
                st.pop();
            } else {
                Pairs childPair = new Pairs(top.node.children.get(top.state), -1);
                st.push(childPair);

                top.state++;
            }
        }
        System.out.println(pre);
        System.out.println(post);
    }



    public static Node construct(int[] arr) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if ( arr[i] == -1) {
                st.pop();
            } else {
                Node temp = new Node();
                temp.data = arr[i];

                if ( st.size() > 0 ) {
                    st.peek().children.add(temp);
                } else {
                    root = temp;
                }
                st.push(temp);

            }
        }
        return root;
    }



    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1,
                120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };


        Node root = construct(arr);
        display(root);
        // do acc to euler tree , write -1 whenever you come to left of any element in tree..


    }


}








