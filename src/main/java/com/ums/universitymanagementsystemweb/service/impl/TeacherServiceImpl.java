package com.ums.universitymanagementsystemweb.service.impl;

import com.ums.universitymanagementsystemweb.dao.TeacherDao;
import com.ums.universitymanagementsystemweb.dao.impl.TeacherDaoImpl;
import com.ums.universitymanagementsystemweb.model.Teacher;
import com.ums.universitymanagementsystemweb.service.TeacherService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao;

    public TeacherServiceImpl() {
        teacherDao = new TeacherDaoImpl();
    }

    @Override
    public void findTeachers(HttpServletRequest req, HttpServletResponse resp) {
        List<Teacher> teacherList = teacherDao.findTeachers();
        req.setAttribute("teacherList", teacherList);
        System.out.println(teacherList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("teacher-list.jsp");
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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("teacher-form.jsp");
        Long id = Long.parseLong(req.getParameter("id"));
        Teacher teacher = teacherDao.findByIdTeacher(id);
        req.setAttribute("teacher", teacher);

        if(!resp.isCommitted()){
            try {
                requestDispatcher.forward(req, resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void newForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("teacher-form.jsp");
        try {
            if (!resp.isCommitted()) {
                requestDispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createTeacher(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String subject = req.getParameter("subject");
        teacherDao.createTeacher(Teacher.builder()
                        .name(name)
                        .email(email)
                        .subject(subject)
                        .build());
        try {
            resp.sendRedirect("teacherList");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTeacher(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String subject = req.getParameter("subject");

        teacherDao.updateTeacher(Teacher.builder()
                .id(id)
                .name(name)
                .email(email)
                .subject(subject)
                .build());

        try {
            resp.sendRedirect("teacherList");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTeacher(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(req.getParameter("id"));
        teacherDao.deleteTeacher(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("teacher-list.jsp");
        try {
            resp.sendRedirect("teacherList");
            if (!resp.isCommitted()) {
                dispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
