package com.example.ganesh.DSA.tree;

public class DFSTraversal {
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

        System.out.println("Preorder Traversal: ");
        printPreorderTraversal(root);

        System.out.println("\nInorder Traversal: ");
        printInorderTraversal(root);

        System.out.println("\nPostorder Traversal: ");
        printPostorderTraversal(root);
    }

    private static void printPostorderTraversal(Node root) {
        if (root == null)
            return;
        printPostorderTraversal(root.left);
        printPostorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    private static void printInorderTraversal(Node root) {
        if (root == null)
            return;
        printInorderTraversal(root.left);
        System.out.print(root.data + " ");
        printInorderTraversal(root.right);
    }

    private static void printPreorderTraversal(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        printPreorderTraversal(root.left);
        printPreorderTraversal(root.right);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
}
