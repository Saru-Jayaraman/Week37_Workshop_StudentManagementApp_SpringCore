package se.lexicon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDao;
import se.lexicon.exception.StudentNotFoundException;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

import java.util.List;
import java.util.Optional;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    StudentDao studentDao;
    UserInputService userInputService;

    @Autowired
    public StudentManagementConsoleImpl(StudentDao studentDao, UserInputService userInputService) {
        this.studentDao = studentDao;
        this.userInputService = userInputService;
    }

    @Override
    public Student create() {
        String studentName = userInputService.getString();
        if(studentName == null || studentName.trim().isEmpty())
            throw new IllegalArgumentException("IllegalArgumentException: Student Name cannot be null or empty.");
        Student student = new Student(studentName);
        return save(student);
    }

    @Override
    public Student save(Student student) {
        Student createdStudent = studentDao.save(student);
        System.out.println("Student created successfully!");
        return createdStudent;
    }

    @Override
    public Student find(int id) {
        if(id <= 0)
            throw new IllegalArgumentException("IllegalArgumentException: Student Id cannot be zero or negative.");
        Optional<Student> studentOptional = Optional.ofNullable(studentDao.find(id));
        if(!studentOptional.isPresent())
            throw new StudentNotFoundException("StudentNotFoundException: Student Id not found. Entered id: ", id);
        return studentOptional.get();
    }

    @Override
    public Student remove(int id) {
        Student removeStudent = find(id);
        studentDao.delete(id);
        System.out.println("Student deleted successfully!");
        return removeStudent;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        int studentId = student.getId();
        if(studentId <= 0)
            throw new IllegalArgumentException("IllegalArgumentException: Student Id cannot be zero or negative.");
        String studentName = student.getName();
        if(studentName == null || studentName.trim().isEmpty())
            throw new IllegalArgumentException("IllegalArgumentException: Student Name cannot be null or empty.");
        Student foundStudent = find(studentId);
        if(foundStudent.toString().equals(student.toString()))
            throw new IllegalArgumentException("Updation of Student is not needed. Entered data and Stored data is same.");
        studentDao.delete(studentId);
        Student editedStudent = studentDao.save(student);
        System.out.println("Student edited successfully!");
        return editedStudent;
    }
}
