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
        Node root = new Sum();
        Node current = root;
        Node tempNode = null;
        String tempNum = "";
        for (int i=0; i<input.length(); i++) {
            Number number;
            switch(input.charAt(i)) {
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
                    if (i==0) {
                        tempNum += input.charAt(i);
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
                case '(':
                    String parentheses = "";
                    int j = i+1;
                    while (input.charAt(j)!=')') {
                        parentheses += input.charAt(j);
                        j += 1;
                    }
                    tempNode = parse(parentheses);
                    i = j;
                    break;
                case ',':
                    tempNum += '.';
                    break;
                case ' ':
                    break;
                default:
                    tempNum += input.charAt(i);
            }
        }
        Number number = new Number(new Double(tempNum));
        current.setRight(number);
        
        return root.getRight();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input1 = "1 + 2";
        String input2 = "1+(2-1)+5";
        Parser parser = new Parser();
        
        Node node1 = parser.parse(input1);
        Node node2 = parser.parse(input2);
        System.out.println(input1 + " = " + node1.getValue());
        System.out.println(input2 + " = " + node2.getValue());
    }
    
}