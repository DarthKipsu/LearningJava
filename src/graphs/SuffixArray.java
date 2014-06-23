/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphs;

//import java.util.*;

/**
 * This exercise is about building a solution for Helsinki University
 * spring 2014 entrance examn problem 2.3: creation of suffix array
 * and printing steps to search from it.
 * 
 * http://www.tkt-yhteisvalinta.fi/valintakoe2014/tkt14_tehtava2.pdf
 */
public class SuffixArray {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String string1 = "abbaababbababbab"; // example 3
        String string2 = "aacatcgatagctagaacat"; // actual assignment
        
        printResults(string1);
        printResults(string2);
    }
    
    public static void printResults(String string) {
        Suffix[] suffixArray = createSuffixArray(string);
        
        System.out.println(string + ", length: " + string.length());
        for (int i=0; i<string.length(); i++) {
            System.out.print(suffixArray[i].get() + " ");
            System.out.println(suffixArray[i].sIndex());
        }
        System.out.println("");
    }
    
    public static Suffix[] createSuffixArray(String string) {
        Suffix[] suffix = new Suffix[string.length()];
        for (int i=0; i<string.length(); i++) {
            suffix[i] = new Suffix(string.substring(i), i + 1);
        }
        //Suffix[] reordered = alphabeticalOrder(suffix);
        return suffix;
    }
    
    /*public static Suffix[] alphabeticalOrder(Suffix[] original) {
        SuffixNode node = new SuffixNode(original[0]);        
        for (int i=1; i<original.length; i++) {
            addChildNodes(original[i], node);
        }
        
        Suffix[] reordered = new Suffix[original.length];
        return reordered;
    }
    
    public static void addChildNodes(Suffix value, SuffixNode parentNode) {
        if (value.get().compareTo(parentNode.getData().get()) >= 0) {
            if (parentNode.right != null) {
                addChildNodes(value, parentNode.right);
            } else {
                parentNode.right = new SuffixNode(value);
            }
        } else {
            if (parentNode.left != null) {
                addChildNodes(value, parentNode.left);
            } else {
                parentNode.left = new SuffixNode(value);
            }
        }
    }*/
}