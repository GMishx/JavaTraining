package com.siemens.collections.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		List<Number> myList = new ArrayList<Number>();
		myList.add(100);
		myList.add(200);
		myList.add(new Number() {
			private static final long serialVersionUID = -4801282311788515805L;
			String name = "SS";

			@Override
			public String toString() {
				return name;
			}

			@Override
			public double doubleValue() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public float floatValue() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int intValue() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public long longValue() {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		// System.out.println(myList);
		Iterator<Number> itt = myList.iterator();
		while (itt.hasNext()) {
			System.out.println(itt.next());
		}
	}

	interface Emp {
	}

}
