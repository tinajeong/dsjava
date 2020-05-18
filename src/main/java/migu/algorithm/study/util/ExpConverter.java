package migu.algorithm.study.util;

import java.util.Stack;

public class ExpConverter {

    public String infixToPostfix(String seq) {
        String result = "";
        Stack<Character> stackTray = new Stack<>();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < seq.length(); i++) {
            Character token = seq.charAt(i);
            if (isDigit(token)) {
                str.append(token);
                System.out.println("[ "+str+" ]");
            } else {
                switch (token) {
                    case '(':
                        stackTray.push(token);
                        break;
                    case ')':
                        if ((!stackTray.isEmpty())) {
                            while (stackTray.peek() != '(') {
                                str.append(stackTray.pop());
                            }
                            stackTray.pop();
                        }
                        break;
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        while ((!stackTray.isEmpty()) && compare(stackTray.peek(),token) > -1) {
                            str.append(stackTray.pop());
                        }
                        stackTray.push(token);
                        break;
                }

                System.out.print("[ "+str+" ]" +"\tstack:");
                printStack(stackTray);
            }
        }
        while (!stackTray.isEmpty()) {
            str.append(stackTray.pop());
        }
        System.out.print("[ "+str+" ]");
        printStack(stackTray);
        result = str.toString();
        return result;
    }
    public boolean isDigit(char c) {
        try {
            Integer.parseInt(String.valueOf(c));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    int getOpPrecedence(Character op) {
        switch (op) {
            case '*':
            case '/':
                return 3;
            case '+':
            case '-':
                return 2;
            case '(':
                return 1;
            default:
                return -1;
        }
    }

    int compare(Character op1, Character op2) {
        int op1Prec = getOpPrecedence(op1);
        int op2Prec = getOpPrecedence(op2);
        if (op1Prec > op2Prec)
            return 1;
        else if (op1Prec < op2Prec)
            return -1;
        else
            return 0;
    }

    void printStack(Stack stack)
    {
        for(int i=0;i<stack.size();i++) {
            System.out.print(stack.get(i)+" ");
        }
        System.out.println();
    }
}
