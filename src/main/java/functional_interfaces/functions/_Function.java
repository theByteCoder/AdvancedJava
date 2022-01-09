package functional_interfaces.functions;

import java.util.function.Function;

public class _Function {

    public static void main(String... args) {

        int increment = increment(1);
        System.out.println("imperative approach " + increment);

        System.out.println("declarative approach " + incrementByOneFunction.apply(1));
    }

    // imperative approach
    static int increment(int num) {
        return num += 1;
    }

    // declarative approach
    static Function<Integer, Integer> incrementByOneFunction = num -> num += 1;
}
