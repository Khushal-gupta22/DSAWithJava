package com.company.BinarySearchTree;

import com.company.BinarySearchTree.MainBST.*;

import java.util.ArrayList;
import java.util.Stack;

public class operations {
    public static int size(Node node) {
        if (node ==null) {
            return 0;
        }
        int leftSize = size(node.left);
        int rightSize = size(node.right);
        int totalSize = leftSize + rightSize + 1;
        return totalSize;
    }

    public static int sum(Node node) {
        if (node ==null) {
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        int totalSum = leftSum + rightSum + node.data;
        return totalSum;
    }

    public static void display(Node node) {
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

    public static int max(MainBST.Node node) {
        if (node.right != null) {
            return max(node.right);
        } else {
            return node.data;
        }
    }

    public static int min(Node node) {
        if (node.left != null) {
            return min(node.left);
        } else {
            return node.data;
        }
    }

    public static boolean find(Node node, int data)  {
        if (node == null) {
            return false;
        }
        if (node.data == data){
            return true;
        } else if (data > node.data) {
            find(node.right, data);
        } else if (data < node.data) {
            find(node.left, data);
        }
        return false;
    }

    public static Node add(Node node, int data) {
        if (node == null ) {
            return new MainBST.Node(data, null, null);
        }

        if (data > node.data) {
            node.right = add(node.right, data);
        } else if (data < node.data) {
            node.left = add(node.left, data);
        } else {
            // nothing to do;
        }
        return node;
    }

    public static Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data > node.data) {
            node.right = remove(node.right, data);
        } else if (data < node.data) {
            node.left = remove(node.left, data);
        } else {
            //work
            if (node.left != null && node.right != null) {
                int leftMax = max(node.left);
                node.data = leftMax;
                node.left = remove(node.left, leftMax);
                return node;

            } else if (node.left != null ) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }

    public static void targetSumPair(Node root, Node node, int sum) {
        if ( node == null) {
            return;
        }

        targetSumPair(root, node.left, sum);

        int complement = sum - node.data;
        if ( node.data < complement) {
            if (find(root, complement)) {
                System.out.println(node.data + " " + complement);
            }
        }

        targetSumPair(root, node.right, sum);
    }

    public static void targetSumPair2(Node node, ArrayList<Integer> list, int target) {
        if ( node == null) {
            return ;
        }

        targetSumPair2(node.left, list, target);
        list.add(node.data);
        targetSumPair2(node.right, list, target);

        int start = 0;
        int end = list.size() -1 ;

        while ( start < end ) {
            int left = list.get(start);
            int right = list.get(end);
            if ( left + right < target) {
                start ++;
            } else if ( left + right > target) {
                end--;
            } else if ( left + right == target) {
                System.out.println(list.get(start) + " " + list.get(end));
                start ++;
                end --;
            }
        }

    }

    public static class iterativeTraversalPair {
        Node node;
        int state = 0;

        iterativeTraversalPair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void targetSumPair3(Node node, int target) {
        Stack<iterativeTraversalPair> leftStack = new Stack<>();
        Stack<iterativeTraversalPair> rightStack = new Stack<>();
        leftStack.push(new iterativeTraversalPair(node, 0));
        rightStack.push(new iterativeTraversalPair(node, 0));

        Node left = getNextFromNormalInorder(leftStack);
        Node right = getNextFromReverseInorder(rightStack);
        while ( left.data < right.data) {
            if ( left.data + right.data < target) {
                left = getNextFromNormalInorder(leftStack);
            } else if ( left.data + right.data > target) {
                right = getNextFromReverseInorder(rightStack);
            } else {
                System.out.println(left.data + " " +  right.data);
                left = getNextFromNormalInorder(leftStack);
                right = getNextFromReverseInorder(rightStack);
            }
        }
    }

    public static Node getNextFromNormalInorder(Stack<iterativeTraversalPair> st) {
        while ( st.size() > 0) {
            iterativeTraversalPair top = st.peek();
            if ( top.state == 0 ) {
                if ( top.node.left != null) {
                    st.push(new iterativeTraversalPair(top.node.left, 0));
                    top.state++;
                }
            } else if ( top.state == 1) {
                if ( top.node.right != null) {
                    st.push(new iterativeTraversalPair(top.node.right, 0));
                    top.state++;
                    return top.node;
                }
            } else if ( top.state == 2) {
                st.pop();
            }
        }
        return null;
    } // gives in increasing order

    public static Node getNextFromReverseInorder(Stack<iterativeTraversalPair> st) {
        while ( st.size() > 0) {
            iterativeTraversalPair top = st.peek();
            if ( top.state == 0 ) {
                if ( top.node.right != null) {
                    st.push(new iterativeTraversalPair(top.node.right, 0));
                    top.state++;
                }
            } else if ( top.state == 1) {
                if ( top.node.left != null) {
                    st.push(new iterativeTraversalPair(top.node.left, 0));
                    top.state++;
                    return top.node;
                }
            } else if ( top.state == 2) {
                st.pop();
            }
        }
        return null;

    } // gives in decreasing order


}
