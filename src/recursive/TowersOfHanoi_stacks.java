/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursive;

import java.util.*;

/**
 * This program will solve the towers of Hanoi with N amount of pegs as a
 * starting value.
 */
public class TowersOfHanoi_stacks {

    public static void createPegs(int nPegs) {
        ArrayList<Stack<Integer>> pegs = new ArrayList();
        for (int i = 0; i < 3; i++) {
            pegs.add(new Stack());
        }
        for (int i = 0; i < nPegs; i++) {
            pegs.get(0).push(nPegs - i);
        }
        System.out.println(nPegs + " pegs: " + pegs);
        
        movePegs(pegs, nPegs, 0, 2);
        
        //makeMove(pegs, nPegs, nPegs);
        System.out.println("");
        System.out.println(nPegs + " pegs moved: " + pegs);
        System.out.println("");
    }
    
    public static void movePegs(List<Stack<Integer>> pegs, int nPegs, int start, int goal) {
        if (nPegs==1) {
            System.out.print(pegs.get(start).lastElement() + "->" + (goal + 1) + " ");
            int move = pegs.get(start).pop();
            pegs.get(goal).push(move);
        } else {
            int temp = 3 - start - goal;
            //ystem.out.println("temp " + temp);
            movePegs(pegs, nPegs-1, start, temp);
            System.out.print(pegs.get(start).lastElement() + "->" + (goal + 1) + " ");
            int move = pegs.get(start).pop();
            pegs.get(goal).push(move);
            movePegs(pegs, nPegs-1, temp, goal);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createPegs(2);
        createPegs(3);
        createPegs(4);
        createPegs(5);
    }

}
