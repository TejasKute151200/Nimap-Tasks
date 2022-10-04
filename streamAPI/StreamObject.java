package corejava.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObject {

	public static void main(String[] args) {

		// 1 - Blank
		Stream<Object> emptyStream = Stream.empty();

		// 2 - Array, Object & Collection
		String Names[] = { "Tejas", "Sanjay", "Kute", };
		System.out.print("Hello, I am ");
		
			// Without Stream API
		for (String i : Names) {
			System.out.print(i + " ");
		}
		System.out.println(" ");
		
			// With Stream API
		System.out.print("Hello, I am ");
		Stream<String> stream1 = Stream.of(Names);
		stream1.forEach(j -> System.out.print(j+" "));
		
		// 3
		Stream<Object> streamBuilder = Stream.builder().build();
		
		//4
		System.out.print("\n"+"My Array Elements : ");
//		Stream intStream=(Stream) Arrays.stream(new int[] {2,5,8,11,14,17,20});
		IntStream intStream= Arrays.stream(new int[] {2,5,8,11,14,17,20});
		intStream.forEach(k-> System.out.print(k+ " "));
		
		//5 - List, Set
		List<Integer> list = new ArrayList<>();
		list.add(34);
		list.add(51);
		list.add(21);
		list.add(27);
		
		System.out.println(" ");
		
		Stream <Integer> stream2= list.stream();
		stream2.forEach(l-> System.out.print(l+" "));
	}

}
