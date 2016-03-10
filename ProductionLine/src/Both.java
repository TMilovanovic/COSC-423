/****************************
 * Tijana Milovanovic
 * Winter 2016
 * Programming Assignment#2 Production line
 * COSC 423
 * Both.java 
 * Represents the Worker D that consumes the widgets from the Worker C 
 ****************************/

import java.util.*;

public class Both extends Thread {
	
	private  ConveyerBelt bufferFrom;
	private  ConveyerBelt bufferTo;
	public String myName;
	private int widgetsToProduce;
	
	//constructor method
	public Both(String label, ConveyerBelt bufferFrom, ConveyerBelt bufferTo, int widgetsToProduce){
		this.bufferFrom = bufferFrom;
		this.bufferTo = bufferTo;
		myName = label;
		this.widgetsToProduce = widgetsToProduce;
	}
	
	public void run(){
		
		while(widgetsToProduce>0){
			ConveyerBelt.napping();
			
			// consume an item from the buffer first
			Widget w = bufferFrom.receive(myName);
			bufferTo.send(myName, w);	
			widgetsToProduce--;
		}
		System.out.println("Worker "+ myName +" is done!");
	}
}
