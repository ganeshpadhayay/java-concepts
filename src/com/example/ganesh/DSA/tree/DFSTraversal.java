package com.example.ganesh.DSA.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSTraversal {

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

        System.out.println("Preorder Traversal: ");
        printPreorderTraversal(root);

        System.out.println("\nInorder Traversal: ");
        printInorderTraversal(root);

        System.out.println("\nPostorder Traversal: ");
        printPostorderTraversal(root);

        System.out.println("\nIterative Preorder Traversal: ");
        System.out.println(iterativePreorderTraversal(root));

        System.out.println("\nIterative Inorder Traversal: ");
        System.out.println(iterativeInorderTraversal(root));

        System.out.println("\nIterative Postorder Traversal using 2 stacks: ");
        System.out.println(iterativePostorderTraversalUsing2Stacks(root));

        System.out.println("\nIterative Postorder Traversal using 1 stack: ");
        System.out.println(iterativePostorderTraversalUsing1Stack(root));
    }

    private static List<Integer> iterativePostorderTraversalUsing1Stack(Node root) {
        List<Integer> answer = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if (root == null) return answer;

        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    answer.add(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        answer.add(temp.data);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return answer;
    }

    private static List<Integer> iterativePostorderTraversalUsing2Stacks(Node root) {
        List<Integer> answer = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        if (root == null) return answer;

        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.add(root);
            if (root.left != null) stack1.push(root.left);
            if (root.right != null) stack1.push(root.right);
        }

        while (!stack2.isEmpty()) {
            answer.add(stack2.pop().data);
        }

        return answer;
    }

    private static List<Integer> iterativeInorderTraversal(Node root) {
        List<Integer> answer = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty())
                    break;

                node = stack.pop();
                answer.add(node.data);
                node = node.right;
            }
        }
        return answer;
    }

    private static List<Integer> iterativePreorderTraversal(Node root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;

        //init stack with root
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            //pop root and add to the  list
            root = stack.pop();
            answer.add(root.data);

            //first, check and add the right node
            if (root.right != null) {
                stack.add(root.right);
            }
            //then the left node
            if (root.left != null) {
                stack.add(root.left);

            }
        }
        return answer;
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
}
