import java.util.ArrayList;

public class gradeManager {

    // Method to reverse student names in an array
    public static String[] reverseStudentNames(String[] names) {
        String[] reversed = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            StringBuilder sb = new StringBuilder(names[i]);
            reversed[i] = sb.reverse().toString();
        }
        return reversed;
    }

    // Method to calculate letter grades
    public static char getLetterGrade(int score) {
        if (score >= 90 && score <= 100) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else if (score >= 60) return 'D';
        else return 'F';
    }

    // Method to find students who need to retake the exam
    public static String[] findFailingStudents(String[] names, int[] scores) {
        ArrayList<String> failing = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failing.add(names[i]);
            }
        }

        return failing.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        // Test reverse names
        System.out.println("Reversed Names:");
        String[] reversed = reverseStudentNames(students);
        for (String name : reversed) {
            System.out.println(name);
        }

        // Test letter grades
        System.out.println("\nLetter Grades:");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i] + ": " + getLetterGrade(scores[i]));
        }

        // Test failing students
        System.out.println("\nStudents who need to retake the exam:");
        String[] failing = findFailingStudents(students, scores);
        for (String name : failing) {
            System.out.println(name);
        }
    }
}
