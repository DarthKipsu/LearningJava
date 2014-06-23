/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphs;

/**
 * Binary search tree and printing out the sorted values.
 * @author kipsu
 */
public class BinarySearchTree {
    
    public static Node createNode(int[] ar) {
        Node node = new Node(ar[0]);
        for (int i=1; i<ar.length; i++) {
            addChildNodes(ar[i], node);
        }
        return node;
    }
    
    public static void addChildNodes(int value, Node parentNode) {
        if (value >= parentNode.getData()) {
            if (parentNode.right != null) {
                addChildNodes(value, parentNode.right);
            } else {
                parentNode.right = new Node(value);
            }
        } else {
            if (parentNode.left != null) {
                addChildNodes(value, parentNode.left);
            } else {
                parentNode.left = new Node(value);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] ar1 = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        int[] ar2 = {10, 12, 15, 7, 2, 23, 9, 14, 21};
        
        Node node1 = createNode(ar1);
        Node node2 = createNode(ar2);
        
        System.out.println(node1.left.right.right.getData());
        System.out.println(node1.right.right.left.getData());
        System.out.println(node1.left.left.getData());
    }
    
}
