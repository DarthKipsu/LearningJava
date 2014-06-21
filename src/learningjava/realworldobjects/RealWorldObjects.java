/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package learningjava.realworldobjects;

/**
 * Object making exercise.
 */

public class RealWorldObjects {

	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
	    SO ilari = new SO();
	    ilari.takeADrink(0.0003);
	    ilari.takeADrink(0.0003);
	    ilari.takeADrink(0.0003);
	    ilari.takeADrink(0.0003);
	    ilari.takeADrink(0.0003);
	    ilari.takeADrink(0.0003);
	    ilari.sleep(4.5);
	    ilari.printState();
    }
}