/****************************
 * Tijana Milovanovic
 * Winter 2016
 * Programming Assignment#1 Threads
 * COSC 423
 * A worker thread that calculates the median of the int number array
 ****************************/

import java.util.Arrays;

public class MedianThread extends Thread{
	//thread that finds the median of the given numbers
	int[] numbers;
	
	public MedianThread(int[] numbers){
		//pass the array with input numbers
		this.numbers=numbers;
	}
	
	public void run(){
		//find the median number in the array
		Arrays.sort(numbers); //sort the numbers
		int middle = numbers.length/2;
		
		if (numbers.length%2==1){ 
		    Stats.median = numbers[middle];
		}
		else{
		   Stats.median = (numbers[middle-1] + numbers[middle])/2;
		}
		
	}

}
