package corejava.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
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
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
			
		// filter()
		List<String> names= List.of("Tejas","Sanjay","Kute","Savitra");
		List<String> sName= names.stream().filter(a->a.startsWith("S")).collect(Collectors.toList());
		System.out.println("Start With S Element Words Will Print >>> "+"\n "+sName);
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		
		// map()
		List<Integer> numbers = List.of(23,34,45,56,67,78,89,65);
		List<Integer> newNum = numbers.stream().map(b-> b*b).collect(Collectors.toList());
		System.out.println("Square of the Given Numbers Are : "+ newNum);
		
		System.out.println(" ");
		
		List<String>mName =names.stream().map(c->c+"-"+c).collect(Collectors.toList());
		System.out.println("        "+mName);
		
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		
		// filter + forEach
		names.stream().filter(a->a.startsWith("S")).forEach(a-> System.out.print(a+" "));
		
		System.out.println(" ");
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		
		// map + forEach
		numbers.stream().map(b-> b*b).forEach(b->System.out.println(b+" "));
		
		System.out.println(" ");
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		
		// Direct iteration By Using Double Colon Operator( method reference operator ) 
		names.stream().forEach(System.out::println); // note: r&d on this topic
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		
		// Sorting
		numbers.stream().sorted().forEach(f-> System.out.println(f));
		
		System.out.println(" ");
		
		Integer i = numbers.stream().min((x,y)->x.compareTo(y)).get();  // For Min 
		System.out.println("Min >>> "+i);
		
		Integer j = numbers.stream().max((x,y)->x.compareTo(y)).get();  // For Max 
		System.out.println("Max >>> "+j);	
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		
		// peek
		List<Integer> newNumbers = numbers.stream().filter(d->d%2==0).map(d->d+d).peek(System.out::println).collect(Collectors.toList());
		
		System.out.println(" ");
		List<Integer> newNum2= newNumbers.stream().collect(Collectors.toList());
		System.out.println(newNum2);
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		
		// Get Unique Elements
		List<Integer> list = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5); 
		  
        System.out.print("The Distinct Elements Are >>> "); 
  
		        // Displaying the distinct elements in the list 
		        	// using Stream.distinct() method 
        list.stream().distinct().forEach(System.out::print); 
        
        System.out.println("\n");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		
		// Reduce 
		int newList =list.stream().reduce(0,(a,b) -> a+b);
		System.out.println("Addition the List of Elements >>> "+newList);
		
		System.out.println(" ");
		
		int newList2= list.stream().reduce(1,(a,b)->a-b);
		System.out.println("Sub the List of Elements >>> "+newList2);
		
		System.out.println(" ");
		
		int newList3= list.stream().reduce(1,(a,b)->a*b); 
		System.out.println("Multiply the List of Elements >>> "+newList3);
		
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
		
		// Grouping 
        List<String> groupMethod = Arrays.asList("Tejas", "Sanjay", "Kute","Tejas");
 
        				// Collect the list as map
        				// by groupingBy() method
        Map <String, Long> result = groupMethod.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
 
       
        System.out.println(result);
        
        System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
        
		// Partioning
        Stream<Integer> p = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); 
        Stream<Integer> p2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); 
		        // using Collectors partitioningBy() 
		        // method to split the stream of elements into 
		        // 2 parts, greater than 3 and less than 3. 
        Map<Boolean, List<Integer>> map = p.collect( Collectors.partitioningBy(num -> num > 3)); 
  
		        // Displaying the result as a map 
		        // true if greater than 3, false otherwise 
        System.out.println("Elements in stream " + "partitioned by " + "less than equal to 3: \n" + map);
        
        System.out.println(" ");
        
        // 2nd Partioning 
        Map<Boolean, Long> map2 = p2.collect(Collectors.partitioningBy(num -> (num < 3), Collectors.counting()));
        System.out.println("Elements in stream " + "partitioned by " + "less than equal to 3: \n" + map2);
        
        System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" "); 
 
	}
}
