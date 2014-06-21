/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursive;
import java.util.*;

/**
 * This program will solve the towers of Hanoi with N amount
 * of pegs as a starting value.
 */
public class TowersOfHanoi {

	public static void createPegs(int a){
	    List<Stack<Integer>> pegs = new ArrayList<>();
	    for (int i=0; i<3; i++) {
		pegs.add(new Stack<Integer>());
	    }
	    for (int i=0; i<a; i++) {
		    pegs.get(0).push(a-i);
	    }
	    System.out.println(pegs);
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
