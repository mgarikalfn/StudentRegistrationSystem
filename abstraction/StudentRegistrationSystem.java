package abstraction;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentRegistrationSystem {

    public static void main(String[] args) {
       // String[] courses = {"DSA", "OOP", "computer networking", "computer organization", "Database system"};
       // int[] creditHours = {3, 4, 4, 3, 3};
        Scanner scanner = new Scanner(System.in);
        // an arraylist of student datatype to store the students registered to be accessed later by the instructor.
        List<Student> students = new ArrayList<>();

        int choice;

        try {
            do {
                //choose between the student and the admin user
                System.out.println("_________WELCOME TO HARAMAYA UNIVERSITY REGISTRATION SYSTEM__________");
                System.out.println("1. Student user");
                System.out.println("2. Admin user (Instructor)");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        //case 1 asks the students if he is undergraduate or masters students
                        System.out.println("---------REGISTRATION FOR SEMESTER COURSES---------------");
                        System.out.print("are you an undergraduate or Masters student? (U/M): ");
                        String studentType = scanner.next();

                        if (studentType.equalsIgnoreCase("U")) {
                            Undergraduate undergraduate = new Undergraduate("", "", "", "");
                            undergraduate.registerStudent(scanner);
                            students.add(undergraduate);//calls the student class to acess registeration method.
                            Display.displayCourses();//callls the display class to display the registered courses.
                        } else if (studentType.equalsIgnoreCase("M")) {
                            Graduate graduate = new Graduate("", "", "", "");
                            graduate.registerStudent(scanner);
                            students.add(graduate);
                            System.out.println("+-----------------------------------------+");
                            System.out.println();
                            System.out.println("|    Student registered successfully.      |");
                            System.out.println();
                            System.out.println("+-----------------------------------------+");
                        } else {
                            //if the student entered invalid input type .
                            System.out.println("Invalid student type.");
                        }
                        break;
                    case 2:
                        //case 2 is for admin inorder to login as an admin you need authentication .(the username is username.
                        //the password is admin).
                        if (Instructor.authenticateUser()) {
                            int secondChoice;

                            try {
                                do {
                                    //the admin can add student grade and get grade report , view registered student.
                                    Scanner secondScanner = new Scanner(System.in);
                                    System.out.println("1. Add Student grade");
                                    System.out.println("2. View Registered Students");
                                    //to view registered students they must register as student first
                                    System.out.println("3. Exit");
                                    System.out.print("Enter your choice: ");
                                    secondChoice = secondScanner.nextInt();

                                    switch (secondChoice) {
                                        case 1:
                                            //case 1 accepts students grade. and print the accepted courses details in a table format.
                                            Instructor.addStudent();
                                            Instructor.printCourseDetails();
                                            break;
                                        case 2:
                                            //shows the registered students.
                                            System.out.println(Undergraduate.displayRegisteredStudents());
                                            break;
                                        case 3:
                                            System.out.println("Exiting ......");
                                            break;
                                        default:
                                            System.out.println("Invalid choice!");
                                            break;
                                    }
                                } while (secondChoice != 3);
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input detected. Please enter a valid option.");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter again.");
                }
            } while (choice != 3);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input detected. Please enter a valid option.");
        }
    }
}
