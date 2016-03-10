/****************************
 * Tijana Milovanovic
 * Winter 2016
 * Programming Assignment#1 Threads
 * COSC 423
 * A worker thread that calculates the average of the int number array
 ****************************/

public class AverageThread extends Thread{
	//thread that calculates the average of the given numbers
	int sum=0;
	int[] numbers;
	
	public AverageThread(int[] numbers){
		//pass the array with input numbers
		this.numbers=numbers;
	}
	
	public void run(){
		for(int i=0;i<numbers.length;i++){
			sum=sum+numbers[i];
		}
		//set the value of the global average variable    
        Stats.average=(double)sum/numbers.length;
	}
	
}
