package com.ums.universitymanagementsystemweb.dao;

import com.ums.universitymanagementsystemweb.model.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> findTeachers();
    boolean createTeacher(Teacher teacher);
    boolean updateTeacher(Teacher teacher);
    boolean deleteTeacher(Long id);
    Teacher findByIdTeacher(Long id);
    Teacher searchTeacher();
}
