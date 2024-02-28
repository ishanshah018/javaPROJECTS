import java.util.Scanner;

class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize the marks array

        int[][] marks = { { 46, 47, 48, 49, 50 }, { 47, 48, 49, 50, 51 }, { 48, 49, 50, 51, 52 },
                { 49, 50, 51, 52, 53 },
                { 50, 51, 52, 53, 54 }, { 51, 52, 53, 54, 55 }, { 52, 53, 54, 55, 56 }, { 53, 54, 55, 56, 57 },
                { 54, 55, 56, 57, 58 }, { 55, 56, 57, 58, 59 }, { 56, 57, 58, 59, 60 }, { 57, 58, 59, 60, 61 },
                { 58, 59, 60, 61, 62 }, { 59, 60, 61, 62, 63 }, { 60, 61, 62, 63, 64 }, { 61, 62, 63, 64, 65 },
                { 62, 63, 64, 65, 66 }, { 63, 64, 65, 66, 67 }, { 81, 82, 83, 84, 85 }, { 95, 96, 97, 98, 99 } };

        /*
         * // Input marks for each student and subject
         * for (int i = 0; i < 20; i++) {
         * System.out.println("Enter marks for student " + (i + 1) + ": ");
         * for (int j = 0; j < 5; j++) {
         * System.out.print("Subject " + (j + 1) + ": ");
         * marks[i][j] = sc.nextInt();
         * }
         * }
         */
        System.out.println("\n");

        StudentMarks a = new StudentMarks();
        // a) Find average marks obtained in each subject

        System.out.print("Average of subject : " + "\n");
        a.findSubjectAverages(marks);
        System.out.println("\n");

        System.out.print("Average of Student: " + "\n");
        a.findStudentAverages(marks);
        System.out.println("\n");

        System.out.print("Student Below 50 : " + "\n");
        a.countStudentsBelow50(marks);
        System.out.println("\n");

        System.out.print("Score of all Student: " + "\n");
        a.displayStudentScores(marks);
        System.out.println("\n");

        System.out.print("Grade of subject : " + "\n");
        a.displaySubjectGrades(marks);
        System.out.println("\n");

        System.out.print("SPI of subject : " + "\n");
        a.calculateSPI(marks);
        System.out.println("\n");

        System.out.print("top 5 Student : " + "\n");
        a.displayTopFiveStudents(marks);
        System.out.println("\n");

    }

    void findSubjectAverages(int[][] marks) {
        for (int subject = 0; subject < 5; subject++) {
            int totalMarks = 0;
            for (int student = 0; student < 20; student++) {
                totalMarks = totalMarks + marks[student][subject];
            }
            double average = totalMarks / 20.0;
            System.out.println("Average marks for Subject " + (subject + 1) + ": " + average);
        }
    }

    void findStudentAverages(int[][] marks) {
        for (int student = 0; student < 20; student++) {
            int totalMarks = 0;
            for (int subject = 0; subject < 5; subject++) {
                totalMarks = totalMarks + marks[student][subject];
            }
            double average = (double) totalMarks / 5;
            System.out.println("Average marks for Student " + (student + 1) + ": " + average);
        }
    }

    void countStudentsBelow50(int[][] marks) {
        int count = 0;
        for (int student = 0; student < 20; student++) {
            int totalMarks = 0;
            for (int subject = 0; subject < 5; subject++) {
                totalMarks = totalMarks + marks[student][subject];
            }
            double average = (double) totalMarks / 5;
            if (average < 50) {
                count++;
            }
        }
        System.out.println("Number of students with average below 50: " + count);
    }

    void displayStudentScores(int[][] marks) {
        for (int student = 0; student < 20; student++) {
            System.out.print("Scores for Student " + (student + 1) + ": ");
            for (int subject = 0; subject < 5; subject++) {
                System.out.print(marks[student][subject] + " ");
            }
            System.out.println();
        }
    }

    void displayTopFiveStudents(int[][] marks) {
        // Calculate percentage for each student
        double[] percentages = new double[20];
        for (int student = 0; student < 20; student++) {
            int totalMarks = 0;
            for (int subject = 0; subject < 5; subject++) {
                totalMarks = totalMarks + marks[student][subject];
            }
            percentages[student] = (double) totalMarks / 5;
        }

        // Sort the students based on percentage
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19 - i; j++) {
                if (percentages[j] < percentages[j + 1]) {
                    // Swap percentages
                    double temp = percentages[j];
                    percentages[j] = percentages[j + 1];
                    percentages[j + 1] = temp;

                    // Swap corresponding marks
                    int[] tempMarks = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = tempMarks;
                }
            }
        }

        // Display top five students
        System.out.println("Top five students based on percentage:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            for (int subject = 0; subject < 5; subject++) {
                System.out.print(marks[i][subject] + " ");
            }
            System.out.println("Percentage: " + percentages[i]);
        }
    }

    void displaySubjectGrades(int[][] marks) {
        for (int subject = 0; subject < 5; subject++) {
            System.out.print("Grades for Subject " + (subject + 1) + ": ");
            for (int student = 0; student < 20; student++) {
                char grade = calculateGrade(marks[student][subject]);
                System.out.print(grade + " ");
            }
            System.out.println();
        }
    }

    char calculateGrade(int marks) {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else if (marks >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }

    void calculateSPI(int[][] marks) {
        int marks1[][] = marks;
        int credit_of_sub1 = 5;
        int credit_of_sub2 = 5;
        int credit_of_sub3 = 5;
        int credit_of_sub4 = 5;
        int credit_of_sub5 = 5;
        for (int student = 0; student < 20; student++) {
            int totalCredits = 0;
            double spi = 0.0;

            // Assuming 5 credits for each subject
            for (int subject = 0; subject < 5; subject++) {
                totalCredits = totalCredits + 5;
                spi = spi + calculateGradePoint(marks1[student][subject]) * 5.0;
            }

            // Calculate SPI
            spi /= totalCredits;

            System.out.println("SPI for Student " + (student + 1) + ": " + spi);
        }
    }

    double gp;

    double calculateGradePoint(int marks1) {

        if (marks1 >= 90) {
            gp = 10.0;
        } else if (marks1 >= 80) {
            gp = 9.0;
        } else if (marks1 >= 70) {
            gp = 8.0;
        } else if (marks1 >= 60) {
            gp = 7.0;
        } else if (marks1 >= 50) {
            gp = 6.0;
        } else if (marks1 >= 40) {
            gp = 5.0;
        } else if (marks1 >= 30) {
            gp = 4.0;
        } else if (marks1 >= 20) {
            gp = 3.0;
        } else if (marks1 >= 10) {
            gp = 2.0;
        }

        else if (marks1 >= 0) {
            gp = 1.0;
        }

        return gp;
    }
}
