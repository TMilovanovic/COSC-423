/****************************
 * Tijana Milovanovic
 * Winter 2016
 * Programming Assignment#2 Production line
 * COSC 423
 * Widget.java
 * Keeps track of how many Workers have handled a widget so far
 **************************************/

public class Widget {
	//each widget has to have its own name and counter
	private int count;
	private String name;
	
	public Widget(String name){
		this.name = name;
		count = 0;
	}
	
	//invoked by each Worker when it gets the widget
	//how many workers have handled a widget so far
	public void workUpon(){
		count++;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCount(){
		return count;
	}

}
