package com.saititsdclub.simplecalculator;

import com.saititsdclub.simplecalculator.operators.Operator;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluatePostfix {
    private Stack<Double> stack = new Stack<Double>();
    private ArrayList<Operator> operators = new ArrayList<Operator>();
    private String postfix;

    /***
     * Constructor for EvaluatePostfix.
     * This constructor populates the operators field
     * @param postfix Postfix expression to evaluate
     */
    public EvaluatePostfix(String postfix) {

    }

    /***
     * Evaluates the postfix expression using operators
     *
     * Steps:
     * 1. Get next character in postfix
     * 2. If character is operand, push it to stack and go back to step #1
     * 3. Pop 2 elements from stack (the first popped element is b, the second is a)
     * 4. Get next operator character
     * 5. Using operator field, find Operator object and evaluate a and b
     * 6. Push result of step #5 to stack
     * 7. If more characters, go back to step #1
     * 8. Return popped element from stack
     *
     * @return Result of evaluated postfix
     */
    public double evaluate() {
        return 0;
    }
}
