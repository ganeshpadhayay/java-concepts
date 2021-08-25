package com.example.ganesh.DSA.tree;

public class CheckForBalancedBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
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

        System.out.println("tree is balanced binary tree: " + checkForBalancedBinary(root));
        System.out.println("tree is balanced binary tree: " + checkForBalancedBinaryEfficiently(root));
    }

    //TC O(n)
    private static boolean checkForBalancedBinaryEfficiently(Node root) {
        return dfsHeight(root) != -1;
    }

    //returns height if tree is balanced or else returns -1
    private static int dfsHeight(Node root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    //TC O(n^2)
    private static boolean checkForBalancedBinary(Node root) {
        if (root == null) return true;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) return false;

        boolean left = checkForBalancedBinary(root.left);
        boolean right = checkForBalancedBinary(root.right);

        return left && right;
    }

    private static int maxDepth(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
