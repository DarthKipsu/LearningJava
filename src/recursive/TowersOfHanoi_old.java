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
public class TowersOfHanoi_old {
    
    public static void movePegs(List<Stack<Integer>> pegs, int nPegs, int start, int goal) {
        if (nPegs==1) {
            int temp = 3 - start - goal;
            System.out.print(pegs.get(start).lastElement() + "->" + (goal + 1) + " ");
            int move = pegs.get(start).pop();
            pegs.get(goal).push(move);
            movePegs(pegs, pegs.get(start).size(), start, goal);
        } else {
            int temp = 3 - start - goal;
            //ystem.out.println("temp " + temp);
            movePegs(pegs, nPegs-1, start, temp);
            //movePegs(nPegs-1), start, goal, total);
        }
        System.out.println("");
        System.out.println(nPegs + " pegs moved: " + pegs);
        System.out.println("");
    }

    public static void createPegs(int nPegs) {
        List<Stack<Integer>> pegs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            pegs.add(new Stack<Integer>());
        }
        for (int i = 0; i < nPegs; i++) {
            pegs.get(0).push(nPegs - i);
        }
        System.out.println(nPegs + " pegs: " + pegs);
        
        movePegs(pegs, nPegs, 0, 2);
        
        makeMove(pegs, nPegs, nPegs);
        System.out.println("");
    }

    public static void makeMove(List<Stack<Integer>> pegs, int peg, int total) {
        if (pegs.get(2).size() == total) {
            return;
        }
        if (pegs.get(0).lastElement() == peg) {
            if (pegs.get(0).size() % 2 == 0) {
                pegs.get(0).pop();
                pegs.get(1).push(peg);
                System.out.print(peg + "->" + 2 + " ");
                makeMove(pegs, peg+1, total);
            } else {
                pegs.get(0).pop();
                pegs.get(2).push(peg);
                System.out.print(peg + "->" + 3 + " ");
                makeMove(pegs, peg+1, total);
            }
        } else if (pegs.get(1).lastElement() == peg) {
            if (pegs.get(1).size() % 2 == 0) {
                pegs.get(1).pop();
                pegs.get(0).push(peg);
                System.out.print(peg + "->" + 1 + " ");
                makeMove(pegs, peg+1, total);
            } else {
                pegs.get(1).pop();
                pegs.get(2).push(peg);
                System.out.print(peg + "->" + 3 + " ");
                makeMove(pegs, peg+1, total);
            }
        } else {
            makeMove(pegs, peg-1, total);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createPegs(3);
        createPegs(4);
    }

}
