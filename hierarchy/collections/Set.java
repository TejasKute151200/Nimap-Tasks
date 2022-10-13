package corejava.hierarchy.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Set {
	public static void main(String[] args) {
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		System.out.println("         --------- HashSet ---------         "); 
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		
	HashSet <String> hs = new HashSet<>();
	hs.add("ABC");
	hs.add("ABC");
	hs.add("CDE");
	hs.add("EDB");
	
	System.out.println(hs);
	System.out.println(" ");
	
	hs.contains("ABC");
	System.out.println(hs);
	System.out.println(" ");
	
	hs.remove("ABC");
	System.out.println(hs);
	System.out.println(" ");
	
	for (String str:hs)
	{
		System.out.println(str);
	}
	
	System.out.println(" ");
	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
	System.out.println(" "); 
	System.out.println("         --------- LinkedHashSet ---------         "); 
	System.out.println(" ");
	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
	System.out.println(" "); 
	
	LinkedHashSet <String> lhs= new LinkedHashSet<>();
	lhs.add("Tejas");
	lhs.add("Sanjay");
	lhs.add("Kute");
	lhs.add("Tejas");
	System.out.println(lhs);
	System.out.println(" ");
	
	lhs.remove("Tejas");
	System.out.println(lhs);
	System.out.println(" ");
	
	for (String str: lhs)
	{
		System.out.println(str);
	}
	
	System.out.println(" ");
	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
	System.out.println(" "); 
	System.out.println("         --------- TreeSet ---------         "); 
	System.out.println(" ");
	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
	System.out.println(" "); 
	
	TreeSet<String> ts= new TreeSet<>();
	ts.add("Hello !,");
	ts.add("Tejas");
	ts.add("I");
	ts.add("Am");
	ts.add("Tejas");
	
	System.out.println(ts);
	System.out.println(" "); 
	
	ts.remove("Hello !,");
	System.out.println(ts);
	System.out.println(" "); 
	
	for (String str: ts)
	{
		System.out.println(str);
	}
	
	System.out.println(" "); 
	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
	
	}

}
