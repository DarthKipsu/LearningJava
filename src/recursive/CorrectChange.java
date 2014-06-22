/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursive;
import java.util.Arrays;

/**
 * This will calculate if the array has enough coins to give
 * change to the amount first on the array.
 */
public class CorrectChange {
    
    public static void checkChange(int[] ar) {
        int sum = ar[0];
        int[] coins = new int[ar.length - 1];
        for (int i=0; i<coins.length; i++) {
            coins[i] = ar[1 + i];
        }
        result = false;
        System.out.print("sum: " + sum + ", coins: ");
        System.out.println(Arrays.toString(coins));
        findCombinations(sum, coins, 0, 0);
        System.out.println(result);
    }
    
    public static boolean result;
    
    public static void findCombinations(int sum, int[] coins, int change, int index) {
        if (sum - change == 0) {
            result = true;
        } else if (index == coins.length-1) {
            return;
        } else {
            findCombinations(sum, coins, change, index+1);
            change += coins[index+1];
            //System.out.println(index + " " + change);
            findCombinations(sum, coins, change, index+1);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] ar1 = {12, 1, 2, 3, 4, 5};
        int[] ar2 = {11, 1, 5, 9, 13};
        int[] ar3 = {50, 1, 3, 5, 37, 18, 5};
        int[] ar4 = {201, 37, 42, 10, 23, 15, 25, 11, 6, 19, 25, 51};
        checkChange(ar1);
        checkChange(ar2);
        checkChange(ar3);
        checkChange(ar4);
    }
    
}
