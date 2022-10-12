package corejava.hierarchy.collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class List 
{
	public static void main(String[] args) 
	{
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 

		//Without Type Safety
		ArrayList list= new ArrayList();
		
		list.add(21);
		list.add("Tejas");
		list.add(78.45);
		
		Iterator itr = list.iterator();
		
		System.out.println(list);
		
		System.out.println(" ");
		
		// Iterate the Elements By Using Iteration Interface
		while (itr.hasNext()) {
			Object i= itr.next();
			System.out.println(i);
		}
		
		System.out.println(" ");
		
		// Iterate the Elements By Using forEach
		for (Object object:list) {
			System.out.println(object);
		}
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		System.out.println("         --------- ArrayList ---------         "); 
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");  
		
		// Type Safety 
		ArrayList <String> arrayList = new ArrayList<>();
		arrayList.add("Tejas");
		arrayList.add("Ranjit");
		arrayList.add("Sanjay");
		arrayList.add("Savitra");
		arrayList.add("Kute");
		
		System.out.println(arrayList);
		
		System.out.println(" ");
		
		Collections.sort(arrayList); //Alphabetically Ascending
		System.out.println("Ascending >>> " + arrayList);
		
		System.out.println(" ");
		
		Collections.reverse(arrayList); //Alphabetically Descending
		System.out.println("Descending >>> " + arrayList);
		
		System.out.println(" ");
		
		Collections.sort(arrayList, Collections.reverseOrder()); //Alphabetically Descending
		System.out.println("Descending >>> " + arrayList);
		
		System.out.println(" ");
		
		System.out.println("Index Position of Given Input >>> "+arrayList.lastIndexOf("Sanjay")); // it Returns Index Position
		
		System.out.println(" ");
		
		arrayList.remove(4);
		System.out.println(arrayList);
		
		//arrayList.clear();
		//arrayList.removeAll(arrayList);
		//System.out.println(arrayList);
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		System.out.println("         --------- LinkedList ---------         "); 
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		
		LinkedList <String> linkedList = new LinkedList<>();
		linkedList.add("Tejas");
		linkedList.add("Sanjay");
		linkedList.add("Kute");
		linkedList.push("Savitra");
		linkedList.push("Ranjit");
		linkedList.push("Rudransh");
		
		System.out.println(linkedList);
		
		System.out.println(" ");
		
		linkedList.remove();
		linkedList.pop();    // FIFO Operation
		linkedList.poll();
		
		System.out.println(linkedList);
		
		System.out.println(" ");
		
		System.out.println(linkedList.peek()); 
		
		System.out.println(" ");
		
		linkedList.set(2,"Vishwa");
		System.out.println(linkedList);
		
		System.out.println(" ");
		
		linkedList.offer("Tejas");
		System.out.println(linkedList);
		
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		System.out.println("         --------- Vector ---------         "); 
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		
		Vector<Integer> vector = new Vector<>();
		vector.add(21);
		vector.add(27);
		vector.add(43);
		vector.add(54);
		
//		for(int i = 50; i < 100; i++) {
//			vector.add(i);
//		}
		
		System.out.println(vector);
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		System.out.println("         --------- Stack ---------         "); 
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		
		Stack <Integer> stack = new Stack<>();
		
		for (int i = 1; i<= 5; i++) {
			stack.add(i);
		}
		System.out.println(stack);
		
		System.out.println(" ");
		
		for (int i = 16; i<= 20; i++) {
			stack.push(i);
		}
		System.out.println(stack);
		
		System.out.println(" ");
		
		stack.pop();											// LIFO Operation 
		System.out.println(stack);
		System.out.println(" ");
		
																	// LIFO Operation 
		System.out.println(stack.peek());
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		
	}

}
