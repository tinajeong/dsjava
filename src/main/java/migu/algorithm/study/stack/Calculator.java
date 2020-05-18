package migu.algorithm.study.stack;

import migu.algorithm.study.util.ExpConverter;

import java.util.Stack;

public class Calculator {

    public String infixExp;
    String postfixExp;
    ExpConverter notationConverter;

    public Calculator() {
        notationConverter = new ExpConverter();
    }

    public Calculator(String infixExp) {
        this();
        this.infixExp = infixExp;
        postfixExp = notationConverter.infixToPostfix(infixExp);
    }

    public int calculateInfix() {
        if (this.infixExp == null) {
            System.out.println("There's no infix expression to calculate");
            return Integer.MIN_VALUE;
        }
        if (this.postfixExp == null) {
            this.postfixExp = notationConverter.infixToPostfix(this.infixExp);
        }

        Stack<Integer> integerStack = new Stack<>();

        for (int i = 0; i < this.postfixExp.length(); i++) {
            char token = this.postfixExp.charAt(i);
            if (notationConverter.isDigit(token)) {
                integerStack.push(Character.getNumericValue(token));
            } else {
                switch (token) {
                    case '+':
                        integerStack.push(integerStack.pop() + integerStack.pop());
                        break;
                    case '-':
                        integerStack.push(integerStack.pop() - integerStack.pop());
                        break;
                    case '*':
                        integerStack.push(integerStack.pop() * integerStack.pop());
                        break;
                    case '/':
                        integerStack.push(integerStack.pop() / integerStack.pop());
                        break;
                    default:
                        System.out.println(token + "is not valid operator");
                }
            }
        }
        return integerStack.pop();
    }

    public int calculateInfix(String infixExp) {
        String postfixExp = notationConverter.infixToPostfix(infixExp);
        Stack<Integer> integerStack = new Stack<>();

        for (int i = 0; i < postfixExp.length(); i++) {
            char token = postfixExp.charAt(i);
            if (notationConverter.isDigit(token)) {
                integerStack.push(Character.getNumericValue(token));
            } else {
                int op1,op2;
                switch (token) {
                    case '+':
                        op1 = integerStack.pop();
                        op2 = integerStack.pop();
                        integerStack.push(op1+op2);
                        break;
                    case '-':
                        op1 = integerStack.pop();
                        op2 = integerStack.pop();
                        integerStack.push(op2-op1);
                        break;
                    case '*':
                        op1 = integerStack.pop();
                        op2 = integerStack.pop();
                        integerStack.push(op1*op2);
                        break;
                    case '/':
                        op1 = integerStack.pop();
                        op2 = integerStack.pop();
                        integerStack.push(op1/op2);
                        break;
                    default:
                        System.out.println(token + "is not valid operator");
                }
            }
        }
        return integerStack.pop();
    }

    public String getInfixExp() {
        return infixExp;
    }

    public void setInfixExp(String infixExp) {
        this.infixExp = infixExp;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator("(1+2*4)*3");
        System.out.println(calculator.calculateInfix());
        System.out.println(calculator.calculateInfix("(1+6*4-2*2)*3"));
    }
}
