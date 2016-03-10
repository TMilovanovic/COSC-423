/****************************
 * Tijana Milovanovic
 * Winter 2016
 * Programming Assignment#1 Threads
 * COSC 423
 * The main thread that gets the user input
 * and then calls several different worker 
 * thread in order to compute the desired values
 ****************************/

import java.util.*;

public class Stats{
	
	//declaration of the variables
	public static double average;
	public static int min;
	public static int max;
	//extra credit
	public static double standardDeviation;
	public static int median;
	
	
	public static void main(String[] args){
		
		//prompt the user for input
		 System.out.println("Please enter as many integers as you'd like, separating them with space: ");
		 
		 Scanner keyboard = new Scanner(System.in);
		 String input = keyboard.nextLine();
		 
		 if (input.length() < 1) {
			 System.out.println("Please enter integers separated by spaces.");
			 System.exit(0);
		 }
		 else{
			//parse it
			 String inputArray[] = input.split(" ");
		     int[] numbers = new int[inputArray.length];
		     
		     for (int i = 0; i < numbers.length; ++i) {
		    	 try {
		    		 numbers[i] = Integer.parseInt(inputArray[i]);
		    	 }
		    	 catch (NumberFormatException e) {
		    		 System.out.println("Please enter integers separated by spaces.");
		    		 System.exit(0);
		    	 }
		    	 
		     }
		     
		     //start threads
		     Thread findAverage = new AverageThread(numbers);
		     Thread minThread = new MinThread(numbers);
		     Thread maxThread = new MaxThread(numbers);
		     Thread medianThread = new MedianThread(numbers);
		     Thread standDeviationThread = new StandardDevThread(numbers);
		     
		     findAverage.start();
		     minThread.start();
		     maxThread.start();
		     medianThread.start();
		     standDeviationThread.start();
		     
		     try{
		    	 findAverage.join();
			     minThread.join();
			     maxThread.join();
			     medianThread.join();
			     standDeviationThread.join();
		     }
		     catch(InterruptedException e){
		          System.out.println("Interrupted thread");
		     }
		     finally{
			     //print the obtained values
			     System.out.println("The average value is " + average);
			     System.out.println("The minimum value is " + min);
			     System.out.println("The maximum value is " + max);
			     System.out.println("The median value is " + median);
			     System.out.println("The standard deviation value is " + standardDeviation);
		     }
		 }
		 
	}


}
