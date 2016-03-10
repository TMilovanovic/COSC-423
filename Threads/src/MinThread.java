/****************************
 * Tijana Milovanovic
 * Winter 2016
 * Programming Assignment#1 Threads
 * COSC 423
 * A worker thread that finds the smallest number in an int number array
 ****************************/

public class MinThread extends Thread{
	//thread that finds the smallest of the given numbers
	int minValue=Integer.MAX_VALUE;
	int[] numbers;
	
	public MinThread(int[] numbers){
		//pass the array with input numbers
		this.numbers=numbers;
	}
	
	public void run(){
		for(int i=0;i<numbers.length;i++){
			if(minValue>numbers[i]){
				minValue=numbers[i];
			}
		}
		//set the value of the global min variable
        Stats.min=minValue;
	}
}
