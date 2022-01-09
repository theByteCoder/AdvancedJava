import java.util.List;

public class ScopeResolutionOperator {

    public String isTrue (Boolean bool) {
        return bool ? "True" : "False";
    }


    // :: scope resolution operator
    public void printer() {
        List<Boolean> booleans = List.of(true, false, false, false, true, false);
        booleans.stream().map(this::isTrue).forEach(System.out::println);
    }

    public static void main(String args[]) {
        ScopeResolutionOperator dc = new ScopeResolutionOperator();
        dc.printer();
    }
}
