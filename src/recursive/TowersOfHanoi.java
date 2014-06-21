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
public class TowersOfHanoi {

    public static void createPegs(int a) {
        List<Stack<Integer>> pegs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            pegs.add(new Stack<Integer>());
        }
        for (int i = 0; i < a; i++) {
            pegs.get(0).push(a - i);
        }
        System.out.println(a + " pegs: " + pegs);
        
        makeMove(pegs, a);
        System.out.println("");
        System.out.println(a + " pegs moved: " + pegs);
        System.out.println("");
    }

    public static void makeMove(List<Stack<Integer>> pegs, int a) {
        if (pegs.get(2).size() == a) {
            return;
        }
        int move;
        if (pegs.get(1).empty() || pegs.get(2).empty()) {
            if (pegs.get(0).size() % 2 == 0) {
                move = pegs.get(0).pop();
                pegs.get(1).push(move);
                System.out.print(move + "->" + 2 + " ");
                makeMove(pegs, a);
            } else {
                move = pegs.get(0).pop();
                pegs.get(2).push(move);
                System.out.print(move + "->" + 3 + " ");
                makeMove(pegs, a);
            }
        } else {
            int bigPeg = pegs.get(1).lastElement();
            int list = 1;
            if (pegs.get(2).lastElement()>bigPeg) {
                bigPeg = pegs.get(2).lastElement();
                list = 2;
            }
            int movePeg = bigPeg - 1;
            int moveList = 2;
            if (pegs.get(1).contains(movePeg)) {
                moveList = 1;
            } else if (pegs.get(0).contains(movePeg)) {
                moveList = 0;
            }
            
            if (pegs.get(list).lastElement()==bigPeg) {
                if (pegs.get(moveList).lastElement()==movePeg) {
                    move = pegs.get(moveList).pop();
                    pegs.get(list).push(move);
                    System.out.print(move + "->" + (list + 1) + " ");
                    makeMove(pegs, a);
                } else {
                    if (pegs.get(moveList).size() % 2 == 0) {
                        move = pegs.get(moveList).pop();
                        pegs.get(0).push(move);
                        System.out.print(move + "->" + 1 + " ");
                        makeMove(pegs, a);
                    }
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createPegs(3);
        createPegs(4);
        createPegs(5);
    }

}
