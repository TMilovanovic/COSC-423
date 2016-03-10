/****************************
 * Tijana Milovanovic
 * Winter 2016
 * Programming Assignment#1 Threads
 * COSC 423
 * A worker thread that finds the largest number in an int number array
 ****************************/

public class MaxThread extends Thread{
	//thread that finds the largest of the given numbers
	int maxValue=Integer.MIN_VALUE;
	int[] numbers;
	
	public MaxThread(int[] numbers){
		//pass the array with input numbers
		this.numbers=numbers;
	}
	
	public void run(){
		//find the largest number in the array
		for(int i=0;i<numbers.length;i++){
			if(numbers[i]>maxValue){
				maxValue=numbers[i];
			}
		}
		//set the value of the global max variable
		Stats.max=maxValue;
	}
}
