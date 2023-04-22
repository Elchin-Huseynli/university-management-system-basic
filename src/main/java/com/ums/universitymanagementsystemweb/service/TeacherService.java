package com.ums.universitymanagementsystemweb.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TeacherService {
    void findTeachers(HttpServletRequest req, HttpServletResponse resp);
    void editForm(HttpServletRequest req, HttpServletResponse resp);
    void newForm(HttpServletRequest req, HttpServletResponse resp);
    void createTeacher(HttpServletRequest req, HttpServletResponse resp);
    void updateTeacher(HttpServletRequest req, HttpServletResponse resp);
    void deleteTeacher(HttpServletRequest req, HttpServletResponse resp);
}
