import java.util.Scanner;

public class SriramMarksCalculator {

    public static void main(String[] args) {
         System.out.println("SRIRAMMOLLETI,TASK2");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of subjects written in sriram exam:");
        int numberOfSubjects = scanner.nextInt();

        int totalMarks = 0;
        int[] subjectMarks = new int[numberOfSubjects];

        System.out.println("Enter the marks obtained in each subject (out of 100):");
        for (int i = 0; i < numberOfSubjects; i++) {
            subjectMarks[i] = scanner.nextInt();
            totalMarks += subjectMarks[i];
        }

        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);
        String grade = getGrade(averagePercentage);

        System.out.println("Total Marks in sriram exam: " + totalMarks);
        System.out.printf("Average Percentage in sriram exam: %.2f%%%n", averagePercentage);
        System.out.println("Final Grade in sriram exam: " + grade);

        scanner.close();
    }

    private static double calculateAveragePercentage(int totalMarks, int numberOfSubjects) {
        return (double) totalMarks / (numberOfSubjects * 100) * 100;
    }

    private static String getGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 50) {
            return "B";
        } else if (averagePercentage >= 30) {
            return "C";
        } else {
            return "D";
        }
    }
}