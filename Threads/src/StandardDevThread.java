
/****************************
 * Tijana Milovanovic
 * Winter 2016
 * Programming Assignment#1 Threads
 * COSC 423
 * A worker thread that calculates the standard deviation
 ****************************/

import java.lang.Math;

public class StandardDevThread extends Thread{
	//thread that finds the standard deviation of the given numbers
	int[] numbers;
	double variance;
	
	public StandardDevThread(int[] numbers){
		//pass the array with input numbers
		this.numbers=numbers;
	}
	
	public void run(){
		for (int i = 0; i < numbers.length; i++)
		{
		    variance = variance + (Math.pow((numbers[i]-Stats.average),2));
		}
		Stats.standardDeviation= Math.sqrt(variance/numbers.length);
	}
}
