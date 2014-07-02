/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import java.util.HashMap;

/**
 *
 * @author kipsu
 */
public class Parser {
    
    public Node parse(String input) {
        index = 0;
        tempNode = null;
        tempNum = "";
        return parse(input, '\0');
    }
    
    private int index;
    private Node tempNode;
    private String tempNum;
    
    private Node parse(String input, char endChar) {
        Node root = new Sum();
        Node current = root;
        for (; index<input.length() && input.charAt(index)!=endChar; index++) {
            switch(input.charAt(index)) {
                case ' ':
                case ')':
                    break;
                case ',':
                    tempNum += '.';
                    break;
                case '(':
                    index += 1;
                    tempNode = parse(input, ')');
                    break;
                case '*':
                    Node multi = new Multi();
                    setLeftNode(multi);
                    findRightTemp(input, endChar);
                    setRightNode(multi);
                    tempNode = multi;
                    break;
                case '/':
                    Node div = new Div();
                    setLeftNode(div);
                    findRightTemp(input, endChar);
                    setRightNode(div);
                    tempNode = div;
                    break;
                case '+':
                    Node sum = new Sum();
                    current.setRight(sum);
                    current = sum;
                    setLeftNode(current);
                    break;
                case '-':
                    if (index==0) {
                        tempNum += input.charAt(index);
                    } else {
                        Node sub = new Sub();
                        current.setRight(sub);
                        current = sub;
                        setLeftNode(current);
                    }
                    break;
                default:
                    if (isLetter(input.charAt(index))) {
                        setVariableToTemp(input);
                        break;
                    }
                    tempNode = null;
                    tempNum += input.charAt(index);
            }
        }
        setRightNode(current);
        
        return root.getRight();
    }
    
    private void setLeftNode(Node current) {
        
        if (tempNode == null) {
            Number number = new Number(new Double(tempNum));
            current.setLeft(number);
            tempNum = "";
        } else {
            current.setLeft(tempNode);
            tempNode = null;
        }
        
    }
    
    private void setRightNode(Node current) {
        
        if (tempNode == null) {
            Number number = new Number(new Double(tempNum));
            current.setRight(number);
            tempNum = "";
        } else {
            current.setRight(tempNode);
            tempNode = null;
        }
        
    }
    
    private void findRightTemp(String input, char endChar) {
        
        while (index+1<input.length()
            && input.charAt(index+1)!=endChar
            && input.charAt(index+1)!='*'
            && input.charAt(index+1)!='/'
            && input.charAt(index+1)!='+'
            && input.charAt(index+1)!='-') {
            index += 1;
            if (input.charAt(index)=='(') {
                index += 1;
                tempNode = parse(input, ')');
            } else if (isLetter(input.charAt(index))) {
                Node var = new Var(input.charAt(index));
                tempNode = var;
            } else if (input.charAt(index)!=' ') {
                tempNum += input.charAt(index);
            }
        }
    }
    
    private void setVariableToTemp(String input) {
        Node var = new Var(input.charAt(index));
        if (index!=0 && (isDigit(input.charAt(index-1))
        || isLetter(input.charAt(index-1)))) {
            Multi multi = new Multi();
            setLeftNode(multi);
            tempNode = var;
            setRightNode(multi);
            tempNode = multi;
        } else {
            tempNode = var;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input1 = "1 + 2";
        String input2 = "2+3*(3/4.5*1-5)*(4-2)/3";
        Parser parser = new Parser();
        
        Node node1 = parser.parse(input1);
        Node node2 = parser.parse(input2);
        System.out.println(input1 + " = " + node1.getValue(new HashMap()));
        System.out.println(input2 + " = " + node2.getValue(new HashMap()));
    }
    
}