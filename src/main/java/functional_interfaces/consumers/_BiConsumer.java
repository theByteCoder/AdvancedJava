package functional_interfaces.consumers;

import java.util.function.BiConsumer;

public class _BiConsumer {

    public static void main(String... args) {
        Students subhasish = new Students(1, "Subhasish", "9145743771");
        studDetails(subhasish, false);
        studDetails(subhasish, true);
        studDetailsBiConsumer.accept(subhasish, false);
        studDetailsBiConsumer.accept(subhasish, true);
    }

    // imperative approach
    static void studDetails(Students students, Boolean showPhNum) {
        System.out.println("imperative approach Students{" +
                "studId=" + students.studId +
                ", studName='" + students.studName + '\'' +
                ", phNum='" + (showPhNum ? students.phNum : "**********") + '\'' +
                '}');
    }

    // declarative approach
    static BiConsumer<Students, Boolean> studDetailsBiConsumer = (students, showPhNum) -> {
        System.out.println("declarative approach Students{" +
                "studId=" + students.studId +
                ", studName='" + students.studName + '\'' +
                ", phNum='" + (showPhNum ? students.phNum : "**********") + '\'' +
                '}');
    };

    static class Students {
        private int studId;
        private String studName;
        private String phNum;

        public Students(int studId, String studName, String phNum) {
            this.studId = studId;
            this.studName = studName;
            this.phNum = phNum;
        }
    }

}
