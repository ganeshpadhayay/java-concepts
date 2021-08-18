package com.example.ganesh.DSA;

public class Add1ToLinkedList {

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(6);
        addOne(head);
        printList(head);
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
        }
        System.out.println();
    }

    // This function mainly uses addWithCarry().
    static Node addOne(Node head) {

        // Add 1 to linked list from end to beginning
        int carry = addWithCarry(head);

        // If there is carry after processing all nodes,
        // then we need to add a new node to linked list
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode; // New node becomes head now
        }

        return head;
    }


    // Recursively add 1 from end to beginning and returns
    // carry after all nodes are processed.
    static int addWithCarry(Node head) {

        // If linked list is empty, then
        // return carry
        if (head == null)
            return 1;

        // Add carry returned be next node call
        int res = head.data + addWithCarry(head.next);

        // Update data and return new carry
        head.data = (res) % 10;
        return (res) / 10;
    }

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }
}
