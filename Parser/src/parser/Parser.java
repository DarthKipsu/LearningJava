/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

/**
 *
 * @author kipsu
 */
public class Parser {
    
    public Node parse(String input) {
        index = 0;
        return parse(input, '\0');
    }
    
    private int index;
    
    private Node parse(String input, char endChar) {
        Node root = new Sum();
        Node current = root;
        Node tempNode = null;
        String tempNum = "";
        for (; index<input.length() && input.charAt(index)!=endChar; index++) {
            Number number;
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
                    index += 1;
                    Node multi = new Multi();
                    if (tempNode == null) {
                        number = new Number(new Double(tempNum));
                        multi.setLeft(number);
                        tempNum = "";
                    } else {
                        multi.setLeft(tempNode);
                        tempNode = null;
                    }
                    while (index<input.length()
                        && input.charAt(index)!='*'
                        && input.charAt(index)!='+'
                        && input.charAt(index)!='-') {
                        if (input.charAt(index)!=' ') {
                            tempNum += input.charAt(index);
                        }
                        index += 1;
                    }
                    if (tempNode == null) {
                        number = new Number(new Double(tempNum));
                        multi.setRight(number);
                        tempNum = "";
                    } else {
                        multi.setRight(tempNode);
                        tempNode = null;
                    }
                    tempNode = multi;
                    break;
                case '+':
                    Node sum = new Sum();
                    current.setRight(sum);
                    current = sum;
                    if (tempNode == null) {
                        number = new Number(new Double(tempNum));
                        current.setLeft(number);
                        tempNum = "";
                    } else {
                        current.setLeft(tempNode);
                        tempNode = null;
                    }
                    break;
                case '-':
                    if (index==0) {
                        tempNum += input.charAt(index);
                    } else {
                        Node sub = new Sub();
                        current.setRight(sub);
                        current = sub;
                        if (tempNode == null) {
                            number = new Number(new Double(tempNum));
                            current.setLeft(number);
                            tempNum = "";
                        } else {
                            current.setLeft(tempNode);
                            tempNode = null;
                        }
                    }
                    break;
                default:
                    tempNode = null;
                    tempNum += input.charAt(index);
            }
        }
        if (tempNode == null) {
            Number number = new Number(new Double(tempNum));
            current.setRight(number);
        } else {
            current.setRight(tempNode);
        }
        
        return root.getRight();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input1 = "1 + 2";
        String input2 = "5-(4+(2-1)-1)";
        String input3 = "2*5";
        //String input3 = "2+3*5*4-2*3";
        Parser parser = new Parser();
        
        Node node1 = parser.parse(input1);
        Node node2 = parser.parse(input2);
        Node node3 = parser.parse(input3);
        System.out.println(input1 + " = " + node1.getValue());
        System.out.println(input2 + " = " + node2.getValue());
        System.out.println(input3 + " = " + node3.getValue());
    }
    
}