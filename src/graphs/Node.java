/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphs;

/**
 * This is the Node object to be used in binary tree.
 */
public class Node {
    
    private int data; // This way I cannot edit this data
    Node left; // Includes two other Node classes
    Node right;
    
    public Node(int nodeData) { // This is a constructor
        data = nodeData;
    }
    
    public int getData() { // But I can still get the data
        return data;
    }
    
}
