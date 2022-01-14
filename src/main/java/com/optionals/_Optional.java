package com.optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class _Optional {

    public static void main(String[] args) {

        Optional<String> optional = Optional
                .ofNullable("Hello");
        System.out.println(optional.get());

        Optional<Object> nullOptional = Optional
                .ofNullable(null);
        final Supplier<String> objectSupplier = () -> "Default value";
        Object value = nullOptional
                .orElseGet(objectSupplier);
        System.out.println(value);

        Optional
                .ofNullable("Hello")
                .ifPresent(System.out::println);

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Null")
                );

        Optional<Object> exceptionOptional = Optional
                .ofNullable(null);
        final Supplier<IllegalStateException> illegalStateExceptionSupplier = () -> new IllegalStateException("Illegal State");
        Object exception = exceptionOptional
                .orElseThrow(illegalStateExceptionSupplier);
        System.out.println(exception);

    }
}
