package com.example.ganesh.DSA.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllDFSTraversalInOneGo {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        Node node;
        int number;

        public Pair(Node node, int number) {
            this.node = node;
            this.number = number;
        }
    }

    public static void main(String[] args) {
        /*
                    1
                 2    3
               4  5    6

               Preorder traversal will be: 1 2 4 5 3 6
               Inorder traversal will be: 4 2 5 1 3 6
               Postorder traversal will be: 4 5 2 6 3 1
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Preorder, Inorder, Postorder Traversals: ");
        printPreInPostOrderTraversal(root);
    }

    private static void printPreInPostOrderTraversal(Node root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        if (root == null) return;

        while (!stack.isEmpty()) {
            //pop the top element from stack and process as per its number value
            Pair it = stack.pop();

            //preorder part, increment 1 to 2 and push the left subtree
            if (it.number == 1) {
                preOrder.add(it.node.data);
                it.number++;
                stack.push(it);
                if (it.node.left != null) {
                    stack.push(new Pair(it.node.left, 1));
                }
            }
            //inorder part, increment 2 to 3 and push the right subtree
            else if (it.number == 2) {
                inOrder.add(it.node.data);
                it.number++;
                stack.push(it);
                if (it.node.right != null) {
                    stack.push(new Pair(it.node.right, 1));
                }
            }
            //postorder part, don't push anything
            else {
                postOrder.add(it.node.data);
            }
        }

        System.out.println("Preorder traversal: ");
        System.out.println(preOrder);
        System.out.println("\nInorder traversal: ");
        System.out.println(inOrder);
        System.out.println("\nPostorder traversal: ");
        System.out.println(postOrder);
    }
}
