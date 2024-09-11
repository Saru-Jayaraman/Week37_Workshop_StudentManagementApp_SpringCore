package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.BeanConfig;
import se.lexicon.config.ComponentScanConfig;
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
        AnnotationConfigApplicationContext contextStudent = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentManagement studentManagement = contextStudent.getBean(StudentManagement.class);
        UserInputService userInputService = contextStudent.getBean(UserInputService.class);

        AnnotationConfigApplicationContext contextScanner = new AnnotationConfigApplicationContext(BeanConfig.class);
        Scanner scanner = contextScanner.getBean(Scanner.class);

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
        int idToFind = userInputService.getInt(); //Used Scanner object of the component: UserInputService //ComponentScanConfig.class
        Student foundStudent1 = studentManagement.find(idToFind);
        System.out.println("Found Student: " + foundStudent1);
        System.out.println();

        System.out.println("-------------------------------FIND ALL-------------------------------");
        System.out.println("Student list:");
        studentManagement.findAll().forEach(System.out::println);
        System.out.println();

        System.out.println("--------------------------------DELETE--------------------------------");
        int idToDelete1 = userInputService.getInt(); //Used Scanner object of the component: UserInputService //ComponentScanConfig.class
        Student deletedStudent1 = studentManagement.remove(idToDelete1);
        System.out.println("Deleted Student: " + deletedStudent1);
        System.out.println("Student list after deleting:");
        studentManagement.findAll().forEach(System.out::println);
        System.out.println();

        System.out.println("---------------------------------EDIT---------------------------------");
        System.out.println("Enter Student details to Edit:");
        System.out.println("Enter Student Id:");
        int idToEdit = scanner.nextInt(); //Used Scanner object of the component: UserInputService //BeanConfig.class
        System.out.println("Enter Student Name:");
        String nameToEdit = scanner.next(); //Used Scanner object of the component: UserInputService //BeanConfig.class
        Student studentToEdit = new Student(idToEdit, nameToEdit);
        Student editedStudent = studentManagement.edit(studentToEdit);
        System.out.println("Edited Student: " + editedStudent);
        System.out.println();
    }
}
