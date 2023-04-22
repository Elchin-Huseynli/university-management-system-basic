package com.ums.universitymanagementsystemweb.dao;

import com.ums.universitymanagementsystemweb.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findStudents();
    boolean createStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(Long id);
    Student findByIdStudent(Long id);
    Student searchStudent();
}
