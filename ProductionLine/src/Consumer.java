/****************************
 * Tijana Milovanovic
 * Winter 2016
 * Programming Assignment#2 Production line
 * COSC 423
 * Consumer.java 
 * Represents the Worker D that consumes the widgets from the Worker C 
 ****************************/

import java.util.*;

public class Consumer extends Thread {
	
	private  ConveyerBelt buffer;
	public String myName;
	private int widgetsToProduce;
	
	//constructor method
	public Consumer(String label, ConveyerBelt b, int widgetsToProduce){
		buffer = b;
		myName = label;
		this.widgetsToProduce = widgetsToProduce;
	}
	
	public void run(){
		
		while(widgetsToProduce>0){
			ConveyerBelt.napping();
			
			// consume an item from the buffer
	        buffer.receive(myName);
	        widgetsToProduce--;
		}
		System.out.println("Worker D is done!");
	}
}

