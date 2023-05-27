package com.company.BinaryTrees;

import com.company.BinaryTrees.MainBT.*;

import java.util.ArrayList;

public class operations {

    public static void display(MainBT.Node node) {

        if (node ==null) {
            return;
        }
        //node self work
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(MainBT.Node node) {
        if (node ==null) {
            return 0;
        }
        int leftSize = size(node.left);
        int rightSize = size(node.right);
        int totalSize = leftSize + rightSize + 1;
        return totalSize;
    }

    public static int sum(MainBT.Node node) {
        if (node ==null) {
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        int totalSum = leftSum + rightSum + node.data;
        return totalSum;
    }

    public static int max(MainBT.Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int maxLeft = max(node.left);
        int maxRight = max(node.right);
        int totalMax = Math.max(Math.max(maxLeft, maxRight), node.data);
        return totalMax;
    }

    public static int height (MainBT.Node node) {
        if (node == null) {
            return -1; // -1 for height in edges 0 for height in nodes
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int totalHeight = Math.max(leftHeight, rightHeight) + 1;
        return totalHeight;
    }

    static ArrayList<Node> path = new ArrayList<>();
    public static boolean find(MainBT.Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            path.add(node);
            return true;
        }
        boolean findLeft = find(node.left, data);
        if (findLeft) {
            path.add(node);
            return true;
        }
        boolean findRight = find(node.right, data);
        if (findRight) {
            path.add(node);
            return true;
        }
        return false;
    }

    public static void printKLevelsDown (Node node, int k) {
        if ( node == null || k <0 ) {
            return;
        }

        if (k == 0) {
            System.out.println(node.data);
        }

        printKLevelsDown(node.left, k-1);
        printKLevelsDown(node.right, k-1);
    }

    public static void printSingleChildNodes(MainBT.Node node, Node parent) {
        if (node == null) {
            return;
        }

        if (parent != null && parent.left == null && parent.right == node) {
            System.out.println(node.data);
        } else if (parent != null && parent.right == null && parent.left == node) {
            System.out.println(node.data);
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static MainBT.Node removeLeaves(MainBT.Node node) {

        if(node== null) {
            return null;
        }

        if(node.left == null && node.right == null) {
            return null;
        }


        MainBT.Node newLeftRoot = removeLeaves(node.left);
        MainBT.Node newRightRoot = removeLeaves(node.right);
        node.left = newLeftRoot;
        node.right = newRightRoot;

        //  OR CAN DIRECTLY WRITE
//        node.left = removeLeaves(node.left);
//        node.right  = removeLeaves(node.right);
        return node;
    }


    public static void printKLevelsDownBlocker (Node node, int k, Node blocker) {
        if ( node == null || k <0 ) {
            return;
        }

        if (k == 0) {
            System.out.println(node.data);
        }

        printKLevelsDownBlocker(node.left, k-1, blocker);
        printKLevelsDownBlocker(node.right, k-1, blocker);
    }
    public static void printKNodesFar(Node node, int data, int k) {
        path = new ArrayList<>();//1
        find(node, data);
        for (int i = 0; i < path.size(); i++) { //2
            printKLevelsDownBlocker(path.get(i), k - i, i == 0 ? null : path.get(i - 1)); //3
        }
    }
}
