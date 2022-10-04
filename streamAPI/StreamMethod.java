package corejava.streamAPI;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethod {

	public static void main(String[] args) {
		
		// #Ignore Comments 
		
		/*
		 * filter(predicate) - it means when predicate check the boolean value is true 
		 * then filter out the stream
		 * // boolean Value Function
		 * 
		 * map(function) - it means function return the value
		 *  // each element Operation
		 */
		
		// filter()
		List<String> names= List.of("Tejas","Sanjay","Kute","Savitra");
		List<String> sName= names.stream().filter(a->a.startsWith("S")).collect(Collectors.toList());
		System.out.println("Start With S Element Words Will Print >>> "+"\n "+sName);
		
		// map()
		List<Integer> numbers = List.of(23,34,45,56,67,78,89,65);
		List<Integer> newNum = numbers.stream().map(b-> b*b).collect(Collectors.toList());
		System.out.println("Square of the Given Numbers Are : "+ newNum);
		
		// filter + forEach
		names.stream().filter(a->a.startsWith("S")).forEach(a-> System.out.print(a+" "));
		
		System.out.println(" ");
		
		// Direct iteration By Using Double Colon Operator( method reference operator ) 
		names.stream().forEach(System.out::println);
		
		// Sorting
		numbers.stream().sorted().forEach(f-> System.out.println(f));
		
		Integer i = numbers.stream().min((x,y)->x.compareTo(y)).get();  // For Min 
		System.out.println("Min >>> "+i);
		
		Integer j = numbers.stream().max((x,y)->x.compareTo(y)).get();  // For Max 
		System.out.println("Max >>> "+j);
		
		
	}
}
