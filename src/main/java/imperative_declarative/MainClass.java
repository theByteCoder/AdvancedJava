package imperative_declarative;

import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class MainClass {

    public static void main(String ...args) {

        Logger LOGGER =
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        List<Person> persons = List.of(
                new Person("Subhasish", "Ghosh", 30, Gender.MALE),
                new Person("Piyu", "Paul", 30, Gender.FEMALE)
        );

        // imperative approach
        for (Person person : persons) {
            if (person.gender == Gender.MALE) {
                LOGGER.log(Level.INFO, "{0}", person);
            }
        }

        // declarative approach
        persons.stream()
                .filter(person -> person.gender == Gender.MALE)
                .collect(Collectors.toList())
                .forEach(item -> LOGGER.log(Level.INFO, "{0}", item));

    }
}
