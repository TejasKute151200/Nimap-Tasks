package corejava.hierarchy.collections;

import java.util.PriorityQueue;

public class Queue {

	public static void main(String[] args) {

		
		PriorityQueue<Integer> pq = new PriorityQueue<>(15);
		
		
		for (int i= 1; i <= 17; i+=3) {
			pq.add(i);
			
		}
		System.out.println(pq);
		
		System.out.println(pq.comparator());
	}

}
