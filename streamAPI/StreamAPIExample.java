package corejava.streamAPI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIExample {

	public static void main(String[] args) {

		List<Integer> list1 = List.of(12, 23, 34, 45, 56); // Immutable List
		System.out.println("List >>> " + list1);
		List<Integer> list2 = Arrays.asList(98, 98, 87, 76, 65); // Immutable Arrays
		System.out.println("Arrays >>> " + list2);

		// Without Stream API
		List<Integer> ListEven = new ArrayList();
		System.out.print("Even Numbers Are ");
		for (Integer i : list1) {
			if (i % 2 == 0) {
				System.out.print(" " + i);
			}
		}
		System.out.println(" ");

		// With Stream API
		Stream<Integer> stream = list2.stream();
		List<Integer> newList = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println("New List By Using Stream : " + newList);

		List<Integer> newList2 = list1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println("New List2 By Using Stream : " + newList2);

		List<Integer> newList3 = list1.stream().filter(i -> i < 35).collect(Collectors.toList());
		System.out.println("Numbers of Array Less Than 35 is " + newList3);

	}

}
