package abstraction;
import jdk.internal.org.objectweb.asm.tree.InsnList;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static abstraction.Instructor.students;
import static org.junit.jupiter.api.Assertions.*;

public class StudentRegistrationSystemTest {

    @Test
    public void testRegisterUndergraduateStudentWithValidInput() {
        Scanner scanner = new Scanner(System.in);
        StudentRegistrationSystem registrationSystem = new StudentRegistrationSystem();
        Undergraduate undergraduate = new Undergraduate("", "", "", "");

        scanner.next("U");
        scanner.next("jane doe");
        scanner.next("123456789");
        scanner.next("johndoe@example.com");
        scanner.next("Computer Science");

        undergraduate.registerStudent(scanner);
        assertEquals("jane doe", undergraduate.getName());
        assertEquals("123456789", undergraduate.getId());
        assertEquals("johndoe@example.com", undergraduate.getEmail());

    }

    @Test
    public void testRegisterGraduateStudentWithValidInput() {
        Scanner scanner = new Scanner(System.in);
        StudentRegistrationSystem registrationSystem = new StudentRegistrationSystem();
        Graduate graduate = new Graduate("", "", "", "");

        scanner.next("M");
        scanner.next("jane doe");
        scanner.next("987654321");
        scanner.next("janedoe@example.com");
        scanner.next("Artificial Intelligence");

        graduate.registerStudent(scanner);
        assertEquals("jane doe", graduate.getName());
        assertEquals("987654321", graduate.getId());
        assertEquals("janedoe@example.com", graduate.getEmail());

    }

    @Test
    public void testInvalidStudentType() {
        Scanner scanner = new Scanner(System.in);
        StudentRegistrationSystem registrationSystem = new StudentRegistrationSystem();

        scanner.next("X"); // Invalid student type

        try {
            Student student = new Student("", "", "");
            student.registerStudent(scanner);
        } catch (Exception e) {
            assertEquals("Invalid student type.", e.getMessage());
        }
    }

    @Test
    public void testInvalidDepartmentName() {
        Scanner scanner = new Scanner(System.in);
        StudentRegistrationSystem registrationSystem = new StudentRegistrationSystem();
        Undergraduate undergraduate = new Undergraduate("", "", "", "");

        scanner.next("U");
        scanner.next("John Doe");
        scanner.next("123456789");
        scanner.next("johndoe@example.com");
        scanner.next("Invalid Department");

        try {
            undergraduate.registerStudent(scanner);
        } catch (Exception e) {
            assertEquals("Invalid input detected. Please enter a valid department name.", e.getMessage());
        }
    }

    @Test
    public void testInvalidResearchField() {
        Scanner scanner = new Scanner(System.in);
        StudentRegistrationSystem registrationSystem = new StudentRegistrationSystem();
        Graduate graduate = new Graduate("", "", "", "");

        scanner.next("M");
        scanner.next("Jane Doe");
        scanner.next("987654321");
        scanner.next("janedoe@example.com");
        scanner.next("Invalid Research Field");

        try {
            graduate.registerStudent(scanner);
        } catch (Exception e) {
            assertEquals("Invalid input detected. Please enter a valid research field.", e.getMessage());
        }
    }
}


 class InstructorTest {

    @Test
    public void testAddStudentWithValidInput() {
        StudentInfo student = new StudentInfo("John cena", "123456789", 3.5);
        assertEquals("John cena", student.getName());
        assertEquals("123456789", student.getStuId());
        assertEquals(3.5, student.getGpa());
    }

    @Test
    public void testAuthenticateAdminUser() {
        assertTrue(Instructor.authenticateUser());
        assertTrue(Instructor.authenticateUser());
        assertFalse(Instructor.authenticateUser());
    }

    @Test
    public void testAddStudentWithValidCourseDetails() {
        Instructor.addStudent();

        assertEquals(1, students.size());
        assertEquals("John cena", students.get(0).getName());
        assertEquals("123456789", students.get(0).getStuId());
        assertEquals(3.5, students.get(0).getGpa());
    }
}


