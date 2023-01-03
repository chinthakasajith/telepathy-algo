package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Convert the input string into a binary tree.
 *
 */
public class App 
{

    public Node expTree(String s) {
        Deque<Node> nodes = new ArrayDeque<>();    // Stores nodes (new Node(val))
        Deque<Character> ops = new ArrayDeque<>(); // Stores operators and parentheses

        for (final char c : s.toCharArray())
            if (Character.isDigit(c)) {
                nodes.push(new Node(c));
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(')
                    nodes.push(buildNode(ops.pop(), nodes.pop(), nodes.pop()));
                ops.pop(); // Remove '('
            } else {     // C == '+' || c == '-' || c == '*' || c == '/'
                while (!ops.isEmpty() && compare(ops.peek(), c))
                    nodes.push(buildNode(ops.pop(), nodes.pop(), nodes.pop()));
                ops.push(c);
            }

        while (!ops.isEmpty())
            nodes.push(buildNode(ops.pop(), nodes.pop(), nodes.pop()));

        return nodes.peek();
    }

    private Node buildNode(char op, Node right, Node left) {
        return new Node(op, left, right);
    }

    // Returns true if op1 is a operator and priority(op1) >= priority(op2)
    boolean compare(char op1, char op2) {
        if (op1 == '(' || op1 == ')')
            return false;
        return op1 == '*' || op1 == '/' || op2 == '+' || op2 == '-';
    }

    double evaluate(Node node) {
        if (node.left == null && node.right == null) return
                Integer.parseInt(String.valueOf(node.value));
        else {
            char op = node.value;
            double x = evaluate(node.left);
            double y = evaluate(node.right);
            return doMath(x, y, op);
        }
    }

    public double doMath(double first, double second, char op ){

        switch(op){
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
            default:
                return 0;
        }
    }

    public static void main( String[] args )
    {

    }
}
