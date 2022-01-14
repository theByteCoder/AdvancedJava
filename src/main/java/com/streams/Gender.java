package com.streams;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public enum Gender {

    MALE("M"), FEMALE("F"), OTHER("O");

    private String label;

    Gender(String label) {
        this.label = label;
    }

    public Supplier<CharSequence> getGender = () -> label;

}
