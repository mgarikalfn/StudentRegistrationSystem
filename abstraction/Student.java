package abstraction;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    //student class the has name, id , email fields.and registerstudents method
    private static String name;
    private static String id;
    private static String email;

    public Student(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public static String getName() {
        return name;
    }

    public static String getId() {
        return id;
    }

    public static String getEmail() {
        return email;
    }

    public void registerStudent(Scanner scanner) {
        try {
            System.out.print("Enter student name: ");
            Scanner nameScanner = new Scanner(System.in);
            String name = nameScanner.nextLine();

            System.out.print("Enter student ID: ");
            Scanner idScanner = new Scanner(System.in);
            String id = idScanner.nextLine();

            System.out.print("Enter student email: ");
            Scanner emailScanner = new Scanner(System.in);
            String email = emailScanner.nextLine();

            Student student = new Student(name, id, email);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input detected. Please enter valid values.");
        } catch (Exception e) {
            System.out.println("Error occurred during student registration: " + e.getMessage());
        }
    }
}

 class Undergraduate extends Student {
    //undergraduate subclass of student that add department .
    public static String department;

    public Undergraduate(String name, String id, String email, String department) {
        super(name, id, email);
        this.department = department;
    }
//register student method that override the same method found in the main class
    @Override
    public void registerStudent(Scanner scanner) {
        super.registerStudent(scanner);

        try {
            System.out.print("Enter student department: ");
            Scanner departmentScanner = new Scanner(System.in);
            String department = departmentScanner.nextLine();

            Undergraduate undergraduate = new Undergraduate(getName(), getId(), getEmail(), department);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input detected. Please enter a valid department name.");
        } catch (Exception e) {
            System.out.println("Error occurred during undergraduate student registration: " + e.getMessage());
        }
    }

    public static String displayRegisteredStudents() {
        return "Name: " + getName() + ", ID: " + getId() + ", Department: " + department;
    }
}

class Graduate extends Student {
    //graduate class that extends from the student class that has additional attribute of researchfield .
    private String researchField;

    public Graduate(String name, String id, String email, String researchField) {
        super(name, id, email);
        this.researchField = researchField;
    }
//registerstudents method that overrides the method found on the superclass.
    @Override
    public void registerStudent(Scanner scanner) {
        super.registerStudent(scanner);

        try {
            System.out.print("Enter student research field: ");
            Scanner researchFieldScanner = new Scanner(System.in);
            String researchField = researchFieldScanner.nextLine();

            Graduate graduate = new Graduate(getName(), getId(), getEmail(), researchField);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input detected. Please enter a valid research field.");
        } catch (Exception e) {
            System.out.println("Error occurred during graduate student registration: " + e.getMessage());
        }
    }


}
