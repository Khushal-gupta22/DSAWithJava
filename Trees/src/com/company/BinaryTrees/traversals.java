package com.company.BinaryTrees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class traversals {
    public static void traversalPreorder(MainBT.Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        traversalPreorder(node.left);
        traversalPreorder(node.right);
    }

    public static void traversalPostorder(MainBT.Node node) {
        if (node == null) {
            return;
        }
        traversalPostorder(node.left);
        traversalPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void traversalInorder(MainBT.Node node) {
        if (node == null) {
            return;
        }
        traversalInorder(node.left);
        System.out.print(node.data + " ");
        traversalInorder(node.right);

    }

    public static void levelOrderTraversal(MainBT.Node node) {
        if (node ==  null) {
            return;
        }
        Queue<MainBT.Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (queue.size() > 0) {
            int count = queue.size(); // kitne bande hain current level mai
            for (int i = 0; i < count; i++) {
                node = queue.remove();
                System.out.print(node.data + " ");

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }

    static void traversalIterative(MainBT.Node node) {
        Stack<MainBT.Pair> st = new Stack<>();
        MainBT.Pair rootPair = new MainBT.Pair(node, 1);
        st.push(rootPair);

        String preOrder = "";
        String inOrder = "";
        String postOrder = "";
        while (st.size() > 0) {
            MainBT.Pair top = st.peek();
            if (top.state == 1) { //pre, state++, left ko jaaye
                preOrder += top.node.data + " " ;
                top.state++;

                if (top.node.left != null) {
                    MainBT.Pair leftPair = new MainBT.Pair(top.node.left, 1);
                    st.push(leftPair);
                }

            } else if (top.state ==2 ) { //in, state++, right ko jaaye
                inOrder += top.node.data + " ";
                top.state ++;

            } else { // post, pop krdein
                postOrder += top.node.data + " ";
                st.pop();
            }
        }

        System.out.println("PreOrder: " + preOrder);
        System.out.println("InOrder: " + inOrder);
        System.out.println("PostOrder: " + postOrder);
    }




}

