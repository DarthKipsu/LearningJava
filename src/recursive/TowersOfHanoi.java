/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursive;

/**
 * This program will solve the towers of Hanoi with N amount of pegs as a
 * starting value.
 */
public class TowersOfHanoi {
    
    public static void solvePegs(int nPegs) {
        makeAMove(nPegs, 1, 3);
        System.out.println("");
    }
    
    public static void makeAMove(int nPegs, int start, int goal) {
        if (nPegs == 1) {
            System.out.print(nPegs + "->" + goal + " ");
        } else {
            int temp = 6 - start - goal;
            makeAMove(nPegs-1, start, temp);
            System.out.print(nPegs + "->" + goal + " ");
            makeAMove(nPegs-1, temp, goal);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        solvePegs(3);
        solvePegs(4);
        solvePegs(5);
    }
    
}
