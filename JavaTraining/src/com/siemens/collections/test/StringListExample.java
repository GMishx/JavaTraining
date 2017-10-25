package com.siemens.collections.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StringListExample {
	public static void main(String[] args) {
		// List<String> stringCollection = new ArrayList<>();
		// List<String> anotherList = new LinkedList<>();
		Collection<String> stringCollection = new TreeSet<>();
		stringCollection.add("2");
		stringCollection.add("1");
		stringCollection.add("4");
		stringCollection.add("3");
		stringCollection.add("4");
		stringCollection.add("5");
		stringCollection.add("3");
		stringCollection.add("6");
		stringCollection.add("5");
		stringCollection.add("6");

		Object[] temp = stringCollection.toArray();
		for (int i = 0; i < stringCollection.size(); i++) {
			System.out.print(temp[i]);
		}

		System.out.println();
		for (String string : stringCollection) {
			System.out.print(string);
		}
		System.out.println();
		for (Iterator<String> iterator = stringCollection.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.print(string);
		}
		System.out.println(new Object());
	}
}
