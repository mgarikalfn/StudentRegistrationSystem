package abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentInfo {
    //studentInfo class that contains name,stuId fields .
    private String name;
    private String stuId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    private double gpa;

    public StudentInfo(String name, String stuId, double gpa) {
        this.name = name;
        this.stuId = stuId;
        this.gpa = gpa;
    }

    public String display() {
        return "Name: " + name + ", ID: " + stuId + ", GPA: " + gpa;
    }
}

public class Instructor {
    //instructor class that has method of add students,view students, get gradepoints ,printcoursedetails method .
    private static Scanner scanner = new Scanner(System.in);
    public static List<StudentInfo> students = new ArrayList<>();

    private static String[][]courseDetails;
    public static boolean authenticateUser() {
        //checks if the user has privilage to access this class.
        System.out.println("(in order to login as admin you should have a username and password");
        System.out.println("(the username is:username and the password is: admin)");
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if ((username.equalsIgnoreCase("username") && password.equals("admin")) ||
                (username.equalsIgnoreCase("abebe") && password.equals("admin"))) {
            return true;
        } else {
            System.out.println("Invalid username or password!");
            return false;
        }
    }

    public static void addStudent() {
        //calculate students gpa after accepting grade of each course the instructor enters .
        //and stores it in arraylist.
        try{
        System.out.print("Enter student name: ");
        Scanner scanner1=new Scanner(System.in);
        String name = scanner1.nextLine();
        System.out.print("Enter student ID: ");
        Scanner scanner2=new Scanner(System.in);
        String stuId = scanner2.nextLine();
        System.out.print("Enter the number of courses: ");
        Scanner scanner3=new Scanner(System.in);
        int numCourses = scanner3.nextInt();

        double totalCredits = 0;
        double totalGradePoints = 0;
         courseDetails = new String[numCourses][3];

        for (int i = 0; i < numCourses; i++) {
            System.out.println("Course " + (i + 1) + ":");
            System.out.print("Enter the course name: ");
            Scanner nameScanner=new Scanner(System.in);
            String courseName = nameScanner.nextLine();
            courseDetails[i][0] = courseName;
            System.out.print("Enter the course credits: ");
            Scanner creditScanner=new Scanner(System.in);
            double courseCredits = creditScanner.nextDouble();
            courseDetails[i][1] = String.valueOf(courseCredits);
            totalCredits += courseCredits;

            System.out.print("Enter the grade obtained (A, B, C, D, F): ");
            Scanner gradeScanner=new Scanner(System.in);
            String grade = gradeScanner.nextLine();
            courseDetails[i][2] = grade;

            double gradePoints = getGradePoints(grade);
            totalGradePoints += gradePoints * courseCredits;
        }

        double gpa = totalGradePoints / totalCredits;
        System.out.println("GPA: " + gpa);

        students.add(new StudentInfo(name, stuId, gpa));
    }catch (Exception e){
            System.out.println("An error occured while adding a student:"+e.getMessage());
        }finally {
            scanner.nextLine();
        }
        }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("List of Students:");
            for (StudentInfo student : students) {
                System.out.println(student.display());
            }
        }
    }

    public static double getGradePoints(String grade) {
        switch (grade) {
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                System.out.println("Invalid grade entered!");
                return 0.0;
        }
    }


    public static void printCourseDetails() {
        System.out.println();
        System.out.println("Student Name: " + students.get(students.size() - 1).getName());
        System.out.println("Student ID: " + students.get(students.size() - 1).getStuId());
        System.out.println("GPA: " + students.get(students.size() - 1).getGpa());
        System.out.println();
        System.out.println("Courses         Course Name           Credit Hour          Grade");
        for (int i = 0; i < courseDetails.length; i++) {
            String courseName = courseDetails[i][0];
            String creditHour = courseDetails[i][1];
            String grade = courseDetails[i][2];

            System.out.print("Course " + (i + 1) + ":");
            System.out.print("          " + courseName);
            System.out.print("          " + creditHour);
            System.out.print("          " + grade);
            System.out.println();
        }

    }


}
