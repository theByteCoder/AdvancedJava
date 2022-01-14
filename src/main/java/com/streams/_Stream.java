package com.streams;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {
        final List<Engineers> enggList = List.of(
                new Engineers(1, "Subhasish", Gender.MALE),
                new Engineers(2, "Piyu", Gender.FEMALE),
                new Engineers(3, "Rimi", Gender.FEMALE),
                new Engineers(4, Gender.MALE),
                new Engineers(5)
        );

        final Predicate<Engineers> isEngineerNameNull = engg -> !StringUtils.isBlank(engg.enggName);

        final Function<Engineers, Integer> getEngineerId = engg -> engg.enggId;

        final Set<Integer> enggNames = enggList
                .stream()
                .filter(isEngineerNameNull)
                .map(getEngineerId)
                .collect(Collectors.toSet());

        final Function<Engineers, CharSequence> getEngineerGender = engg -> engg.gender.getGender.get();

        Set<CharSequence> enggGenders = enggList
                .stream()
                .filter(isEngineerNameNull)
                .map(getEngineerGender)
                .collect(Collectors.toSet());

        Consumer<Integer> println = System.out::println;
        enggNames.forEach(println);

        enggGenders.forEach(System.out::println);

        enggList
                .stream()
                .filter(isEngineerNameNull).forEach(System.out::println);
        boolean areThereFemales = enggList
                .stream()
                .filter(isEngineerNameNull)
                .anyMatch(engg -> Gender.FEMALE.equals(engg.gender));
        System.out.println("Are there females " + areThereFemales);
    }

    static class Engineers {
        private int enggId;
        private String enggName;
        private Gender gender;

        Engineers(int enggId, String enggName, Gender gender) {
            this.enggId = enggId;
            this.enggName = enggName;
            this.gender = gender;
        }

        public Engineers(int enggId, Gender gender) {
            this.enggId = enggId;
            this.gender = gender;
        }

        public Engineers(int enggId) {
            this.enggId = enggId;
        }

        @Override
        public String toString() {
            return "Engineers{" +
                    "enggId=" + enggId +
                    ", enggName='" + enggName + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
}
