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
        Node root = new Node();
        Node current = root;
        String tempNum = "";
        for (int i=0; i<input.length(); i++) {
            switch(input.charAt(i)) {
                case '+':
                    Node sum = new Sum();
                    current.setRight(sum);
                    current = sum;
                    Number number = new Number(new Double(tempNum));
                    current.setLeft(number);
                    tempNum = "";
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
        String input1 = "2+2";
        String input2 = "1+2+3+4+5+6";
        String input3 = "11+22+33+44";
        Parser parser = new Parser();
        
        Node node1 = parser.parse(input1);
        Node node2 = parser.parse(input2);
        Node node3 = parser.parse(input3);
    }
    
}