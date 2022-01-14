package com.functional.interfaces.consumers.runnable;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

public class _Runnable {

    static void runnableFunction(String name, Runnable runnable) {
        Predicate<String> isNameNull = n -> StringUtils.isBlank(n);
        if (isNameNull.test(name)) {
            runnable.run();
        } else {
            System.out.println(String.format("Name is %s", name));
        }
    }

    public static void main(String[] args) {

        runnableFunction(
                "Subhasish",
                () -> {
                    System.out.println("Name is not provided");
                });

        runnableFunction(null, () -> {
            System.out.println("Name is not provided");
        });
    }
}
