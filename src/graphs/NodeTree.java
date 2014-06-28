/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphs;

/**
 * Exercise for making a node tree.
 */
public class NodeTree {
    
    /**
     * This will print out the sum of the trees left-hand side.
     * @param ar tree in array form
     */
    public static void printArray(int[] ar) {
        int sum = ar[0];
        for (int i=1; i<ar.length; i = i * 2 + 1) {
            sum += ar[i];
        }
        System.out.println("Sum from left side is: " + sum);
    }
    
    /**
     * Processes the input array into Node tree.
     * @param ar tree in array form
     * @return Node tree
     */
    public static Node createNode(int[]ar) {
        Node node = new Node(ar[0]);
        node.left = addChildNodes(ar, 1);
        node.right = addChildNodes(ar, 2);
        return node;
    }
    
    /**
     * Adds child Nodes to a parent Node.
     * @param ar tree in array form
     * @param i index in the array
     * @return Child Node
     */
    public static Node addChildNodes(int[] ar, int i) {
        if (i >= ar.length || ar[i] == 0) {
            return null;
        }
        
        Node node = new Node(ar[i]);
        node.left = addChildNodes(ar, i * 2 + 1);
        node.right = addChildNodes(ar, i * 2 + 2);
        return node;
    }
    
    public static void printPostOrder(Node node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node + " ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] ar1 = {2, 7, 5, 2, 6, 0, 9};
        int[] ar2 = {1, 7, 5, 2, 6, 0, 9, 3, 7, 5, 11, 0, 0, 4, 0};
        int[] ar3 = {5, 3, 4, 11, 13, 15, 21, 10, 4, 7, 2, 8, 0, 9, 0};
        int[] ar4 = {1, 2, 3, 4, 5, 6, 7};
        int[] ar5 = {10, 1, 2, 3, 4, 5, 6};
        int[] ar6 = {1, 7, 5, 2, 6, 0, 9, 3, 7, 5, 11, 0, 0, 4, 0};
        printArray(ar1);
        printArray(ar2);
        printArray(ar3);
        printArray(ar4);
        System.out.println("");
        
        Node node1 = createNode(ar4);
        Node node2 = createNode(ar5);
        Node node3 = createNode(ar6);
        
        System.out.println("Post order nodes:");
        printPostOrder(node2);
        System.out.println("");
        printPostOrder(node3);
        System.out.println("");
    }
    
}
