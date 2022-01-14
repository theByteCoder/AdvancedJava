package com.functional.interfaces.consumers.callback;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Consumer;

public class Callback {

    static void callBackFuntion(String name, Consumer<String> callback) {
        if (StringUtils.isAllBlank(name)) {
            callback.accept("Name is not provided");
        } else {
            System.out.println(String.format("Name is %s", name));
        }
    }

    public static void main(String[] args) {
        callBackFuntion("Subhasish", value -> System.out.println(value));
        callBackFuntion(null, value -> System.out.println(value));
    }
}
