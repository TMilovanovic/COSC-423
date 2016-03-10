/****************************
 * Tijana Milovanovic
 * Winter 2016
 * Programming Assignment#2 Production line
 * COSC 423
 * Producer.java 
 * Represents the Worker A that creates the widgets and passes them to the Worker B
 ****************************/

import java.util.*;

public class Producer extends Thread{
	   
	private  ConveyerBelt buffer;
	public String myName;
	private int widgetsToProduce;
	
	public Producer(String label, ConveyerBelt b, int widgetsToProduce){
		buffer = b;
		myName = label;
		this.widgetsToProduce = widgetsToProduce;
	}
	
	/*public String getTheadName(){
		return myName;
	}*/
	
	public void run(){
     
		for(int i=1; i<=widgetsToProduce;i++){
			ConveyerBelt.napping();
				
			// produce a widget and send it into the conveyer belt
			Widget w = new Widget("widget"+i);
			System.out.println("Worker A is working on the "+ w.getName() +"<handled by A>");
			buffer.send(myName,w);
		}
		System.out.println("Worker A is done!");
	}

}