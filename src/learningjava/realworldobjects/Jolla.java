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
public class Jolla {
	boolean activated = true;
	boolean recharging = false;
	int batteryLevel = 75;

	public void startRecharging() {
		recharging = true;
	}

	public void recharge(int rechargeTime) {
		batteryLevel = batteryLevel + rechargeTime;
	}

	public void stopRecharge() {
		if(batteryLevel==100) {
			recharging = false;
		}
	}	
}
