package com.liuhao.algs4.solutions.ch1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Sol_1_3_9 {
    public static Double calculate(String input) {
        String[] items = input.split("\\s+");
        Stack<String> operatorStack = new Stack<>();
        Stack<Number> numberStack = new Stack<>();
        for (String item : items) {
            switch (item) {
                case "(":
                    continue;
                case "+":
                case "-":
                case "*":
                case "/":
                    operatorStack.push(item);
                    continue;
                case ")":
                    Number right = numberStack.pop();
                    Number left = numberStack.pop();
                    String operator = operatorStack.pop();
                    switch (operator) {
                        case "+":
                            numberStack.push(left.doubleValue() + right.doubleValue());
                            continue;
                        case "-":
                            numberStack.push(left.doubleValue() - right.doubleValue());
                            continue;
                        case "*":
                            numberStack.push(left.doubleValue() * right.doubleValue());
                            continue;
                        case "/":
                            numberStack.push(left.doubleValue() / right.doubleValue());
                            continue;
                        default:
                            throw new IllegalStateException("unknown operator " + operator);
                    }
                default:
                    double number = Double.parseDouble(item);
                    numberStack.push(number);
            }
        }
        return numberStack.pop().doubleValue();
    }

    public static void main(String[] args) {
//        String input = StdIn.readString();
        StdOut.println(calculate("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"));
        String expected = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";
    }
}
