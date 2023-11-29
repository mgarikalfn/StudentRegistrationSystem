package abstraction;

import java.util.Scanner;

public class Display {

    public static void displayCourses() {
        String[] courses = {"dsa", "java", "networking", "computer organization", "python"};
        int[] creditHours = {3, 4, 3, 3, 3};
        System.out.println("Course\t\tCredit Hours");
        System.out.println("------------------------");

        for (int i = 0; i < courses.length; i++) {
            System.out.printf("%-20s %d%n", courses[i], creditHours[i]);
        }
        Scanner keyboard =new Scanner(System.in);
        System.out.println("Register for the semister or exit?(R/E)");
        String choice=keyboard.next();
        if(choice.equalsIgnoreCase("R"))
            System.out.println("You have successfully registered.");
        else if(choice.equalsIgnoreCase("E"))
            System.exit(0);
        else
            System.out.println("invalid input.");


    }
}








