package com.fj.Java17Playground;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java17PlaygroundApplication {

	public static void main(String[] args) {

		runItNow();
	}

	public static void runItNow() {
		List<PersonEntity> names = Arrays.asList(
				new PersonEntity(1, "Horst", "Hebert", 7),
				new PersonEntity(2, "Hans", "Robert", 18),
				new PersonEntity(3, "Daniel", "Honk", 34)
		);

		System.out.println("... foreach with Lambda");
		names.forEach(personEntity -> System.out.println(personEntity));

		System.out.println("... foreach with :: double colon operator");
		names.forEach(System.out::println);

		System.out.println("... for loop");
		for (PersonEntity name : names) {
			System.out.println(name);
		}

		System.out.println("... stream - map firstName to upper case");
		names.stream()
						.map(p -> p.getFirstName().toUpperCase())
								.forEach(p -> System.out.println("uppercase: " + p));

		System.out.println("... stream - add age + 10 inside existing PersonEntity list");
		names.stream()
						.forEach(personEntity -> personEntity.setAge(personEntity.getAge() + 10));
		names.forEach(System.out::println);

		System.out.println("... stream - uppercase - with .map to create new List");
		List<PersonEntity> namesUppercase = names.stream()
				.map(p -> new PersonEntity(p.getId(), p.getFirstName().toUpperCase(), p.getLastName().toUpperCase(), p.getAge()))
				.toList();
		namesUppercase.forEach(System.out::println);

		System.out.println("... stream filter with ID bigger than 1");
		names.stream()
				.filter(p -> p.getId() > 1)
				.forEach(p -> System.out.println("after filter: " + p));

		System.out.println("... flatmap");
		String[][] arrayOfArraysOfChars = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		String[] result = Arrays.stream(arrayOfArraysOfChars).flatMap(Stream::of).toArray(String[]::new);
		for (String s : result) {
			System.out.println(s);
		}

		System.out.println("... Flatmap Filter");
		Arrays.stream(arrayOfArraysOfChars)
				.flatMap(Stream::of)
				.filter(c -> !"a".equals(c)).forEach(System.out::println);

	}

}
