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
public class BinaryTree {
    
    public static void printLeftSum(int[] ar) {
        int sum = ar[0];
        for (int i=1; i<ar.length; i = i * 2 + 1) {
            sum += ar[i];
        }
        System.out.println(sum);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] ar1 = {2, 7, 5, 2, 6, 0, 9};
        int[] ar2 = {1, 7, 5, 2, 6, 0, 9, 3, 7, 5, 11, 0, 0, 4, 0};
        int[] ar3 = {5, 3, 4, 11, 13, 15, 21, 10, 4, 7, 2, 8, 0, 9, 0};
        int[] ar4 = {1, 2, 3, 4, 5, 6, 7};
        printLeftSum(ar1);
        printLeftSum(ar2);
        printLeftSum(ar3);
        printLeftSum(ar4);
    }
    
}
