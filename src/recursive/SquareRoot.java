/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursive;

/**
 * This exercise is about finding the square root of a number
 * by doing a recursive binary search for it.
 */
public class SquareRoot {

	public static int findSquare(int a){
		int iMin = 1;
		int iMax = a / 2;
		int num = iMax / 2;
		return binary(a, iMin, num);
	}
	
	public static int binary(int a, int iMin, int num) {
	    	if(num*num == a) {
	    		return num;
	    	} else if (num*num > a) {
	    		return binary(a, iMin, num-1);
	    	} else {
	    		return binary(a, iMin+1, num);
	    	}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Square root for 25 is " + findSquare(25));
		System.out.println("Square root for 81 is " + findSquare(81));
		System.out.println("Square root for 225 is " + findSquare(225));
		System.out.println("Square root for 841 is " + findSquare(841));
		System.out.println("Square root for 1024 is " + findSquare(1024));
		System.out.println("Square root for 7056 is " + findSquare(7056));
		System.out.println("Square root for 36 is " + findSquare(36));
		System.out.println("Square root for 144 is " + findSquare(144));
	}
	
}
