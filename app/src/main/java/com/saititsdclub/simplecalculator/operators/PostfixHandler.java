package com.saititsdclub.simplecalculator.operators;

import android.os.SystemClock;

import com.saititsdclub.simplecalculator.operators.Operator;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixHandler{
    private Stack<Double> stack;
    private ArrayList<String> postfix;

    /***
     * Constructor for EvaluatePostfix.
     * This constructor populates the operators field
     * @param postfix Postfix expression to evaluate
     */
    public PostfixHandler(ArrayList<String> postfix) {
        stack = new Stack<Double>();
        this.postfix=postfix;
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
        while(!postfix.isEmpty()){

            System.out.print(stack.size());

            if (isNumber(postfix.get(0))){
                stack.add(Double.parseDouble(postfix.remove(0)));
            }else{
                char sign=postfix.remove(0).charAt(0);

                double op1=stack.pop();
                double op2=stack.pop();

                if (sign=='+'){
                    stack.push(op2+op1);
                }else if (sign=='-'){
                    stack.push(op2-op1);
                }else if (sign=='/'){
                    stack.push(op2/op1);
                }else if (sign=='*'){
                    stack.push(op2*op1);
                }
            }
        }

        return stack.peek();
    }

    private boolean isNumber(String string){
        try{
            double test=Double.parseDouble(string);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
