/****************************
 * Tijana Milovanovic
 * Winter 2016
 * Programming Assignment#2 Production line
 * COSC 423
 * Factory.java 
 * Creates the buffer and the producer/consumer threads A,B,C, and D
 ****************************/

public class Factory {
	
	public static void main(String args[]) {
		
		int widgetsToProduce = 24;
		
		ConveyerBelt AB = new ConveyerBelt();
		ConveyerBelt BC = new ConveyerBelt();
		ConveyerBelt CD = new ConveyerBelt();

      		//now create the producer and consumer threads
      		Producer A = new Producer("A", AB, widgetsToProduce);
      		Both B = new Both("B", AB, BC, widgetsToProduce);
      		Both C = new Both("C", BC, CD, widgetsToProduce);
      		Consumer D = new Consumer("D", CD, widgetsToProduce);
      
      		A.start();
      		B.start();
      		C.start();
      		D.start();               
	}
}