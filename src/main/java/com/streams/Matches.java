package com.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Matches {

    public static void main(String[] args) {
        List<User> userList = List.of(
                new User(1L, "User 1", 30, "u1@user.com", Gender.MALE),
                new User(2L, "User 2", 18, "u2@user.com", Gender.MALE),
                new User(3L, "User 3", 65, "u3@user.com", Gender.FEMALE),
                new User(4L, "User 4", 14, "u4@user.com", Gender.MALE),
                new User(5L, "User 5", 43, "u5@user.com", Gender.FEMALE),
                new User(6L, "User 6", 61, "u6@user.com", Gender.MALE),
                new User(7L, "User 7", 37, "u7@user.com", Gender.FEMALE),
                new User(8L, "User 8", 78, "u8@user.com", Gender.MALE),
                new User(9L, "User 9", 93, "u9@user.com", Gender.MALE),
                new User(10L, "User 10", 5, "u10@user.com", Gender.FEMALE)
        );

        // all match
        Predicate<List<User>> allUsersOlderThan = users -> users.stream().allMatch(user -> user.getAge() > 10);
        System.out.println("All users are older than 10 " + allUsersOlderThan.test(userList));
        Predicate<List<User>> allUsersYoungerThan = users -> users.stream().allMatch(user -> user.getAge() < 15);
        System.out.println("All users are younger than 15 " + allUsersYoungerThan.test(userList));

        // any match
        System.out.println("At least one users is older than 60 " + userList.stream().anyMatch(user -> user.getAge() > 60));
        System.out.println("At least one users is younger than 15 " + userList.stream().anyMatch(user -> user.getAge() < 15));

        // none match
        System.out.println("No users is named User 6 " + userList.stream().noneMatch(user -> user.getName().equals("User 6")));
        System.out.println("No users is named User 1 " + userList.stream().noneMatch(user -> user.getName().equals("User 1")));

        // max
        userList
                .stream()
                .max(Comparator.comparing(User::getAge))
                .ifPresent(System.out::println);
        // min
        userList
                .stream()
                .min(Comparator.comparing(User::getAge))
                .ifPresent(System.out::println);

        // group
        final Map<Gender, List<User>> groupByGender = userList.stream().collect(Collectors.groupingBy(User::getGender));
        groupByGender.forEach((gender, users) -> {
            System.out.println(gender);
            System.out.println(users);
        });

        // oldest female
        final Optional<String> max = userList
                .stream()
                .filter(user -> Gender.FEMALE.equals(user.getGender()))
                .max(Comparator.comparing(User::getAge))
                .map(User::getName);
        max.ifPresent(System.out::println);

        // every male above 50
        userList
                .stream()
                .filter(user -> Gender.MALE.equals(user.getGender()) && user.getAge() > 60)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
