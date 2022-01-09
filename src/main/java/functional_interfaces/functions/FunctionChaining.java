package functional_interfaces.functions;

import java.util.function.Function;

public class FunctionChaining {

    static Function<Integer, Integer> addByOne = num -> num += 1;
    static Function<Integer, Integer> multiplyBy10 = num -> num * 10;

    public static void main(String... args) {
        final Function<Integer, Integer> addThenMultiplyFunction = addByOne.andThen(multiplyBy10);
        System.out.println(addThenMultiplyFunction.apply(1));
    }
}
