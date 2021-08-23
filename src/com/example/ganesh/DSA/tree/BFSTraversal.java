package com.example.ganesh.DSA.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
TC O(n), SC O(n)
 */
public class BFSTraversal {

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

               level order traversal will be: 1
                                              2 3
                                              4 5 6
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        List<List<Integer>> levelOrderTraversal = printLevelOrderTraversal(root);
        System.out.println(levelOrderTraversal);
    }

    private static List<List<Integer>> printLevelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> answer = new LinkedList<>();

        //if empty tree, return empty list
        if (root == null) return answer;

        //add root in queue
        queue.add(root);

        //iterate till queue is not empty
        while (!queue.isEmpty()) {
            //get the number of elements in the queue for this iteration
            int levelNumber = queue.size();
            List<Integer> subList = new LinkedList<>();

            //add their left/right in the queue and remove the processing element from queue and add to sub list
            for (int i = 0; i < levelNumber; i++) {
                if (queue.peek() != null) {
                    if (queue.peek().left != null) queue.add(queue.peek().left);
                    if (queue.peek().right != null) queue.add(queue.peek().right);
                    subList.add(queue.poll().data);
                }
            }
            answer.add(subList);
        }
        return answer;
    }
}
