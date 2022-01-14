package com.enums;

public class Main {

    public static void main(String args[]) {
        Colors color = Colors.RED;
        System.out.println("Enum color name " + color.name());
        System.out.println("Enum color value " + color.getValue());

        // imperative approach
        for(Colors colors : Colors.values()) {
            System.out.println("Enum color values " + colors.getValue());
        }

        Days day = Days.MONDAY;
        System.out.println("Enum name " + day.name());
        for(Days days : day.values()) {
            System.out.println("Enum day " + days);
        }
    }
}
