package de.bischinger.wildflytest.optional;

import static java.lang.System.currentTimeMillis;
import static java.util.Arrays.asList;

import java.util.List;
import java.util.Optional;

import de.bischinger.wildflytest.Person;

/**
 * @author Alexander Bischof, BMW
 */
public class Main {

    public static void main(String[] args) {

        final Optional<String> stringOptional = Optional.of("Alex");


        final Optional<Long> longOptional = Optional.of(2L);
        System.out.println(longOptional.get());

        final String herbi = Optional.<String>ofNullable(null).orElse("herbi"+ currentTimeMillis());
        final String herbi2 = Optional.<String>ofNullable(null).orElseGet(() -> "herbi" + currentTimeMillis());

        System.out.println(herbi);
        System.out.println(herbi2);

        System.out.println("======");
        String newName = "herbi";
        final List<Person> persons = asList(null, new Person("alex"));


        for (Person person : persons) {
            if (person == null){
                person = new Person(newName);
            }else {
                person.setName(newName);
            }
            System.out.println(person.getName());
        }

    }
}
