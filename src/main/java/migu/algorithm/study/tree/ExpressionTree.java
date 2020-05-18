package migu.algorithm.study.tree;

import migu.algorithm.study.data.BiTreeCharDataNode;
import migu.algorithm.study.util.ExpConverter;

import java.util.Stack;

public class ExpressionTree {
    ExpConverter expConverter;
    BinaryTreeCharDataImpl binaryTree;

    public ExpressionTree() {
        super();
        expConverter = new ExpConverter();
        binaryTree = new BinaryTreeCharDataImpl();
    }

    BiTreeCharDataNode makeExpTree(String exp)
    {
        String postfixExp = expConverter.infixToPostfix(exp);
        Stack<BiTreeCharDataNode> stack = new Stack<>();

        for(int i=0;i<postfixExp.length();i++)
        {
            char token = postfixExp.charAt(i);
            BiTreeCharDataNode newNode = new BiTreeCharDataNode();

            if(expConverter.isDigit(token))
            {
                newNode.setData(token);
                stack.push(newNode);
            }
            else
            {
                switch (token)
                {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        newNode.setData(token);
                        newNode.setRight(stack.pop());
                        newNode.setLeft(stack.pop());
                        break;
                    default:
                        System.out.println("Unknown token: "+token);
                }
            }


        }

        return null;

    }

    int evaluateExpTree(BiTreeCharDataNode main)
    {
        return 0;
    }
    public void showPrefixExp(BiTreeCharDataNode main)
    {

    }
    public void showInfixExp(BiTreeCharDataNode main)
    {}
    public void showPostfixExp(BiTreeCharDataNode main)
    {}

    public static void main(String[] args) {

    }
}
