 import javax.swing.JOptionPane;

public class StudentMarkCalculator {
    public static void main(String[] args) {
        // Constants for the number of subjects
        final int NUM_SUBJECTS = 5;

        // Get the student's name
        String studentName = JOptionPane.showInputDialog("Enter your name:");

        int totalMarks = 0;

        // Input marks for each subject
        for (int subjectIndex = 0; subjectIndex < NUM_SUBJECTS; subjectIndex++) {
            String subjectName = getSubjectName(subjectIndex);
            String inputMessage = "Enter marks for " + subjectName + " (out of 100):";

            try {
                String marksString = JOptionPane.showInputDialog(inputMessage);
                int subjectMarks = Integer.parseInt(marksString);

                // Validate if the entered marks are within the valid range (0-100)
                if (subjectMarks < 0 || subjectMarks > 100) {
                    JOptionPane.showMessageDialog(null, "Invalid marks! Marks should be between 0 and 100.");
                    return;
                }

                totalMarks += subjectMarks;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for marks. Please enter a valid number.");
                return;
            }
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / NUM_SUBJECTS;

        // Assign grades based on the average percentage
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results using JOptionPane
        String resultMessage = "Student: " + studentName + "\n" +
                "Total Marks: " + totalMarks + "\n" +
                "Average Percentage: " + averagePercentage + "%\n" +
                "Grade: " + grade;

        JOptionPane.showMessageDialog(null, resultMessage);
    }

    // Helper method to get the subject name based on the subject index
    private static String getSubjectName(int index) {
        switch (index) {
            case 0:
                return "Math";
            case 1:
                return "Physics";
            case 2:
                return "English";
            case 3:
                return "Biology";
            case 4:
                return "Computer Science";
            default:
                return "Unknown Subject";
        }
    }
}
