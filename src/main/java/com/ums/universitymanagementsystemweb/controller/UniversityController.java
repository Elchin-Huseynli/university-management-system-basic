package com.ums.universitymanagementsystemweb.controller;

import com.ums.universitymanagementsystemweb.service.StudentService;
import com.ums.universitymanagementsystemweb.service.TeacherService;
import com.ums.universitymanagementsystemweb.service.impl.StudentServiceImpl;
import com.ums.universitymanagementsystemweb.service.impl.TeacherServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/", name = "UniversityServlet")
public class UniversityController extends HttpServlet {

    private StudentService studentService;
    private TeacherService teacherService;
    @Override
    public void init() {
        this.studentService = new StudentServiceImpl();
        this.teacherService = new TeacherServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getServletPath();
        System.out.println(path);

        if (path.startsWith("/editStudent")) {
            studentService.editForm(req, resp);
        }
        else if (path.startsWith("/editTeacher")){
            teacherService.editForm(req, resp);
        }
        switch (path) {
            case "/studentList":
                studentService.findStudents(req, resp);
                break;
            case "/teacherList":
                teacherService.findTeachers(req, resp);
                break;
            case "/deleteStudent":
                studentService.deleteStudent(req, resp);
                break;
            case "/deleteTeacher":
                teacherService.deleteTeacher(req, resp);
                break;
            default:
                PrintWriter printWriter = resp.getWriter();
                printWriter.write("Invalid option!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getServletPath();
        System.out.println(path);

        switch (path) {
            case "/newStudent":
                studentService.newForm(req, resp);
                break;
            case "/createStudent":
                studentService.createStudent(req, resp);
                break;
            case "/newTeacher":
                teacherService.newForm(req, resp);
                break;
            case "/createTeacher":
                teacherService.createTeacher(req, resp);
                break;
            case "/updateStudent":
                studentService.updateStudent(req, resp);
                break;
            case "/updateTeacher":
                teacherService.updateTeacher(req, resp);
                break;
            default:
                PrintWriter printWriter = resp.getWriter();
                printWriter.write("Invalid option!");
        }
    }
}
