/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphs;

/**
 *
 * @author kipsu
 */
public class SuffixNode {
    
    private Suffix data; // This way I cannot edit this data
    private String suffix;
    SuffixNode left; // Includes two other Node classes
    SuffixNode right;
    
    public SuffixNode(Suffix nodeData) { // This is a constructor
        data = nodeData;
        suffix = nodeData.get();
    }
    
    public Suffix getData() { // But I can still get the data
        return data;
    }
    
}
