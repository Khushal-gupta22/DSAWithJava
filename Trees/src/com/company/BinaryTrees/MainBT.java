package com.company.BinaryTrees;

import java.util.Stack;

import static com.company.BinaryTrees.operations.*;
import static com.company.BinaryTrees.traversals.*;

public class MainBT {
    public static class Node {
        public int data;
        public Node left;
        public Node right;

        Node (int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }


//    public static void Traversal(Node node) {
//        if (node == null) {
//            return;
//        }
//        System.out.println(node.data + " in preorder"); // euler left -> pre
//        Traversal(node.left);
//        Traversal(node.right);
//
//
//        Traversal(node.left);
//        System.out.println(node.data + " in inorder"); // euler between -> in
//        Traversal(node.right);
//
//
//        Traversal(node.left);
//        Traversal(node.right);
//        System.out.println(node.data + " in postorder"); // euler right -> post
//    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);

        Pair rootPair = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rootPair);

        int index = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if ( top.state == 1) {
                index++;
                if (arr[index] != null) {
//                    Node leftNode = new Node(arr[index], null, null);
//                    top.node.left = leftNode;
//                    Pair left = new Pair(leftNode, 1);
//                    OR CAN WRITE
                    top.node.left = new Node(arr[index], null, null);
                    Pair leftPair = new Pair(top.node.left, 1);
                    st.push(leftPair);

                } else {
                    top.node.left = null;
                }
                top.state++;

            } else if (top.state ==2) {
                index++;
                if (arr[index] != null) {
                    top.node.right = new Node(arr[index], null, null);
                    Pair rightPair = new Pair(top.node.right, 1);
                    st.push(rightPair);
                } else {
                    top.node.right = null;
                }
                top.state++;

            } else {
                st.pop();
            }
        }
        return root;
    }

    public static void display( Node node) {
        String str = "";

        str += node.left == null ? "." : node.left.data + "" ;
        str += " <- " + node.data + " " + " => ";
        str += node.right == null ? "." : node.right.data + "";

        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62,
                null, 70, null, null, 87, null, null };
        Node root = construct(arr);
        display(root);
        System.out.println(max(root));
        System.out.println(height(root));
        System.out.println(sum(root));
        System.out.println();
        traversalPreorder(root);
        traversalInorder(root);
        traversalPostorder(root);

        System.out.println(find(root, 75));
        System.out.println(path);

        levelOrderTraversal(root);

    }
}
