import java.util.ArrayList;

/**
 * <p>
 * Title: GanntChart
 * </p>
 * <p>
 * Description: Maintain data necessary to render a Gannt chart.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015, 2004 by Matt Evett
 * </p>
 * 
 * @author Matt Evett
 * @version 2.0 simulates the scheduler
 * @author Tijana Milovanovic
 * Winter 2016
 * COSC 423
 */

public class GanttChart {
	private long systemStartTime; // wall time when the Gantt chart starts. Is
									// used
									// to display all timings as relative to
									// this time
	private ArrayList<GanttRecord> events = new ArrayList<GanttRecord>();

	public GanttChart() {

	}

	public void start() {
		systemStartTime = System.currentTimeMillis(); // set OS start time
	}

	public void recordEvent(long startTime, long endTime, String eventDescriptor) {
		events.add(new GanttRecord(startTime, endTime, eventDescriptor));
	}

	public void end() {
		long endTime = System.currentTimeMillis();
		events.add(new GanttRecord(endTime, endTime, "FINISHED"));
	}

	public void print() {
		// System.out.println("TO_DO GanntChart.print not yet implemented");
		// print out the ArrayList events
		System.out.println("\nGANTT CHART: ");
		System.out.println("Wall time at start: " + systemStartTime);
		System.out.println("BurstStart\tBurstEnd\tJOB");

		for (GanttRecord ganttChartRecord : events) {
			System.out.println("\t" + (ganttChartRecord.startTime - systemStartTime) + "\t" + (ganttChartRecord.endTime - systemStartTime) + "\t\t"
					+ ganttChartRecord.eventDescriptor);
		}

	}

	/**
	 * Inner class to record the data of one Gantt chart event
	 * 
	 * @author matt
	 *
	 */
	private class GanttRecord {
		long startTime;
		long endTime;
		String eventDescriptor;

		GanttRecord(long start, long end, String descrip) {
			startTime = start;
			endTime = end;
			eventDescriptor = descrip;
		}
	}

}
