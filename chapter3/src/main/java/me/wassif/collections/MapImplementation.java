package me.wassif.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class MapImplementation {
	public static void main(String[] args) {
		// not sorted
		// O(1) search O(1) insert
		Map<Keyword, String[]> hashMap = new HashMap<>(3);
		hashMap.put(new Keyword("int"), new String[] { "int", "INT" });
		hashMap.put(new Keyword("long"), new String[] { "int", "LONG" });
		hashMap.put(new Keyword("short"), new String[] { "int", "SHORT" });
		System.out.println(hashMap);
		// sorted
		// O(log) search O(log) insert
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(0, "one");
		treeMap.put(1, "two");
		treeMap.put(4, "five");
		System.out.println(treeMap);
	}
}

class Keyword {
	String value;

	public Keyword(String keyString) {
		this.value = keyString;
	}

	@Override
	public int hashCode() {
		int prime = 13;
		int result = 1;
		return prime * result + ((value == null) ? 0 : value.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		return value.equals(((Keyword) obj).value);
	}

	@Override
	public String toString() {
		int h;
		return value + " hash : " + ((hashCode() ^ hashCode() >>> 16)) % 3;
	}
}
