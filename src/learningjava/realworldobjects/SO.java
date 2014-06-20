/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package learningjava.realworldobjects;

/**
 *
 * @author kipsu
 */
public class SO {
	
	double bloodAlcohol = 0;
	int weight = 73;
	boolean hangover = false;

	public void takeADrink(double portion) {
		bloodAlcohol = bloodAlcohol + weight * portion;
	}

	public void sleep(double hours) {
		if(bloodAlcohol>=0.1) {
			hangover = true;
		}
		bloodAlcohol = bloodAlcohol / hours;
	}

	public void printState() {
		System.out.println("Hangover: " + hangover);
		System.out.println("Blood alcohol level: " + bloodAlcohol);
	}
}
