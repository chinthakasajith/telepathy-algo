package org.example;

public class Node {
    char value;
    Node right;
    Node left;

    Node(char value) {
        this.value = value;
    }

    Node(char value, Node right, Node left) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
