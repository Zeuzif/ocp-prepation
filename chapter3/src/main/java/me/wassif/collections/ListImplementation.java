package me.wassif.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListImplementation {
	public static void main(String[] args) {
		// O(1) for search O(n) for insert
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		System.out.println(arrayList.indexOf(1));
		
		// add, and remove from the
		// beginning and end of the list in constant time
		List<String> linkedList = new LinkedList<>();
		linkedList.toString();
	}
}
