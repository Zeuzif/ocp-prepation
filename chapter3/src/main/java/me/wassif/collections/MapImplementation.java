package me.wassif.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapImplementation {
	public static void main(String[] args) {
		// not sorted
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(0, "one");
		hashMap.put(1, "two");
		hashMap.put(4, "five");
		System.out.println(hashMap);
		// sorted
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(0, "one");
		treeMap.put(1, "two");
		treeMap.put(4, "five");
		System.out.println(treeMap);
	}
}
