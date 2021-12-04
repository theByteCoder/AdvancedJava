package imperativeDeclarative;

public class Person {

    private  String firstName;
    private String lastName;
    private int age;
    public Gender gender;

    public Person(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

}
