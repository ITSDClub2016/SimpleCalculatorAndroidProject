package com.saititsdclub.simplecalculator.operators;


/***
 * Operator abstract class used to evaluate postfix
 */
public abstract class Operator {
    private char operator;

    /***
     * Constructor for Operator abstract class
      * @param operator Operator character
     */
    protected Operator(char operator) {
        this.operator = operator;
    }

    /***
     * Evaluates 2 operands using the operator
     * @param a First number
     * @param b Second number
     * @return Answer
     */
    public abstract double evaluate(double a, double b);

    /***
     * Gets the operator
     * @return Operator character
     */
    public char getOperator() {
        return this.operator;
    }

}
