/*************************************
 * 
 * Tijana Milovanovic COSC 423 Winter 2016 Work.java
 * 
 *************************************/
public class Work implements JobWorkable {

	@Override
	public void doWork() {
		/*
		 * print a message that contains the name of the thread that is
		 * executing the doWork() you can always get the reference though
		 * Thread.currentThread()
		 */

		// get the currently running thread name
		String name = Thread.currentThread().getName(); //toString()

		System.out.println("Thread " + name + " is doing some work");

	}

}
