package se.lexicon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.BeanConfig;
import se.lexicon.config.ImportConfig;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext contextStudent = new AnnotationConfigApplicationContext(ImportConfig.class);
        StudentManagement studentManagement = contextStudent.getBean(StudentManagement.class);
        UserInputService userInputService = contextStudent.getBean(UserInputService.class);

        ApplicationContext contextScanner = new AnnotationConfigApplicationContext(BeanConfig.class);
//        Scanner scanner = contextScanner.getBean(Scanner.class);
        Scanner scanner = (Scanner) contextScanner.getBean("scanBean"); // Used the bean name from BeanConfig.java

        System.out.println("--------------------------------CREATE--------------------------------");
        Student createdStudent1 = studentManagement.create();
        System.out.println("Created Student: " + createdStudent1);
        System.out.println();

        Student createdStudent2 = studentManagement.create();
        System.out.println("Created Student: " + createdStudent2);
        System.out.println();

        Student createdStudent3 = studentManagement.create();
        System.out.println("Created Student: " + createdStudent3);
        System.out.println();

        System.out.println("---------------------------------FIND---------------------------------");
        int idToFind = userInputService.getInt(); //Used the UserInputService bean from ComponentScanConfig.java
        Student foundStudent1 = studentManagement.find(idToFind);
        System.out.println("Found Student: " + foundStudent1);
        System.out.println();

        System.out.println("-------------------------------FIND ALL-------------------------------");
        System.out.println("Student list:");
        studentManagement.findAll().forEach(System.out::println);
        System.out.println();

        System.out.println("--------------------------------DELETE--------------------------------");
        int idToDelete1 = userInputService.getInt(); //Used the UserInputService bean from ComponentScanConfig.java
        Student deletedStudent1 = studentManagement.remove(idToDelete1);
        System.out.println("Deleted Student: " + deletedStudent1);
        System.out.println("Student list after deleting:");
        studentManagement.findAll().forEach(System.out::println);
        System.out.println();

        System.out.println("---------------------------------EDIT---------------------------------");
        System.out.println("Enter Student details to Edit:");
        System.out.println("Enter Student Id:");
        int idToEdit = scanner.nextInt(); //Used the bean from BeanConfig.java
        System.out.println("Enter Student Name:");
        String nameToEdit = scanner.next(); //Used the bean from BeanConfig.java
        Student studentToEdit = new Student(idToEdit, nameToEdit);
        Student editedStudent = studentManagement.edit(studentToEdit);
        System.out.println("Edited Student: " + editedStudent);
        System.out.println();
    }
}
