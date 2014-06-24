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
        
        String search1 = "ababbaba";
        String search2 = "cga";
        
        printResults(string1, search1);
        printResults(string2, search2);
    }
    
    public static void printResults(String string, String search) {
        Suffix[] suffixArray = createSuffixArray(string);
        
        System.out.println("t = " + string + ", p = " + search);
        printSuffixArray(suffixArray);
        printSearchWord(suffixArray, search);
        System.out.println("");
    }
    
    public static Suffix[] createSuffixArray(String string) {
        Suffix[] suffix = new Suffix[string.length()];
        for (int i=0; i<string.length(); i++) {
            suffix[i] = new Suffix(string.substring(i), i + 1);
        }
        alphabeticalOrder(suffix);
        for (int i=0; i<suffix.length; i++) {
            suffix[i].setIndex(i + 1);
        }
        return suffix;
    }
    
    public static void alphabeticalOrder(Suffix[] original) {
        for (int i=0; i<original.length - 1; i++) {
            for (int j=i+1; j<original.length; j++) {
                if (original[i].get().compareToIgnoreCase(original[j].get()) > 0) {
                    Suffix temp = original[i];
                    original[i] = original[j];
                    original[j] = temp;
                }
            }
        }
    }
    
    public static void printSuffixArray(Suffix[] suffixArray) {
        System.out.println("Suffix array:");
        for (int i=0; i<suffixArray.length; i++) {
            System.out.print("   " + suffixArray[i].get() + " ");
            System.out.print(suffixArray[i].index() + " ");
            System.out.println(suffixArray[i].sIndex());
        }
    }
    
    public static void printSearchWord(Suffix[] suffixArray, String search) {
        int begin = 1;
        int end = suffixArray.length;
        System.out.println("1. Starting values, begin = " + begin + ", end = " + end + ".");
        binarySearch(suffixArray, search, begin, end, 2);
    }
    
    public static void binarySearch(Suffix[] suffixArray, String search,
                                    int begin, int end, int i) {
        if (begin > end) {
            System.out.println("Search ended, character p could not be found.");
        } else {
            int middle = (int)Math.ceil((begin + end) / 2.0);
            String comparison = suffixArray[middle-1].get();
            if (search.length() < comparison.length()) {
                comparison = comparison.substring(0, search.length());
            }
            System.out.println(i + ". Middle = (" + begin + "+" + end + ")/2 = " + middle + ",");
            if (search.compareTo(comparison) < 0) {
                System.out.println("   p < t[S[" + middle + "].." + end + "], end = middle-1 = " + (middle-1) + ".");
                end = middle - 1;
                binarySearch(suffixArray, search, begin, end, i+1);
            } else if (search.compareTo(comparison) > 0) {
                System.out.println("   p > t[S[" + middle + "].." + end + "], begin = middle+1 = " + (middle+1) + ".");
                begin = middle + 1;
                binarySearch(suffixArray, search, begin, end, i+1);
            } else {
                System.out.println("   p == t[S[" + middle + "].." + end + "], Search ended at " + middle + ".");
            }
        }
    }
}