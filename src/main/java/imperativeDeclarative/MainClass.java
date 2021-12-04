package imperativeDeclarative;

import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String... args) {

        List<Person> persons = List.of(
                new Person("Subhasish", "Ghosh", 30, Gender.MALE),
                new Person("Piyu", "Paul", 30, Gender.FEMALE)
        );

        // imperative approach
        for (Person person : persons) {
            if (person.gender == Gender.MALE) {
                System.out.println(person);
            }
        }

        // declarative approach
        persons.stream()
                .filter(person -> person.gender == Gender.MALE)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
