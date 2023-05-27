package com.company.BinarySearchTree;

import static com.company.BinarySearchTree.operations.*;

public class MainBST {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static Node construct(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end-start)/2;

        int data = arr[mid];
        Node leftChild = construct(arr, start, mid-1);
        Node rightChild = construct(arr, mid+1, end);

        Node node = new Node(data, leftChild, rightChild);
        return node;
    }


    public static void main(String[] args) {
        int[] arr = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(arr, 0, arr.length-1);
        display(root);
    }
}

