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
    
    public static Node createNode(String input) {
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
        
        Node node1 = createNode(input1);
    }
    
}