package com.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    public static void main(String[] args) {
        List<User> userList = List.of(
                new User(1L, "User 1", 30, "u1@user.com", Gender.MALE),
                new User(2L, "User 2", 18, "u1@user.com", Gender.MALE),
                new User(3L, "User 3", 65, "u1@user.com", Gender.FEMALE),
                new User(4L, "User 4", 14, "u1@user.com", Gender.MALE),
                new User(5L, "User 5", 43, "u1@user.com", Gender.FEMALE)
        );

        // sorted on age
        userList
                .stream()
                .filter(user -> Gender.FEMALE.equals(user.getGender()))
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // reverse sorted on age
        userList
                .stream()
                .filter(user -> Gender.MALE.equals(user.getGender()))
                .sorted(Comparator.comparing(User::getAge).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
