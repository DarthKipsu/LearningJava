/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphs;

import java.util.*;

/**
 *
 * @author kipsu
 */
public class SuffixArray {
    
    public static String[] createSuffixArray(String string) {
        String[] suffix = new String[string.length()];
        for (int i=0; i<string.length(); i++) {
            suffix[i] = string.substring(i);
        }
        return suffix;
    }
    
    public static void printResults(String string) {
        String[] suffixArray = createSuffixArray(string);
        
        System.out.println(string + ", length: " + string.length());
        System.out.println(Arrays.toString(suffixArray));
        System.out.println("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String string1 = "abbaababbababbab";
        String string2 = "aacatcgatagctagaacat";
        
        printResults(string1);
        printResults(string2);
    }
    
}
