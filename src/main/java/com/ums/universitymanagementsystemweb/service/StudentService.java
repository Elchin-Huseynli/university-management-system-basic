package com.ums.universitymanagementsystemweb.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface StudentService {
    void findStudents(HttpServletRequest req, HttpServletResponse resp);
    void editForm(HttpServletRequest req, HttpServletResponse resp);
    void newForm(HttpServletRequest req, HttpServletResponse resp);
    void createStudent(HttpServletRequest req, HttpServletResponse resp);
    void updateStudent(HttpServletRequest req, HttpServletResponse resp);
    void deleteStudent(HttpServletRequest req, HttpServletResponse resp);

}
