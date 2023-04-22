package com.ums.universitymanagementsystemweb.queries;

public class TeacherQuery {
    public final static String CREATE_TEACHER = "insert into teacher(name, email, subject) values (?, ?, ?)";

    public final static String FIND_TEACHERS = "select * from teacher where status = 1";

    public final static String UPDATE_TEACHER = "update teacher set name = ?, email = ?, subject = ? where id = ? and status = 1";

    public final static String DELETE_TEACHER = "update teacher set status = 0 where id = ? and status = 1";

    public final static String FIND_BY_ID_TEACHER = "select * from teacher where id = ? and status = 1 ";
}
