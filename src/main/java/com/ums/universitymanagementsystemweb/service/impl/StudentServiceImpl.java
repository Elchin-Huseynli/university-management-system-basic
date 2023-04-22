package com.ums.universitymanagementsystemweb.service.impl;

import com.ums.universitymanagementsystemweb.dao.StudentDao;
import com.ums.universitymanagementsystemweb.dao.impl.StudentDaoImpl;
import com.ums.universitymanagementsystemweb.model.Student;
import com.ums.universitymanagementsystemweb.service.StudentService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl() {
        studentDao = new StudentDaoImpl();
    }

    @Override
    public void findStudents(HttpServletRequest req, HttpServletResponse resp) {
        List<Student> studentList = studentDao.findStudents();
        req.setAttribute("studentList", studentList);
        System.out.println(studentList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student-list.jsp");
        try {
            if (!resp.isCommitted()) {
                requestDispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student-form.jsp");
        Long id = Long.parseLong(req.getParameter("id"));
        Student student = studentDao.findByIdStudent(id);
        req.setAttribute("student", student);

        if(!resp.isCommitted()){
            try {
                requestDispatcher.forward(req,resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void newForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student-form.jsp");
        try {
            if (!resp.isCommitted()) {
                requestDispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createStudent(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String subject = req.getParameter("subject");

        studentDao.createStudent(Student.builder()
                        .name(name)
                        .email(email)
                        .subject(subject)
                        .build());

        try {
            resp.sendRedirect("studentList");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String subject = req.getParameter("subject");

        studentDao.updateStudent(Student.builder()
                        .id(id)
                        .name(name)
                        .email(email)
                        .subject(subject)
                        .build());

        try {
            resp.sendRedirect("studentList");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudent(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(req.getParameter("id"));
        studentDao.deleteStudent(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("student-list.jsp");
        try {
            resp.sendRedirect("studentList");
            if (!resp.isCommitted()) {
                dispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
