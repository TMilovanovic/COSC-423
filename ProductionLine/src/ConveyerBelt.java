/****************************
 * Tijana Milovanovic
 * Winter 2016
 * Programming Assignment#2 Production line
 * COSC 423
 * ConveyerBelt.java 
 * This program implements the bounded buffer using Java synchronization
 ****************************/
 
import java.util.*;
 
public class ConveyerBelt {
	
	public static final double NAP_TIME=2;
	private Vector<Widget> queue;
	
	//constructor method
	public ConveyerBelt(){
		queue = new Vector<Widget>(3);
	}
	
	public static String workedUpon(Widget item){
		String answer;
		
		if(item.getCount() == 1)
			answer = "A";
		else if(item.getCount() == 2 || item.getCount() == 3)
			answer = "A, B";
		else
			answer = "A, B, C";
		
		return answer;
			
	}
	
	//workers A,B,C, and D will call this to nap
	//workers are handling their widgets at the varying rates
	public static void napping() {
		
		int sleepTime = (int) (NAP_TIME * Math.random() );
		
		try {
			Thread.sleep(sleepTime*1000); 
		}
		catch(InterruptedException e) { }
		
	}
	
	
	
	//method for adding a widget to the conveyer belt
	public synchronized void send(String threadName, Widget item){
		item.workUpon();	//increase the count
		//if a producer worker is trying to produce into a full conveyer belt
		//print a warning message and block until there is space for its production
		while(queue.size()>2){
			try{
				System.out.println("WARNING: Worker "+ threadName +" is waiting to put "+ item.getName() +"<handled by "+ workedUpon(item) +"> on conveyer");  
				wait();
			}
			catch(InterruptedException e){}
		}
	
		//add the widget to the conveyer belt
		System.out.println("Worker "+ threadName +" is placing "+ item.getName() +"<handled by "+ workedUpon(item) +"> on the belt");
		queue.addElement(item);
		
		notify();
	}
	
	//method for removing a widget from the conveyer belt
	public synchronized Widget receive(String threadName){
		Widget item;
		
		while(queue.size()==0){
			try{
				System.out.println("WARNING: Worker "+ threadName +" is idle!");
				wait();
			}
			catch(InterruptedException e){}
		}
		
		item=queue.firstElement();
		System.out.println("Worker "+ threadName +" is retrieving "+ item.getName() +"<handled by "+ workedUpon(item) +"> from the belt");
		queue.removeElementAt(0);
		item.workUpon();
		System.out.println("Worker "+ threadName +" is working on "+ item.getName() +"<handled by "+ workedUpon(item) +">");
		
		notify();
		
		return item;
		
	}
}