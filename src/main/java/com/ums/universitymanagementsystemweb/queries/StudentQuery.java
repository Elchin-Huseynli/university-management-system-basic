package com.ums.universitymanagementsystemweb.queries;

public class StudentQuery {
    public final static String CREATE_STUDENT = "insert into student(name, email, subject) values (?, ?, ?)";

    public final static String FIND_STUDENTS = "select * from student where status = 1";

    public final static String UPDATE_STUDENT = "update student set name = ?, email = ?, subject = ? where id = ? and status=1";

    public final static String DELETE_STUDENT = "update student set status = 0 where id = ? and status = 1";

    public final static String FIND_BY_ID_STUDENT = "select * from student where id = ? and status = 1 ";
}
