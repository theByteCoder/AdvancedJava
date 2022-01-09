package functional_interfaces.functions;

import java.util.function.BiFunction;

public class _BiFunction {

    public static void main(String... args) {
        System.out.println("imperative approach " + addAndMultiply(1, 2));
        System.out.println("declarative approach " + biFunction.apply(1, 2));
    }

    // imperative approach
    static int addAndMultiply(int num1, int num2) {
        return (num1 += 1) * num2;
    }

    // declarative approach
    static BiFunction<Integer, Integer, Integer> biFunction = (numToAdd, numToMultiply) -> (numToAdd += 1) * numToMultiply;

}
