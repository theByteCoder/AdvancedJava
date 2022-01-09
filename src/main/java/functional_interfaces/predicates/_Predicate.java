package functional_interfaces.predicates;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class _Predicate {

    public static void main(String... args) {

        Gender MALE = Gender.MALE;
        Gender FEMALE = Gender.FEMALE;

        List<User> users = List.of(
                new User(1, "subhasish064", MALE),
                new User(2, "subh064", MALE),
                new User(3, "piyu789", FEMALE)
        );

        // declarative approach
        final Predicate<String> predicatePhNum = string -> string.length() == 10;

        System.out.println("declarative approach " + predicatePhNum.test("9145743771"));

        final Predicate<User> userPredicate = user -> MALE.equals(user.gender);

        List<User> nonZeroUsers = users
                .stream()
                .filter(userPredicate)
                .collect(Collectors.toList());
        nonZeroUsers.forEach(System.out::println);
    }

    static class User {
        private final int id;
        private final String userName;
        private final Gender gender;

        public User(int id, String userName, Gender gender) {
            this.id = id;
            this.userName = userName;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", userName='" + userName + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE("M"), FEMALE("F");
        private String label;

        Gender(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

}