package com.example.ganesh.DSA.tree;

public class MaxDepth {

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

        System.out.println("max depth of the tree is: " + maxDepth(root));
    }

    //TC O(n), SC O(n) in worst case skewed tree
    private static int maxDepth(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
