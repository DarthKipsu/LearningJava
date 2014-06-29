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
        String tempNum = "";
        for (int i=0; i<input.length(); i++) {
            Number number;
            switch(input.charAt(i)) {
                case '+':
                    Node sum = new Sum();
                    current.setRight(sum);
                    current = sum;
                    number = new Number(new Double(tempNum));
                    current.setLeft(number);
                    tempNum = "";
                    break;
                case '-':
                    if (i==0) {
                        tempNum += input.charAt(i);
                    } else {
                        Node sub = new Sub();
                        current.setRight(sub);
                        current = sub;
                        number = new Number(new Double(tempNum));
                        current.setLeft(number);
                        tempNum = "";
                    }
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
        Parser parser = new Parser();
        
        Node node1 = parser.parse(input1);
        System.out.println(input1 + " = " + node1.getValue());
    }
    
}