package com.company.GenericTrees;

import java.util.Iterator;
import java.util.Stack;

public class Tree {

    public static class GenericTree implements Iterable<Integer> {
        Main.Node root;
        GenericTree(Main.Node root) {
            this.root = root;
        }

        @Override
        public Iterator<Integer> iterator() {
            Iterator<Integer> obj = new GTPreorderIterator(root);
            return obj;
        }
    }

    public static class GTPreorderIterator implements Iterator<Integer> {
        Integer nextVal;
        Stack<Pair> st;

        public GTPreorderIterator(Main.Node root) {
            st = new Stack<>();
            st.push(new Pair(root, -1));
            next();
        }

        @Override
        public boolean hasNext() {
            return nextVal != null; // => same as if ( nextVal == null) return false else return true ;
//            if ( nextVal == null ) {
//                return false;
//            }
//            return true;
        }

        @Override
        public Integer next() {
            Integer forReturn = nextVal;

            nextVal = null;
            // moves nextVal forward, if not possible sets it to null
            String preOrder = "";
            String postOrder = "";
            while (st.size() > 0) {
                Pair top = st.peek();
                if (top.state == -1) {
                   nextVal = top.node.data ;
                   top.state ++;
                   break;
                } else if (top.state > 0 && top.state < top.node.children.size()) {
                    Pair childPair = new Pair(top.node.children.get(top.state), -1) ;
                    st.push(childPair);
                    top.state ++;
                } else {
                    postOrder += top.node.data + " ";
                    st.pop();
                }
            }
            return forReturn;
        }
    }

    private static class Pair {
        Main.Node node;
        int state ;

        Pair(Main.Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1,
                120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };

        Main.Node root = Main.construct(arr);
        GenericTree gt = new GenericTree(root);
        for ( int val: gt) { // syntactical sugar dependent upon iterable
            System.out.println(val);
        }

        Iterator<Integer> gti = gt.iterator();
        while ( gti.hasNext() == true) {
            System.out.println(gti.next());
        }
    }
}
