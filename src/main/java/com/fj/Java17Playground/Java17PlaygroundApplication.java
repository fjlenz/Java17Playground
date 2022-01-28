package com.fj.Java17Playground;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Java17PlaygroundApplication {

	public static void main(String[] args) {

		runItNow();
	}

	public static void runItNow() {
		List<PersonEntity> names = Arrays.asList(
				new PersonEntity(1, "Horst", "Hebert", 20),
				new PersonEntity(2, "Hans", "Robert", 18),
				new PersonEntity(3, "Daniel", "Honk", 48)
		);

		System.out.println("... foreach");
		names.forEach(personEntity -> System.out.println(personEntity));

		System.out.println("... foreach with :: double colon operator");
		names.forEach(System.out::println);

		System.out.println("... for");
		for (PersonEntity name : names) {
			System.out.println(name);
		}

		System.out.println("... stream filter bigger than 2");
		names.stream()
				.filter(p -> p.getId() > 1)
				.forEach(p -> System.out.println("after filter: " + p));

		System.out.println("... Flatmap");
		String[][] arrayOfArraysOfChars = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		String[] result = Arrays.stream(arrayOfArraysOfChars).flatMap(Stream::of).toArray(String[]::new);
		for (String s : result) {
			System.out.println(s);
		}

		System.out.println("... Flatmap Filter");
		Arrays.stream(arrayOfArraysOfChars).flatMap(Stream::of).filter(c -> !"a".equals(c)).forEach(System.out::println);

	}

}
