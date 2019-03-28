package de.bischinger.wildflytest;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Alexander Bischof, BMW
 */
public class Person {
    private String name;

    public Person() {
    }

    public Person(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        final Function<Person, String> nameFunction = Person::getName;
        final Function<Person, String> nameFunction2 = person -> person.getName();

        final Person alex = new Person("alex");
        System.out.println(nameFunction.apply(alex));

        Stream.of(new Person("alex"), new Person("herbi"))
                .map(Person::getName)
                .forEach(System.out::println);

        final Stream<String> stream = Stream.of("eins", "zwei");
        stream.forEach(System.out::println);
    }
}
