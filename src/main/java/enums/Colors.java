package enums;

public enum Colors {
    RED("red"), GREEN("green"), BLUE("blue");

    private String value;

    Colors(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}