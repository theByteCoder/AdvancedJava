package functional_interfaces.predicates;

import java.util.function.Predicate;

public class PredicateChaining {

    static Predicate<String> isPhNumValid = phNum -> phNum.length() == 10;
    static Predicate<String> phNumStartsWith = phNum -> phNum.startsWith("9");

    public static void main(String args[]) {
        // and
        System.out.println(isPhNumValid.and(phNumStartsWith).test("99145743771"));
        System.out.println(isPhNumValid.and(phNumStartsWith).test("0145743771"));
        System.out.println(isPhNumValid.and(phNumStartsWith).test("9145743771"));

        // or
        System.out.println(isPhNumValid.or(phNumStartsWith).test("99145743771"));
        System.out.println(isPhNumValid.or(phNumStartsWith).test("0145743771"));
        System.out.println(isPhNumValid.or(phNumStartsWith).test("9145743771"));
    }

}
