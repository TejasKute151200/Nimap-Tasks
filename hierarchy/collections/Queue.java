package corejava.hierarchy.collections;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Queue {

	public static void main(String[] args) {

		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		System.out.println("         --------- PriorityQueue ---------         "); 
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");  
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(15);
		
		
		for (int i= 1; i <= 17; i+=3) {
			pq.add(i);
			
		}
		System.out.println(pq);
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		System.out.println("         --------- ArrayDeque ---------         "); 
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");  
		
		ArrayDeque<Integer> adq = new ArrayDeque<>();
		
		// Nothing More Difference in Queues Hierarchy
		// Null Values Are Not Accepted
		// Add or Remove Elements From Both Sides
		
		
	}

}
